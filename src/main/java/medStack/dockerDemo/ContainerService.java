package medStack.dockerDemo;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.ContainerPort;

@Component
public class ContainerService {
	@Autowired
	ContainerDao containerDao;

	public ContainerModel getContainers() {
		List<Container> containersList = containerDao.getContainers();
		String containerId = "";
		String image = "";
		String command = "";
		String status = "";
		String[] namesArray;
		Long createdUnix;
		ContainerPort[] portsArray;
		String names = "";
		String ports = "";
		String created = "";
		for (Container c: containersList) {
			containerId = c.getId().substring(0, 12);
			System.out.println("CONTAINER ID: " + containerId); //ready
			image = c.getImage();
			System.out.println("IMAGE: " + image); //ready
			command = c.getCommand();
			System.out.println("COMMAND: " + command); //ready
			createdUnix = c.getCreated();
			Date date = new Date(createdUnix*1000);
			created = date.toString();
			System.out.println("CREATED: " + created); //needs to say how long ago
			status = c.getStatus();
			System.out.println("STATUS: " + status); //ready
			portsArray = c.getPorts();
			for (ContainerPort p: portsArray) {
				if(ports.isEmpty()) {
					ports = p.getPrivatePort() + "/" + p.getType();
				} else {
					ports = ports + ", " + p.getPrivatePort() + "/" + p.getType();
				}
			}
			System.out.println("PORTS: " + ports); //ready
			namesArray = c.getNames();
			for (String n : namesArray) {
				names = n.substring(1, n.length());
				System.out.println("NAMES: " + names); //needs to print multiple names
			}
		}
		ContainerModel containerModel = new ContainerModel(containerId, image, command, created, status, ports, names);
		return containerModel;
	}
}
