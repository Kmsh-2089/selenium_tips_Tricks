package selenium_Tips_tricks1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class findtheelemnts_withscroll 
{
	@Test
	public void countements() throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://booksbykilo.in/new-books");
		driver.manage().window().maximize();
		Actions act=new Actions(driver);
		
		// we need to find the element on a page but its a srolling page so the solution is apply logic here 
		// title:-Why Mummy Swears
		boolean found=false;
		while(!found) 
		{
			 List<WebElement>books=driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));
			 for(WebElement book:books) 
			 {
				 if(book.getText().equals("Why Mummy Swears")) 
				 {
					 System.out.println("Book Found");
					 found=true;
					 break;
				 }
			 }
			 act.sendKeys(Keys.END).perform(); 
		}
		driver.quit();
	
	
	
	}
}
