package com.liuxin;

import com.liuxin.entity.*;
import com.liuxin.entity.lifyCycle.LifeCycleTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("application.xml");
//		Object ac = applicationContext.getBean("ac");
//		A a = applicationContext.getBean(A.class);
//		System.out.println(a);
//		a = applicationContext.getBean(A.class);
//		System.out.println(a==ac);
//
//		Object bbb = applicationContext.getBean("bbb");
//		B bean = applicationContext.getBean(B.class);
//		System.out.println(bean);
//		bean = applicationContext.getBean(B.class);
//		System.out.println(bean==bbb);
////		BeanFactory
////		Object cldbp = applicationContext.getBean("cldbp");
////		System.out.println(cldbp);
//		System.out.println(applicationContext.getBean("c"));

//		FMethod bean1 = applicationContext.getBean(FMethod.class);
//		System.out.println(bean1);
//		FMethod bean2 = applicationContext.getBean(FMethod.class);
//		System.out.println(bean2);

		Object liuxinDepend = applicationContext.getBean("liuxinDepend");
		System.out.println(liuxinDepend);
	}
}
