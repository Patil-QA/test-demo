package com.qa.Amazonpages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonMobilePage {
	private WebDriverWait wait;
	private Actions action;
	@FindBy(xpath="//a[@aria-label='Mobiles & Accessories']")
	private WebElement MobileAndAccessories;
	@FindBy(xpath="//h3[text()='Mobile brands']/..//a[text()='Apple']")
	private WebElement Apple;
	
	public AmazonMobilePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		action=new Actions(driver);
	}
	

	public AppleSearchResultPage clickOnAppleMobile(WebDriver driver) {
		action.moveToElement(wait.until(ExpectedConditions.visibilityOf(MobileAndAccessories))).perform();
		action.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(Apple))).click().perform();
		return new AppleSearchResultPage (driver);
	}




	
	

}
