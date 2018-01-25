package com.iot.spring.xml2;


import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(value=2)
@Component("kkk")
@Scope("prototype")
public class Kia implements Maker {
	
	public void printName() {
		System.out.println("기아차~~~");
	}

}
