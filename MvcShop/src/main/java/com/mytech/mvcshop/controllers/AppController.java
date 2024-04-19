package com.mytech.mvcshop.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.ServletContextResource;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AppController {

	@GetMapping("/")
	public String home(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
		String serverTime = dateFormat.format(date);

		model.addAttribute("serverTime", serverTime);

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
