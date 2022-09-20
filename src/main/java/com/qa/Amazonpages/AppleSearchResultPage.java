package com.qa.Amazonpages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppleSearchResultPage {
	JavascriptExecutor js;
	WebDriverWait wait;
	@FindBy(xpath="//span[text()='8 GB & above']")
	private WebElement Above8GbFilter;
	
	@FindBy(xpath="//span[text()='Apple iPhone 13 (128GB) - Green']")
	private WebElement AppleiPhone13Title;
	
	@FindBy(xpath="//span[text()='Apple iPhone 13 (128GB) - Green']/ancestor::div[2]//span[@class='a-offscreen']")
	private WebElement AppleiPhone13Price;
	
	
	
	public AppleSearchResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		js=(JavascriptExecutor)driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	
	public void filterTheResultfor8Gb() {
		wait.until(ExpectedConditions.visibilityOf(Above8GbFilter));
		js.executeScript("arguments[0].scrollIntoView()",Above8GbFilter);
		wait.until(ExpectedConditions.elementToBeClickable(Above8GbFilter)).click();
		
	}
	
	
	public String appleiPhone13Title() {
		js.executeScript("window.scrollBy(0,200)");
		wait.until(ExpectedConditions.elementToBeClickable(AppleiPhone13Title));
		String iPhone13Title=AppleiPhone13Title.getText();
		return iPhone13Title;
	}
	
	public String appleiPhone13Price() {
		String iPhone13Price=AppleiPhone13Price.getAttribute("textContent");
		return iPhone13Price;
	}
	
	public String AmazonTitleWithURL(WebDriver driver) {
		String AmazonTitleURL="-Amazon-URL- "+driver.getCurrentUrl();
		return AmazonTitleURL;
	}
}
