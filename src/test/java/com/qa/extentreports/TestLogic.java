package com.qa.extentreports;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogic {

	@Test
	public void m1() {
		System.out.println('K');
		Assert.assertEquals(false,true);
		
	}
	@Test
	public void m2() {
		System.out.println('K'+'K'+"K");
		Assert.assertEquals(false,true);
		
	}
	
	
}
