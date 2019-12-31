package app.docker;

import java.util.List;

public class DockerStatus {

    private Long id;
    private Boolean statusGood;
    private List<DockerContainers> containersList;

    public DockerStatus() {
    }

    public DockerStatus(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isStatusGood() {
        return statusGood;
    }

    public void setStatusGood(Boolean statusGood) {
        this.statusGood = statusGood;
    }

    public List<DockerContainers> getContainersList() {
        return containersList;
    }

    public void setContainersList(List<DockerContainers> containersList) {
        this.containersList = containersList;
    }
}
