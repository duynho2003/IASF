package com.mytech.pretest1.controllers;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.ServletContextResource;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		
		return "index";
	}

	@ResponseBody
	@RequestMapping(value = "/resources", method = RequestMethod.GET)
	public ResponseEntity<Resource> getImageAsResource(HttpServletRequest request) {
		HttpHeaders headers = new HttpHeaders();
		Resource resource = new ServletContextResource(request.getServletContext(), "/WEB-INF/resources/pom.xml");
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
}
