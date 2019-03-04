package medStack.dockerDemo;

import java.util.Date;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.ContainerPort;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;

@SpringBootApplication
public class DockerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerDemoApplication.class, args);
		
//		DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder()
//				  .withDockerHost("tcp://34.73.14.11:2375")
//				  .withDockerTlsVerify(false)
//				  .build();
//		DockerClient dockerClient = DockerClientBuilder.getInstance(config)
//				  .build();
//		List<Container> containersList = dockerClient.listContainersCmd().exec();
//		String containerId, image, command, status;
//		String[] names;
//		Long created;
//		ContainerPort[] ports;
//		for (Container c: containersList) {
//			containerId = c.getId().substring(0, 12);
//			System.out.println("CONTAINER ID: " + containerId); //ready
//			image = c.getImage();
//			System.out.println("IMAGE: " + image); //ready
//			command = c.getCommand();
//			System.out.println("COMMAND: " + command); //ready
//			created = c.getCreated();
//			Date date = new Date(created*1000);
//			System.out.println("CREATED: " + date); //needs to say how long ago
//			status = c.getStatus();
//			System.out.println("STATUS: " + status); //ready
//			ports = c.getPorts();
//			String portsStr = "";
//			for (ContainerPort p: ports) {
//				if(portsStr.isEmpty()) {
//					portsStr = p.getPrivatePort() + "/" + p.getType();
//				} else {
//					portsStr = portsStr + ", " + p.getPrivatePort() + "/" + p.getType();
//				}
//			}
//			System.out.println("PORTS: " + portsStr); //ready
//			names = c.getNames();
//			for (String n : names) {
//				String name = n.substring(1, n.length());
//				System.out.println("NAMES: " + name); //needs to print multiple names
//			}
//		}
	}
}


// e1013a4b1c36
//CONTAINER ID        IMAGE                COMMAND                  CREATED             STATUS                  PORTS                 NAMES
//e1013a4b1c36        mysql/mysql-server   "/entrypoint.sh mysq…"   30 hours ago        Up 30 hours (healthy)   3306/tcp, 33060/tcp   mysql1

//CONTAINER ID        IMAGE                COMMAND                  CREATED             STATUS                 PORTS                 NAMES
//d86d5358c310        mysql/mysql-server   "/entrypoint.sh my..."   21 hours ago        Up 4 hours (healthy)   3306/tcp, 33060/tcp   mysql1



