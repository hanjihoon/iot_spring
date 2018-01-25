package com.iot.spring;

public class HelloSpring {
	private String t = null;
	private String tt = null;
	public HelloSpring() {
		System.out.println("HelloSpring 생성자 호출됐슈");
	}
	public void setA(String str) {
		this.t=str;
	}
	public String getA() {
		return this.t;
	}
	public void setB(String str) {
		this.tt=str;
	}
	public String getB() {
		return this.tt;
	}
}
