package com.qa.Amazonpages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonHomePage {
	private  WebDriverWait wait;
	@FindBy(xpath="//a[text()='Mobiles']")
	private WebElement MobileMenu;
	 
	
	public AmazonHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	    wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	}

	public AmazonMobilePage clickOnMobileMenu(WebDriver driver) {
		wait.until(ExpectedConditions.elementToBeClickable(MobileMenu)).click();
	return new AmazonMobilePage(driver);
	}
	
	
	
}
