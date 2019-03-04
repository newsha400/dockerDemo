package medStack.dockerDemo;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.ContainerPort;

@Component
public class ContainerService {
	@Autowired
	ContainerDao containerDao;

	public List<ContainerModel> getContainers() {
		List<Container> containersList = containerDao.getContainers();
		String containerId = "";
		String image = "";
		String command = "";
		String status = "";
		String[] namesArray;
		long createdUnix;
		ContainerPort[] portsArray;
		String names = "";
		String ports = "";
		String created = "";
		List<ContainerModel> containerModelList = new ArrayList<ContainerModel>();
		for (Container c: containersList) {
			containerId = c.getId().substring(0, 12);
			System.out.println("CONTAINER ID: " + containerId); 
			image = c.getImage();
			System.out.println("IMAGE: " + image); 
			command = c.getCommand();
			System.out.println("COMMAND: " + command); 
			createdUnix = c.getCreated();
			System.out.println(createdUnix);
			Instant instant = Instant.now();
			long now = instant.getEpochSecond();
			long secondsAgo = now - createdUnix;
			System.out.println(secondsAgo);
			if (secondsAgo<=60) {
				created = secondsAgo + " seconds ago";		
			} else if(secondsAgo<=3600){
				created = secondsAgo/60 + " minutes ago";
			} else {
				created = secondsAgo/3600 + " hours ago";
			} 
			System.out.println("CREATED: " + created); //correct the grammar 
			status = c.getStatus();
			System.out.println("STATUS: " + status); 
			ports = "";
			portsArray = c.getPorts();
			for (ContainerPort p: portsArray) {
				if(ports.isEmpty()) {
					ports = p.getPrivatePort() + "/" + p.getType();
				} else {
					ports = ports + ", " + p.getPrivatePort() + "/" + p.getType();
				}
			}
			System.out.println("PORTS: " + ports); 
			namesArray = c.getNames();
			for (String n : namesArray) {
				names = n.substring(1, n.length());
				System.out.println("NAMES: " + names); //needs to print multiple names
			}
			ContainerModel containerModel = new ContainerModel(containerId, image, command, created, status, ports, names);
			containerModelList.add(containerModel);
			
		}
		return containerModelList;
	}
}
