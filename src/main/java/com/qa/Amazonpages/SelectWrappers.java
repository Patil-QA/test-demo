package com.qa.Amazonpages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectWrappers {
	
	Select select;
	
	public List<WebElement>getOptions(WebElement element)
	{
		select=new Select(element);
		return select.getOptions();
	}
	
	
}
