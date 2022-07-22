package com.liuxin.entity;

import org.springframework.context.annotation.Configuration;

import java.beans.ConstructorProperties;
import java.util.Properties;

public class InnertClassTest {
	//	@ConstructorProperties({"a","b"})
	public InnertClassTest(int a, String b) {
		System.out.println(a);
		System.out.println(b);
	}

	private A a;

	public void setA(A a) {
		this.a = a;
	}

	public A getA() {
		return a;
	}
}
