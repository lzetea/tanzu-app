package com.tanzu.app.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tanzu.app.domain.Hello;
import com.tanzu.app.repository.HelloRepository;

@Controller
public class HelloController {

	private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

	private HelloRepository helloRepository;

	private final AtomicInteger counter = new AtomicInteger();

	public HelloController(HelloRepository helloRepository) {
		this.helloRepository = helloRepository;
	}

	@GetMapping("/")
	public String greeting(Model model) {
		LOG.debug("Looking for hellos");
		List<Hello> hellos = helloRepository.findAllEagered();
		model.addAttribute("hello", hellos.get(counter.getAndIncrement() % hellos.size()));
		return "hello";
	}

}
