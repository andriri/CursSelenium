package curs13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class WebElementExample {
	
	WebDriver browser;  //obiectul de tip browser
	
	@BeforeClass
	public void setup() {
		
		browser = new ChromeDriver();
		browser.get("https://keybooks.ro/"); //navighez
		browser.manage().window().maximize(); //mareste fereastra Web
	}
	
	@Test
	public void testWebElement() throws InterruptedException {
		try {
			browser.findElement(By.id("log")).sendKeys("");
			}
			catch(Exception e) {
			  //  Block of code to handle errors
			}
		browser.findElement(By.linkText("Login")).click();
		Thread.sleep(5000); //bad practice in a fi folosit ca metoda de a astepta elementul
		browser.findElement(By.id("log")).sendKeys("");
		browser.findElement(By.id("log")).click();
	}
	
	@AfterClass
    public void tearDown() {
    	
    	browser.quit(); //inchide browserul
    }
}
