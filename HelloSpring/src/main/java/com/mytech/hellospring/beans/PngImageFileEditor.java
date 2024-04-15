package com.mytech.hellospring.beans;

import org.springframework.stereotype.Component;

@Component("PngEditor")
public class PngImageFileEditor implements ImageFileEditor {
	
	@Override
	public String readImage(String fileName) {
		System.out.println("Reading image with PNG format...");
		return "Proccessed PNG Image!";
	}
}
