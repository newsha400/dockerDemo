package medStack.dockerDemo;

import java.time.Instant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DockerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerDemoApplication.class, args);
		
		long epoch = 1551581276;
		Instant instant = Instant.now();
		long timeStampSeconds = instant.getEpochSecond();
		long secondsAgo = timeStampSeconds - epoch;
		System.out.println(secondsAgo);
	}
}


//CONTAINER ID        IMAGE                COMMAND                  CREATED             STATUS                 PORTS                 NAMES
//d86d5358c310        mysql/mysql-server   "/entrypoint.sh my..."   21 hours ago        Up 4 hours (healthy)   3306/tcp, 33060/tcp   mysql1



