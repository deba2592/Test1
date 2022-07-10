package FlipkartProject.FlipkartValidation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	
	WebDriver driver ;
	 Properties prop;
	
	public WebDriver initializedriver() throws IOException
	{
		
		prop= new Properties();
		WebDriverManager.chromedriver().browserVersion("77.0.3865.40").setup();
    	driver = new ChromeDriver();
		/*System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
		driver= new ChromeDriver();*/
		FileInputStream fis = new FileInputStream("C:\\Users\\HOME\\Desktop\\Sample Proj\\FlipkartValidation\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		return driver;
	}
	public void stopDriver(WebDriver driver)
	{
		driver.quit();
	}

}
