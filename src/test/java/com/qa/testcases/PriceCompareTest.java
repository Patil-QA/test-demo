package com.qa.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.Amazonpages.AmazonHomePage;
import com.qa.Amazonpages.AmazonMobilePage;
import com.qa.Amazonpages.AppleSearchResultPage;
import com.qa.testBase.TestBase;

public class PriceCompareTest extends TestBase {
	 AmazonHomePage Ap;
	 AmazonMobilePage Amp;
	 AppleSearchResultPage Asrp;
	
	@BeforeClass
	public void initializePageClasses() {
		 Ap=new AmazonHomePage(driver);
		 Amp=Ap.clickOnMobileMenu(driver);
		 Asrp=Amp.clickOnAppleMobile(driver);
	}
	
	@Test
	public void amoazonAppleDetails() {
		System.out.println("Test Started");
		Asrp.filterTheResultfor8Gb();
		System.out.println("Now on Result Page");
	String Apple13OnAmazon=Asrp.appleiPhone13Title()+"-"+Asrp.appleiPhone13Price()+"-"+Asrp.AmazonTitleWithURL(driver);
	System.out.println(Apple13OnAmazon);
	}
	

}
