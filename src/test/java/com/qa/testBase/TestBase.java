package com.qa.testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@BeforeTest 
	@Parameters ({"browser","URL"})
	public void setUp(String browser,String URL) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		if(browser.equals("chrome") && URL.equals("https://www.flipkart.com/"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		 	driver=new ChromeDriver();
		 	driver.get("https://www.flipkart.com/");
		}
		else if(browser.equals("firefox") && URL.equals("https://www.amazon.in/"))
		{
			System.setProperty("webdriver.gecko.driver", "E:\\Selenium\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.get("https://www.amazon.in/");
		}
		else if(browser.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", "E:\\Selenium\\edgedriver.exe");
			driver=new EdgeDriver();
		}
		else
		{
		System.err.println("Enter the correct value of Browser");	
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
	

	
	
	


	
	

}
