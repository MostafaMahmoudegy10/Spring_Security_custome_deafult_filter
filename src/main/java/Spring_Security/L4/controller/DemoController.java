package Spring_Security.L4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController { 

	@GetMapping()
	public String demo() {
		return "this is mostafa";
	}
}
