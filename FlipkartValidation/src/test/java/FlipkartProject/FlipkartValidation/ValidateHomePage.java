package FlipkartProject.FlipkartValidation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.FlipkartHomePage;
import pages.FlipkartItemPage;
import utility.UtilityMethods;

public class ValidateHomePage extends base{
	
	WebDriver driver;
	@BeforeTest
	public void startDriver() throws IOException
	{
		driver=initializedriver();
	}
	
	@Test
	public void validateHomePage() throws IOException  
	{
		String sValueFromItemList ="",sTotalValue="";
		
		
		driver.get(prop.getProperty("url"));
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		FlipkartHomePage fpHomepage = new FlipkartHomePage(driver);
		fpHomepage.closeLoginWindow();
		fpHomepage.searchBoxElement().sendKeys(prop.getProperty("itemName"));
		fpHomepage.searchSubmitbuttonElement().click();
		sValueFromItemList=fpHomepage.selectionOfItem(prop.getProperty("itemName"));
		
		FlipkartItemPage fpItempage = new FlipkartItemPage(driver);
		fpItempage.addToKartElement().click();
		
		sTotalValue=fpItempage.totalValue();
		
		Assert.assertEquals(sValueFromItemList, sTotalValue);
		
		
		
		
	}
	
	@AfterTest
	public void stopDriver()
	{
		stopDriver(driver);
	}
	
	
	
	
	

}
