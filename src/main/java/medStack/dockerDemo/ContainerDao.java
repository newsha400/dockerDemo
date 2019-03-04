package medStack.dockerDemo;

import java.util.List;
import org.springframework.stereotype.Component;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;

@Component
public class ContainerDao {

	public List<Container> getContainers() {
		DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder()
				  .withDockerHost("tcp://34.73.14.11:2375")
				  .withDockerTlsVerify(false)
				  .build();
		DockerClient dockerClient = DockerClientBuilder.getInstance(config)
				  .build();
		List<Container> containersList = dockerClient.listContainersCmd().exec();
		return containersList;
	}
}
