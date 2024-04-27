package curs16;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class HomeworkCssSelector  {
	WebDriver driver; 
	@BeforeClass
	public void setup() {

		driver = new ChromeDriver();
		driver.get("https://keybooks.ro/"); 
		driver.manage().window().maximize(); 
	}	
	
	public void testBooReview() throws InterruptedException {	
		 

		WebElement book = driver.findElement(By.cssSelector("a[href='the-son']"));
		book.click();
		
		//Thread.sleep(1000); 
		//click pe Review
		WebElement reviewButton = driver.findElement(By.cssSelector("li[id='tab-title-reviews']"));
		reviewButton.click();	
		
		//click on Submit button without filling anything
		WebElement submitButton = driver.findElement(By.cssSelector("input[id='submit']"));
		submitButton.click();
		
		Thread.sleep(1000);
		//click on OK for simple alert
		Alert alertaJs = driver.switchTo().alert();
		alertaJs.accept(); 
		
		//click on 5 starts rating
		WebElement ratingInput = driver.findElement(By.cssSelector("a[class='star-5']"));
		ratingInput.click();
					
		WebElement reviewInput = driver.findElement(By.cssSelector("textarea[id='comment']"));
		reviewInput.sendKeys("Good review for Dragos1");
		
		// Find the name input field and send a value
		WebElement nameInput = driver.findElement(By.cssSelector("input[id='author']"));
	    nameInput.sendKeys("Irina Andrei");
		
	    // Find the email input field and send a value
	    WebElement emailInput = driver.findElement(By.cssSelector("input[id='email']"));
	    emailInput.sendKeys("irinaandrei83@gmail.com");
	    
	 // Find the checkbox and check it
	    WebElement checkBox = driver.findElement(By.cssSelector("input[id='wp-comment-cookies-consent']"));
	    checkBox.click();
	    
	 // We use the already defined submitButton element and click it
	    submitButton.click();
	    
	    Thread.sleep(1000);
	    //check text awaiting approval
	    WebElement resultText = driver.findElement(By.cssSelector("em[class='woocommerce-review__awaiting-approval']"));
		assertEquals(resultText.getText(), "Your review is awaiting approval");
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit(); 
	}
}
