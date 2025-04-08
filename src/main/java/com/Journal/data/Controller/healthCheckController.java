package com.Journal.data.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class healthCheckController {

	@GetMapping("/health-Check")
	public String healthCheck() {
		return "OKwithchild";
		
	}
}
