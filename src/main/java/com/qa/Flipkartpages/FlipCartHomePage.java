package com.qa.Flipkartpages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipCartHomePage {

	@FindBy(xpath="//span[text()='Login']/../../../../../button")
	private WebElement closePopUpButton;
	
	@FindBy(xpath="//div[text()='Mobiles']")
	private WebElement MobileMenu;
	
	private WebDriverWait wait;
	public FlipCartHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	}

	public FlipkartMobilePage clickOnMobileMenu(WebDriver driver) {
		closePopUpButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(MobileMenu)).click();
		
		return new FlipkartMobilePage(driver);
		
	}
	

}

