package selenium_Tips_tricks1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class fileupload 
{
	@Test
	public void uploadfiletechnique() throws InterruptedException, AWTException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://www.foundit.in/upload");
		driver.manage().window().maximize();
		
		//1>> using send keys method :- if we have type=file atribute then we can do it by using send keys method 
		
		driver.findElement(By.xpath("//div[@class='heroSection-buttonContainer_secondaryBtn__text']")).click();
		//driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:\\Users\\vaidy\\hey.txt");
		
		// using robot class
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//input[@id='file-upload']")));
		Thread.sleep(5000);
		// to get the file upload we have some steps 
		//1 copy file path to clipboard(cnt+c)
		StringSelection fileapthsection= new StringSelection("C:\\Users\\vaidy\\hey.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileapthsection, null);
		
		Thread.sleep(3000);
		// 2 cnt+v
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		
		Thread.sleep(3000);
		//3 press enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		
		driver.quit();
		
	}
	
	
	
}
