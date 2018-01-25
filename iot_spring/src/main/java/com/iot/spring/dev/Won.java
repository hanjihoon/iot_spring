package com.iot.spring.dev;

import org.springframework.stereotype.Component;

@Component("Won")
public class Won {
	private int money;

	public Won() {
		System.out.println("원리 생성된다고?");
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
}
