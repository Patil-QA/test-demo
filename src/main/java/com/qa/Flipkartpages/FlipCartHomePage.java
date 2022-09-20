package com.qa.Flipkartpages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipCartHomePage {

	@FindBy(xpath="(//span[text()='Login'])[1]/preceding::button[1]")
	private WebElement closePopUpButton;
	
	@FindBy(xpath="//div[text()='Mobiles']")
	private WebElement MobileMenu;
	
	@FindBy(css="input[name='q']")
	private WebElement SearchBox;
	
	
	
	
	private WebDriverWait wait;
	public FlipCartHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	
	public SearchPage searchApple13(WebDriver driver) {
		closePopUpButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(SearchBox)).sendKeys("Apple 13"+Keys.ENTER);
		return new SearchPage(driver);
	}
	
	
	public FlipkartMobilePage clickOnMobileMenu(WebDriver driver) {
		closePopUpButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(MobileMenu)).click();
		
		return new FlipkartMobilePage(driver);
		
	}
	

}

