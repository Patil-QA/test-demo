package com.qa.testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.Amazonpages.AmazonHomePage;
import com.qa.Amazonpages.AmazonMobilePage;
import com.qa.Amazonpages.AppleSearchResultPage;
import com.qa.Flipkartpages.FlipCartHomePage;
import com.qa.Flipkartpages.FlipkartMobilePage;
import com.qa.testBase.TestBaseRough;
@Listeners
public class RoughTest extends TestBaseRough {

	@Test
	public void AmazonURl() {
		driver.get("https://www.amazon.in/");
		AmazonHomePage Ap = new AmazonHomePage(driver);
		AmazonMobilePage Amp = Ap.clickOnMobileMenu(driver);
		AppleSearchResultPage Asrp = Amp.clickOnAppleMobile(driver);
		System.out.println("Test Started");
		Asrp.filterTheResultfor8Gb();
		System.out.println("Now on Result Page");
		String Apple13OnAmazon = Asrp.appleiPhone13Title() + "-" + Asrp.appleiPhone13Price() + "-"
				+ Asrp.AmazonTitleWithURL(driver);
		driver.get("https://www.flipkart.com/");
		FlipCartHomePage fhp = new FlipCartHomePage(driver);
		FlipkartMobilePage fmp = fhp.clickOnMobileMenu(driver);
		String flipKartApple = fmp.appleiPhone13Details() + "-" + fmp.appleiPhonePrice() + " "
				+ fmp.applePageURL(driver);
		System.out.println(flipKartApple+"\n"+Apple13OnAmazon);

//	 WebDriverManager.chromedriver().setup();
//	 WebDriver driver=new ChromeDriver();
//	 driver.get("https://www.amazon.in/s?i=electronics&bbn=1805560031&rh=n%3A976419031%2Cn%3A976420031%2Cn%3A1389401031%2Cn%3A1389432031%2Cn%3A1805560031%2Cp_6%3AA14CZOWI0VEHLG%7CA1P3OPO356Q9ZB%7CA2HIN95H5BP4BL%2Cp_89%3AApple%2Cp_n_feature_seven_browse-bin%3A16757455031&dc&ds=v1%3AjMEv9QLz%2FLwVVJNLZAPzf8M2FkgLrQJmt%2BQDCpDYkMs&qid=1662885541&rnid=8561129031&ref=sr_nr_p_n_feature_seven_browse-bin_1");
//	 WebElement  AppleiPhone13Price=driver.findElement(By.xpath("//span[text()='₹69,900']"));
//	 String text=AppleiPhone13Price.getText();
//	 String text1=AppleiPhone13Price.getAttribute("textContent");
//	 JavascriptExecutor js=(JavascriptExecutor)driver;
//	 String text2=js.executeScript("return arguments[0].textContent",AppleiPhone13Price).toString();
//	 System.out.println("Using getText() :"+text+"\n"+"Using getAttribute(textContent)"+text1
//			  	 			+"\n"+"Using JavascriptExecutor :"+text2);
//	 
////	 Thread.sleep(2000);
////	 driver.quit();
//	 System.out.println("WebPage Launched Successfully");

	}

}
