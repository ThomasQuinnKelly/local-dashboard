package app.docker;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class DockerController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/docker/status")
    public ResponseEntity<DockerStatus> status() throws IOException {

        HttpHeaders headers = new HttpHeaders();

        headers.add("Access-Control-Allow-Origin", "http://localhost:3000");

        ResponseEntity result = new ResponseEntity<>(DockerImpl.status(counter), headers, HttpStatus.OK);

        return result;


    }

//    counter.incrementAndGet(),
//    String.format(template, name)


}
