package curs17;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class Homework17 {
	WebDriver browser; // obiectul de tip browser

	@BeforeClass
	public void setup() {

		browser = new ChromeDriver();
		browser.get("https://keybooks.ro/team/margaret-robins/");
		browser.manage().window().maximize();
	}

	public void testHomework17() throws InterruptedException {

		Thread.sleep(5000); 
		// Find the name Drama
		WebElement drama = browser.findElement(By.xpath("//div[@class='sc_skills_label' and text()='Drama']"));
		System.out.println("Text found: " + drama.getText());
		WebElement percentageDrama = browser.findElement(RelativeLocator.with(By.cssSelector("div[class='sc_skills_total']")).below(By.xpath("//div[@class='sc_skills_label' and text()='Drama']")));
		System.out.println("Percentage found: " + percentageDrama.getText());
		
		//Find the name Biography
	    WebElement percentageBiography = browser.findElement(RelativeLocator.with(By.cssSelector("div[class='sc_skills_total']")).below(By.cssSelector("//*[contains(text(), 'Biography')]")));
		percentageBiography.getText();
		System.out.println("Percentage found: " + percentageBiography);
		
		//Find the name Cookbooks
		WebElement percentageCookbooks = browser.findElement(RelativeLocator.with(By.cssSelector("div[class='sc_skills_total']")).below(By.cssSelector("//*[contains(text(), 'Cookbooks')]")));
		percentageCookbooks.getText();
		System.out.println("Percentage found: " + percentageCookbooks);

	}

	@AfterClass
	public void tearDown() {

		browser.quit();
	}
}