package com.qa.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.Flipkartpages.FlipCartHomePage;
import com.qa.Flipkartpages.FlipkartMobilePage;
import com.qa.testBase.TestBase;

public class FlipkartAppleTest extends TestBase {
	FlipCartHomePage fhp;
	FlipkartMobilePage fmp;

	@BeforeClass
	public void initiatePageClasses() {
		 fhp=new FlipCartHomePage(driver);
		 fmp=fhp.clickOnMobileMenu(driver);
	}
	
	@Test
	public void flipkartAppleDetails() {
		String flipKartApple=fmp.appleiPhone13Details()+"-"+fmp.appleiPhonePrice()
		 					+" "+fmp.applePageURL(driver);
		System.out.println(flipKartApple);
	}
	

}
