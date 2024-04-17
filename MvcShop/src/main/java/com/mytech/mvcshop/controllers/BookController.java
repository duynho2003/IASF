package com.mytech.mvcshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mytech.mvcshop.entities.Book;
import com.mytech.mvcshop.services.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping
	public ModelAndView bookHome() {
		List<Book> listBooks = bookService.listAll();
		
		ModelAndView mav = new ModelAndView("books");
		mav.addObject("listBooks", listBooks);
		
		return mav;
	}
}
