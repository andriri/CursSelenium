package curs16;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import seleniumutils.BaseTest;

public class CssSelectorExample extends BaseTest {
	
	@Test
	public void CssSelectorTest() {
		
		JavascriptExecutor jse =(JavascriptExecutor) driver;
		
		//first-of-type
		//face diverse culori chenarul si backgroundul
		
		WebElement menuNewReleases = driver.findElement(By.cssSelector("li[class*='sc_tabs_title']:first-of-type"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:red; border:6px solid green;')", menuNewReleases); 
		
		
		//nth-of-type
		//li[class*='sc_tabs_title']:nth-of-type(2)
		
		WebElement menuComingSoon = driver.findElement(By.cssSelector("li[class*='sc_tabs_title']:nth-of-type(2)"));
		jse.executeScript("arguments[0].setAttribute('style', 'background: red; border: 6px solid yellow;')", menuComingSoon); 
	
		WebElement menuBestSeller = driver.findElement(By.cssSelector("li[class*='sc_tabs_title']:nth-of-type(3)"));
		jse.executeScript("arguments[0].setAttribute('style', 'background: red; border: 6px solid blue;')", menuBestSeller);
		
		//last-of-type
		WebElement menuAwardWinners = driver.findElement(By.cssSelector("li[class*='sc_tabs_title']:last-of-type"));
		jse.executeScript("arguments[0].setAttribute('style', 'background: pink; border: 6px solid black;')", menuAwardWinners);
		
		
	}
	

}
