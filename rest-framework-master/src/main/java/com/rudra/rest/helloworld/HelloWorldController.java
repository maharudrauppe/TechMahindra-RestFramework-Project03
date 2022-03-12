package com.rudra.rest.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping(path="/")
	public String helloWorld() {
			return "Hello";
	}
	
	
	@GetMapping(path="/hello-world")
	public HelloWorldBean helloWorldBean() {
			return new HelloWorldBean("Hello World");
	}
	
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPath(@PathVariable String name) {
			return new HelloWorldBean("Hello!! " + name);
	}
}
