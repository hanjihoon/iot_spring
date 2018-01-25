package com.iot.spring.xml2;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Order(value=1)
@Service("aaa")
public class Audi implements Maker {

	@Override
	public void printName() {
		System.out.println("Audi~~~~");
	}

}
