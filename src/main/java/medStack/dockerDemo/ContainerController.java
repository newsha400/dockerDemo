package medStack.dockerDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContainerController {
	@Autowired
	ContainerService containerService;
	
	@RequestMapping(value="/dockerps", method = RequestMethod.GET)
	public ContainerModel getContainers() {
		return containerService.getContainers();
	}
	

}
