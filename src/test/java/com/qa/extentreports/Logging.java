package com.qa.extentreports;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logging {
	
	private static Logger log=LogManager.getLogger();
	
	public static void main(String[] args) {
		log.debug("System started");
		log.info("Goog Morning");
		log.warn("Good evening");
		log.fatal("Good Night");
		log.error("Good AfterNoon");
		log.always();
		log.atDebug();
		log.traceEntry().getMessage();
		log.error("Error is", new RuntimeException());
		
		System.out.println("============Kishor==============");
	}

}
