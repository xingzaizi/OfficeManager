package org.accp.office.util;

import org.apache.log4j.Logger;

public class LoggerUtil {
	static Logger logger;
	static {
		logger = Logger.getLogger(Object.class);
	}
	public static Logger getLogger() {
		return logger;
	}
	
	public static void info(String msg) {
		logger.info(msg);
	}
	
	public static void debug(String msg) {
		logger.debug(msg);
	}
	
	public static void error(String msg) {
		logger.error(msg);
	}
}
