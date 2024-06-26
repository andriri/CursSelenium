package curs17;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import seleniumutils.BaseTest;

public class ImplicitWaitExample  extends BaseTest{
	
	@Test
	public void implicitWaitExample() throws InterruptedException {
		
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.cssSelector("div[id='start']>button")).click();
			
	//	Thread.sleep(10000); //bad practice to wait too many seconds
		
		WebElement finish = driver.findElement(By.cssSelector("div[id='finish']>h4"));
		
		assertEquals(finish.getText(), "Hello Worlds!");
		
		
		
	}
	
	

}
