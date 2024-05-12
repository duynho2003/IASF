package com.mytech.pretest1.controllers;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mytech.pretest1.entities.Laptop;
import com.mytech.pretest1.services.LaptopService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/laptops")
public class LaptopController {

	@Autowired
	private LaptopService laptopService;
	
	@GetMapping
	public ModelAndView laptopHome() {
		List<Laptop> listLaptops = laptopService.listAll();
		
		ModelAndView mav = new ModelAndView("laptops");
		mav.addObject("listLaptops", listLaptops);

		return mav;
	}
	
	@GetMapping("/add")
	public String addLaptop(Map<String, Object> model) {
		Laptop laptop = new Laptop();
		model.put("laptop", laptop);

		return "add";
	}
	
	@GetMapping("/edit")
	public String editLaptop(@RequestParam("id") long id, Model model) {
		Laptop laptop = laptopService.get(id);
		model.addAttribute("laptop", laptop);
		return "edit";
	}
	
	@GetMapping("/delete")
	public String deleteLaptop(@RequestParam("id") long id, Model model) {
		laptopService.delete(id);

		return "redirect:/laptops";
	}
	
	@PostMapping(value = "/save")
	public String saveBook(@RequestParam("file") MultipartFile file, @ModelAttribute("laptop") Laptop laptop,
			HttpServletRequest request) {

		// Save file
		System.out.println("File info: " + file.getOriginalFilename());
		String orgName = "";

		if (!file.isEmpty()) {
			try {
				String uploadsDir = "/uploads/";
				String realPathtoUploads = request.getServletContext().getRealPath(uploadsDir);
				if (!new File(realPathtoUploads).exists()) {
					new File(realPathtoUploads).mkdir();
				}

				System.out.println("Uploaded: " + realPathtoUploads);

				orgName = file.getOriginalFilename();
				String filePath = realPathtoUploads + orgName;
				File dest = new File(filePath);
				file.transferTo(dest);
			} catch (Exception e) {
				System.out.println("exception");
			}
		}

		System.out.println("Save laptop:" + laptop.getId() + " - " + laptop.getTitle());

		laptop.setImage(orgName);
		laptopService.save(laptop);
		
		return "redirect:/laptops";
	}

	@PostMapping("/update")
	public String updateLaptop(@ModelAttribute("laptop") Laptop laptop) {
		laptopService.update(laptop);
		
		return "redirect:/laptops";
	}
	
	@GetMapping("/search")
	public ModelAndView bookSearch(@RequestParam("searchText") String searchText) {
		List<Laptop> listLaptops = laptopService.search(searchText);

		ModelAndView mav = new ModelAndView("laptops");
		mav.addObject("listLaptops", listLaptops);
		return mav;
	}
}
