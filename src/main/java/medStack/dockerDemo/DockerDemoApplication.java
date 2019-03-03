package medStack.dockerDemo;

import java.util.List;

import org.glassfish.jersey.internal.inject.InjectionManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.ListContainersCmd;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.Info;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;

@SpringBootApplication
public class DockerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerDemoApplication.class, args);
		
		System.out.println("start to build config");
		DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder()
				  .withDockerHost("tcp://34.73.14.11:2375")
				  .withDockerTlsVerify(false)
				  .build();
		System.out.println("start to build docker client");
		DockerClient dockerClient = DockerClientBuilder.getInstance(config)
				  .build();
		System.out.println("Start to make info");
		Info info = dockerClient.infoCmd().exec();
		System.out.println("start to print info");
		System.out.print(info);
//		List<Container> containersList = dockerClient.listContainersCmd().exec();
//		for (Container c: containersList) {
//			System.out.println(c.toString());
//		}
	}
}
