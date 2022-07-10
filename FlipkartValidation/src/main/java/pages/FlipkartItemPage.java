package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartItemPage {

	WebDriver driver;
	
	public FlipkartItemPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By addToKart= By.xpath("//button[text()='ADD TO CART']");
	By totalItemValue = By.xpath("//div[@class='Ob17DV _3X7Jj1']/span");
	
	public WebElement addToKartElement()
	{
		try{
			
			Set<String> windowHanldes =driver.getWindowHandles();
			Iterator<String>it = windowHanldes.iterator();
			String parentIt = it.next();
			String childIt = it.next();
		
			driver.switchTo().window(childIt);
			
			WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(addToKart));
		
		return driver.findElement(addToKart);
		}
		catch(Exception e)
		{
			System.out.println("Add to kart not displayed");
			return null;
		}
	}
	
	
	public String totalValue()
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(totalItemValue));
			
		String totalPrice= driver.findElement(totalItemValue).getText();
		
		return totalPrice;
		}
		catch(Exception e)
		{
			System.out.println("Total Item value not displayed");
			return null;
		}
	}
	
	
}
