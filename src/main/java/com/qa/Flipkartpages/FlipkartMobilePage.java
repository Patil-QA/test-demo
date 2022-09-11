package com.qa.Flipkartpages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartMobilePage {
	private WebDriverWait wait;
	private JavascriptExecutor js;
	
	@FindBy(xpath="//div[text()='APPLE']")
	private WebElement AppleFilterRadioButton;
	
	@FindBy(xpath="//div[text()='1GB and Below']")
	private WebElement Above1GBFilterRadioButton;
	
	@FindBy(xpath="//div[text()='APPLE iPhone 13 (Green, 128 GB)']")
	private WebElement AppleiPhone13Result;
	
	@FindBy(xpath="//div[text()='APPLE iPhone 13 (Green, 128 GB)']/../..//div[text()='₹69,900']")
	private WebElement AppleiPhonePrice;
	
	public FlipkartMobilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		js=(JavascriptExecutor)driver;
	}

	public String appleiPhone13Details() {
		wait.until(ExpectedConditions.elementToBeClickable(AppleFilterRadioButton));
		//js.executeScript("arguments[0].scrollIntoView()", AppleFilterRadioButton);
		js.executeScript("window.scrollBy(0,300)");
		AppleFilterRadioButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(Above1GBFilterRadioButton));
		js.executeScript("arguments[0].scrollIntoView()", Above1GBFilterRadioButton);
		js.executeScript("window.scrollBy(0,-200)");
		Above1GBFilterRadioButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(AppleiPhone13Result));
		js.executeScript("arguments[0].scrollIntoView()", AppleiPhone13Result);
		js.executeScript("window.scrollBy(0,-100)");
		String iPhonetitle=AppleiPhone13Result.getText();
		return iPhonetitle;
	}
	
	public String appleiPhonePrice() {
		String iPhonePrice=AppleiPhonePrice.getText();
		return iPhonePrice;
	}
	
	public String applePageURL(WebDriver driver) {
		String url="-FlipKart-URL :"+driver.getCurrentUrl();
		return url;
	}
	
	
}
