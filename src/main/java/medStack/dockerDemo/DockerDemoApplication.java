package medStack.dockerDemo;

import org.glassfish.jersey.internal.inject.InjectionManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.ListContainersCmd;
import com.github.dockerjava.api.model.Info;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;

@SpringBootApplication
public class DockerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerDemoApplication.class, args);
		
		System.out.println("Newsha");
		
		String dockerVersion = DefaultDockerClientConfig.API_VERSION;
//		System.out.println(dockerVersion);
		
		DockerClient docker = DockerClientBuilder.getInstance().build();
		ListContainersCmd containerList = docker.listContainersCmd();
//		System.out.println(containerList);
		
//		DockerClient dockerClient = DefaultDockerClientConfig.DOCKER_HOST;
//		String dockerClient = DefaultDockerClientConfig.DOCKER_HOST;
		
		
		DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder()
				  .withDockerHost("tcp://localhost:3128")
				  .build();
		DockerClient dockerClient = DockerClientBuilder.getInstance(config)
				  .build();
		Info info = dockerClient.infoCmd().exec();
		System.out.print(info);
//		dockerClient.listContainersCmd();
//		System.out.println(dockerClient.toString());
	}

}
