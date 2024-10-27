package selenium_Tips_tricks1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class countwebelementson_webpage 
{	
	@Test
	public void countements() throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://booksbykilo.in/new-books");
		driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Actions act=new Actions(driver);
		// to find the no of elements on webpage
		// failed
		//List<WebElement>books=driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));
		//System.out.println("no of elemnts"+books.size());
		
		// using javascriptexecutor>>> this will not work again 
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		//List<WebElement>books=driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));
		//System.out.println("no of elemnts"+books.size());
		
		// we need to apply some logic here to get the output 
		int previouscount=0;
		int currentcount=0;
		while(true) 
		{
			List<WebElement>books=driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));
			currentcount=books.size();
			if(previouscount==currentcount) 
			{
				break;
			}
			previouscount=currentcount;
			//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			act.sendKeys(Keys.END).perform();
			Thread.sleep(5000);
		}
		
		System.out.println("No of Books are"+currentcount);
		
		driver.quit();

	}
	
	
	
}
