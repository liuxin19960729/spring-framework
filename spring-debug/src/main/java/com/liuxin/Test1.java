package com.liuxin;

import com.liuxin.entity.InnertClassTest;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;
public class Test1 {
	public static void main(String[] args) {

		GenericApplicationContext applicationContext = new GenericApplicationContext();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
		reader.setValidating(true);
		reader.loadBeanDefinitions(new ClassPathResource("application.xml"));
		applicationContext.refresh();
		InnertClassTest bean = applicationContext.getBean(InnertClassTest.class);
		System.out.println(bean.getA()==applicationContext.getBean("ss"));

	}
}
