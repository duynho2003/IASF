package com.mytech.pretest2.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.servlet.ModelAndView;

import com.mytech.pretest2.entities.EBook;
import com.mytech.pretest2.services.EBookService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class EBookController{
	
	@Autowired
	private EBookService eBookService;

	@GetMapping("/")
	public ModelAndView home() {
		List<EBook> listeBook = eBookService.listAll();
		
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listeBook", listeBook);
		
		return mav;
	}
	
	@GetMapping("/add")
	public String add(Map<String, Object> model) {
		EBook ebook = new EBook();
		model.put("ebook", ebook);
		
		return "add";
	}
	
	@PostMapping(value = "/save")
	public String saveEbook(@ModelAttribute("ebook") EBook ebook, HttpServletRequest request) {
		
		System.out.println("Save ebook:" + ebook.getId() + " - " + ebook.getTitle());

		eBookService.save(ebook);
		
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String getDeleteBook() {
		return "delete";
	}
	
	@PostMapping("/delete")
	public String deleteBook( @RequestParam("id") int id) {
		eBookService.delete(id);
		return "redirect:/";
	}

	@ResponseBody
	@RequestMapping(value = "/resources", method = RequestMethod.GET)
	public ResponseEntity<Resource> getImageAsResource(HttpServletRequest request) {
		HttpHeaders headers = new HttpHeaders();
		Resource resource = new ServletContextResource(request.getServletContext(), "/WEB-INF/resources/pom.xml");
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
}
