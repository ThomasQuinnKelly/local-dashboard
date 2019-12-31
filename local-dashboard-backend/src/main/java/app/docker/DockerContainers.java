package app.docker;

public class DockerContainers {

    private Long id;
    private Boolean statusGood;
    private String containerName;

    public DockerContainers() {

    }

    public DockerContainers(Long id, Boolean statusGood, String containerName) {
        this.id = id;
        this.statusGood = statusGood;
        this.containerName = containerName;
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

    public String getContainerName() {
        return containerName;
    }

    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }
}
