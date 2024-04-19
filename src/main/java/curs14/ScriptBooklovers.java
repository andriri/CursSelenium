package curs14;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;



@Test
public class ScriptBooklovers {	
WebDriver browser;  //obiectul de tip browser


@BeforeClass
public void setup() {
	
	browser = new ChromeDriver();
	browser.get("https://keybooks.ro/"); //navighez
	browser.manage().window().maximize(); //mareste fereastra Web
}

public void testWebElement() throws InterruptedException {
	//Task1 - verificam daca butonul Login apare in pagina
	//identificare elementului Login in pagina
	WebElement loginButton = browser.findElement(By.linkText("Login"));
	//verificam ca el apare in pagina
	assertTrue(loginButton.isDisplayed());
	
	//Task2 - verificam daca campurile Login or Email/Password sunt vizibile fara sa apasam pe butonul Login
	WebElement loginOrEmail = browser.findElement(By.id("log"));
	WebElement password = browser.findElement(By.id("password"));

	try {
		//assertTrue(loginOrEmail.isDisplayed());
		loginOrEmail.sendKeys("");
		}
		catch(Exception e) {
		  System.out.println("Campul Login or Email nu este vizibil in pagina daca butonul Login nu este apasat");
		}
	
	try {
		password.sendKeys("");
		}
		catch(Exception e) {
		  System.out.println("Campul Password nu este vizibil in pagina daca butonul Login nu este apasat");
		}
	
	//Task 3 - verificam daca campurile Login or Email/Password sunt vizibile atunci cand apasam pe butonul Login
	
	//apasam pe butonul Login
	loginButton.click();
	//verificam daca cele doua butoane sunt vizibile
	Thread.sleep(1000); 
	assertTrue(loginOrEmail.isDisplayed());
	assertTrue(password.isDisplayed());

}

@AfterClass
public void tearDown() {
	
	browser.quit(); 
}
}



