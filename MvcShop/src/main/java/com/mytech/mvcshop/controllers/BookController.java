package com.mytech.mvcshop.controllers;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mytech.mvcshop.dtos.BookOrderDto;
import com.mytech.mvcshop.entities.Book;
import com.mytech.mvcshop.services.BookService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping
	public ModelAndView bookHome() {
		List<Book> listBooks = bookService.listAll();
		BookOrderDto bookOrderDto = new BookOrderDto();

		ModelAndView mav = new ModelAndView("books");
		mav.addObject("listBooks", listBooks);
		mav.addObject("bookOrder", bookOrderDto);

		return mav;
	}

	@GetMapping("/add")
	public String addBook(Map<String, Object> model) {
		Book book = new Book();
		model.put("book", book);

		return "add_book";
	}

	@PostMapping(value = "/save")
	public String saveBook(@RequestParam("file") MultipartFile file, @ModelAttribute("book") Book book, HttpServletRequest request) {

		// Save file Upload
//		System.out.println("File info: " + file.getOriginalFilename());
//		String orgName = "";
//
//		if (!file.isEmpty()) {
//			try {
//				String uploadsDir = "/uploads/";
//				String realPathtoUploads = request.getServletContext().getRealPath(uploadsDir);
//				if (!new File(realPathtoUploads).exists()) {
//					new File(realPathtoUploads).mkdir();
//				}
//
//				System.out.println("Uploaded: " + realPathtoUploads);
//
//				orgName = file.getOriginalFilename();
//				String filePath = realPathtoUploads + orgName;
//				File dest = new File(filePath);
//				file.transferTo(dest);
//			} catch (Exception e) {
//				System.out.println("exception");
//			}
//		}

		System.out.println("Book: " + book.getTitle() + " -- " + book.getAuthor());
		
//		book.setImage(orgName);
		bookService.save(book);

		return "redirect:/books";
	}

	@PostMapping("/addcart")
	public String addCart() {
		System.out.println("------");
		return "index";
	}
}
