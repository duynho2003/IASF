package com.mytech.hellospring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.mytech.hellospring"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

}
