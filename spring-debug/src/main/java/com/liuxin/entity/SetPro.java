package com.liuxin.entity;

public class SetPro {
	private A _a;
/*
*
*	<bean id="setP" class="com.liuxin.entity.SetPro">
		<property name="_a" ref="A"></property>
	</bean>
* */
	public void set_a(A a) {
		System.out.println("set");
		System.out.println(a);
		this._a = a;
	}

}
