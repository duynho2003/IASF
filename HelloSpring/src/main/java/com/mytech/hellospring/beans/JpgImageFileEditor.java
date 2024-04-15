package com.mytech.hellospring.beans;

import org.springframework.stereotype.Component;

@Component("JpgEditor")
public class JpgImageFileEditor implements ImageFileEditor {
	
	@Override
	public String readImage(String fileName) {
		System.out.println("Reading image with JPG format...");
		return "Proccessed JPG Image!";
	}
}
