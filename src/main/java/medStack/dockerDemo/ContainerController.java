package medStack.dockerDemo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContainerController {
	@Autowired
	ContainerService containerService;
	
	@CrossOrigin
	@RequestMapping(value="/dockerps", method = RequestMethod.GET)
	public List<ContainerModel> getContainers() {
		return containerService.getContainers();
	}	
}
