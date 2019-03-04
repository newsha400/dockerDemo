package medStack.dockerDemo;

public class ContainerModel {
	String containerId;
	String image;
	String command;
	String created;
	String status;
	String ports;
	String names;
	public ContainerModel(String containerId, String image, String command, String created, String status, String ports,
			String names) {
		super();
		this.containerId = containerId;
		this.image = image;
		this.command = command;
		this.created = created;
		this.status = status;
		this.ports = ports;
		this.names = names;
	}
	public String getContainerId() {
		return containerId;
	}
	public void setContainerId(String containerId) {
		this.containerId = containerId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPorts() {
		return ports;
	}
	public void setPorts(String ports) {
		this.ports = ports;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
}
