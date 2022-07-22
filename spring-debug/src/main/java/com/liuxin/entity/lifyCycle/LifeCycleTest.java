package com.liuxin.entity.lifyCycle;

import org.springframework.context.Lifecycle;
import org.springframework.context.SmartLifecycle;

public class LifeCycleTest implements Lifecycle {
	@Override
	public void start() {
		System.out.println("start");
	}

	@Override
	public void stop() {
		System.out.println("stop");
	}

	@Override
	public boolean isRunning() {
		return false;
	}
}
