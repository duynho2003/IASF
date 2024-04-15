package com.mytech.mvcshop.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer{

	private static final String UPLOAD_FOLDER = "/tmp";
	private static final int MAX_UPLOAD_SIZE = 5 * 1024 * 1024;
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext(); 
		appContext.register(WebMvcConfig.class);
		
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher", new DispatcherServlet(appContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
		//File Upload
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(UPLOAD_FOLDER,
		MAX_UPLOAD_SIZE, MAX_UPLOAD_SIZE * 2L, MAX_UPLOAD_SIZE / 2);

		dispatcher.setMultipartConfig(multipartConfigElement);
	}

}
