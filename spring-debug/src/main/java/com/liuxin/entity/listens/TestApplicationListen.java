package com.liuxin.entity.listens;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class TestApplicationListen implements ApplicationListener<ApplicationEvent> {
	public TestApplicationListen(){
		System.out.println("TestApplicationListen()");
	}
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("event");
	}
}
