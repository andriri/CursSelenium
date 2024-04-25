package curs15;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;



@Test
public class CssLocator {	
WebDriver browser;  //obiectul de tip browser


@BeforeClass
public void setup() {
	
	browser = new ChromeDriver();
	browser.get("https://keybooks.ro/contacts/"); 
	browser.manage().window().maximize(); 
}

public void testWebElementWithCssLocator() throws InterruptedException {
	
	// Find the name input field and send a value
	WebElement nameInput = browser.findElement(By.cssSelector("input[name='your-name']"));
    nameInput.sendKeys("Irina Andrei");
	
    // Find the email input field and send a value
    WebElement emailInput = browser.findElement(By.cssSelector("input[name='your-email']"));
    emailInput.sendKeys("irinaandrei83@gmail.com");
    
    // Find the subject input field and send a value
    WebElement subjectInput = browser.findElement(By.cssSelector("input[name='your-s']"));
    subjectInput.sendKeys("Testing Subject");
    
    // Find the message input field and send a value
    WebElement messageInput = browser.findElement(By.cssSelector("textarea[name='your-message']"));
    messageInput.sendKeys("Selenium Curs15 homework");

    // Find the submit button and click it
    WebElement submitButton = browser.findElement(By.cssSelector("input[value='Send Message']"));
    submitButton.click();
    
    Thread.sleep(1000); 
	
    // Assert if the expected message appears
    WebElement submitMessage = browser.findElement(By.cssSelector("div[class='wpcf7-response-output']"));
    String expectedMessage = "Thank you for your message. It has been sent.";
    String actualMessage = submitMessage.getText();
    System.out.println("Message found: "+actualMessage);
    try {
    assertEquals(actualMessage,expectedMessage);
    System.out.println("Success message is present and correct.");
    } catch (Exception e) {
        System.out.println("Success message is not present or incorrect.");
    };
   
	
}

@AfterClass
public void tearDown() {
	
	browser.quit(); 
}
}



