package org.accp.office.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("all")
public class SpringBeanUtil {

	private static ApplicationContext ac;

	private static final String DEFAULT_CONFIG_FILE = "spring.xml";

	static {
		try {
			ac = new ClassPathXmlApplicationContext(DEFAULT_CONFIG_FILE);
		} catch (Exception ex) {
			LoggerUtil.error(ex.getMessage());
		}
	}

	public static <T> T getBeanByName(String name) {
		return (T) ac.getBean(name);
	}
}
