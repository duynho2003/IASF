package com.mytech.hellospring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mytech.hellospring.beans.HelloMessageImpl;
import com.mytech.hellospring.services.ImageProcessor;

public class TestMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		appContext.scan("com.mytech.hellospring");
		appContext.refresh();

		ImageProcessor imageProcessor = (ImageProcessor) appContext.getBean("ImageProcessor");
		imageProcessor.rendering();
		imageProcessor.publishImage();

		// XML
		ApplicationContext appXmlContext = new ClassPathXmlApplicationContext("app_beans.xml");
		HelloMessageImpl helloBean = appXmlContext.getBean("HelloMessage", HelloMessageImpl.class);
		helloBean.greetUser();
	}

}
