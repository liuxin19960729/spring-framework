package com.liuxin.entity;

public class FMethod {
	public FMethod(int a) {
		System.out.println(a);
	}
/*
* 调用静态方法获取对象
*
* 单例
<bean id="fmethod" class="com.liuxin.entity.FMethod" factory-method="factory">
		<constructor-arg index="0" value="1"></constructor-arg>
</bean>
*多个
* 	<bean id="fmethod" class="com.liuxin.entity.FMethod" factory-method="factory" scope="prototype">
		<constructor-arg index="0" value="1"></constructor-arg>
	</bean>
*
* */
	public static FMethod factory(int a) {
		System.out.println("static factory()");
		return new FMethod(a);
	}
}
