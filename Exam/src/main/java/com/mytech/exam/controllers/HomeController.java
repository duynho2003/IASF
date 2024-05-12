package com.mytech.exam.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.servlet.ModelAndView;

import com.mytech.exam.entities.Category;
import com.mytech.exam.entities.Product;
import com.mytech.exam.services.CategoryService;
import com.mytech.exam.services.ProductService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/")
	public ModelAndView home() {
		List<Product> listProducts = productService.listAll();
		List<Category> listCategories = categoryService.listAll();
		
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listProducts", listProducts);
		mav.addObject("listCategories", listCategories);
		
		return mav;
	}
	
	@GetMapping("/add")
	public String addProduct(Map<String, Object> model) {
		Product product = new Product();
		Category category = new Category();
		model.put("product", product);
		model.put("category", category);
		
		return "add";
	}

	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("id") long id, Model model) {
		productService.delete(id);
		
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
