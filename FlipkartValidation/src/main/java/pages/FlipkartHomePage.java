package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//import org.apache.poi.ss.util.NumberToTextConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlipkartHomePage {

	
	WebDriver driver;
	
	By loginLabel = By.xpath("//span[@class='_36KMOx']");
	By loginWindowClose = By.xpath("//button[@class='_2KpZ6l _2doB4z']");
	By searchTextbox = By.xpath("//form[@action='/search']//input[@type='text']");
	By searchSubmitButton = By.xpath("//form[@action='/search']//button[@type='submit']");
	By listOfItemPrices= By.xpath("//div[@class='_13oc-S']//div[@class='col col-5-12 nlI3QM']//div[@class='_25b18c']/div[@class='_30jeq3 _1_WHN1']");
	By listOfItemNames = By.xpath("//div[@class='col col-7-12']/div[1]");
	
	public FlipkartHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	
	public void closeLoginWindow()
	{
		try{
			
			if(driver.findElement(loginLabel).isDisplayed())
			{
				driver.findElement(loginWindowClose).click();
			}
		}
		catch(Exception e)
		{
			System.out.println("Login window didn't get displayed");
		}
	}
	public WebElement searchBoxElement()
	{
		return driver.findElement(searchTextbox);
	}
	
	public WebElement searchSubmitbuttonElement()
	{
		return driver.findElement(searchSubmitButton);
	}
	
	
	
	public String selectionOfItem(String itemName)
	{
		List<WebElement> lsNames = driver.findElements(listOfItemNames);
		List<WebElement> lsPrices = driver.findElements(listOfItemPrices);
		String itemPrice="";
		ArrayList<Integer> lsSelectedPrices = new ArrayList<Integer>();
		HashMap<Integer,Integer> priceMap=new HashMap<Integer,Integer>();
		
		for(int i=0;i<lsNames.size();i++)
		{
			if(lsNames.get(i).getText().contains(itemName))
			{
				if((lsNames.get(i).getText().contains("Mini") || (lsNames.get(i).getText().contains("Pro"))))
					{
							continue;
					}
				else{
					String[] arr = lsPrices.get(i).getText().split("₹");
					String sPrice = arr[1].replace(",","");
					lsSelectedPrices.add(Integer.parseInt(sPrice.trim()));
					priceMap.put(Integer.parseInt(sPrice.trim()), i);
				}
			    
			}
			
		}
		
		Collections.sort(lsSelectedPrices);
		
		System.out.println("lowest price"+lsSelectedPrices.get(0));
		
		itemPrice=lsPrices.get(priceMap.get(lsSelectedPrices.get(0))).getText();
		lsPrices.get(priceMap.get(lsSelectedPrices.get(0))).click();
		
		return itemPrice;
		
	}
}
