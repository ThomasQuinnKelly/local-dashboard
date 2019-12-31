package app.docker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class DockerImpl {
    public static DockerStatus status(AtomicLong atomicLong) throws IOException {

        DockerStatus result = new DockerStatus(atomicLong.incrementAndGet());

        ArrayList<DockerContainers> dockerContainerList = new ArrayList<>();

        result.setStatusGood(checkDockerStatus_And_FillList(dockerContainerList, atomicLong));

            result.setContainersList(dockerContainerList);

        return result;
    }

    private static boolean checkDockerStatus_And_FillList(ArrayList<DockerContainers> dockerContainerList, AtomicLong atomicLong) throws IOException {
        Runtime rt = Runtime.getRuntime();
        Process pr = rt.exec("docker ps -a");

        BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));

        String line=null;

        if (input.readLine() == null) {
            return false;
        }

        while((line=input.readLine()) != null) {
            if (!line.startsWith("CONTAINER")) {
                String containerName = line.substring(line.lastIndexOf(" ")+1, line.length());
                dockerContainerList.add(new DockerContainers(atomicLong.incrementAndGet(),  !line.contains("Exited"), containerName));
            }

        }

        return true;
    }
}
