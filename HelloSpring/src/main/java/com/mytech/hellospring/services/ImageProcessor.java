package com.mytech.hellospring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.mytech.hellospring.beans.ImageFileEditor;

@Component("ImageProcessor")
public class ImageProcessor {
	
	@Autowired
	@Qualifier("PngEditor")
	private ImageFileEditor imageFileEditor;
	
	public void rendering() {
		String result = imageFileEditor.readImage("MyFile");
		System.out.println("ImageProcessor: " + result);
	}
	
	public void publishImage() {
		System.out.println("----> ImageProcessor: publishing...");
	}
}
