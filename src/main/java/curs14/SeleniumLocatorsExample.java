package curs14;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import seleniumutils.BaseTest;

public class SeleniumLocatorsExample  extends BaseTest {
	
	/*driver.findElement(locator) adica locatorul este
	 *driver.findElement(By.className("logo")).click()
	 *			webelement					  .> actiunea pe webelement
	 * 
	 * e mai corect asa pt ca putem refolosi codul:
	 * WebElement logo = driver.find.findElement(By.className("logo"));
	 * logo.click()
	 * logo.getText()
	 * 
	 * 
	 * Selenium locators:
	 * --> by tagName
	 * --> by linkText
	 * --> by partialLinkText
	 * --> by id
	 * --> by className
	 * --> by name
	 * --> by cssSelector
	 * --> by xpath
	 * 
	 * Selenium relative locators -- sunt diferiti
	 * --> above, below, near, toLeftOf, toRightOf
	 */
	
	@Test(priority =1)
	public void tagNameLocator() {
		
		//<em>Discover</em>
		//driver.findElement(By.tagName("em")).click();
		WebElement discoverText = driver.findElement(By.tagName("em"));
		String text = discoverText.getText(); //metoda getText -intoarce textul dintre tag-urile HTML
		
		System.out.println(text);
		assertEquals(text, "Discover");
				
	}

	@Test(priority =2)
	public void linkTextLocator() {
		
		//									 linkText
		//<a href="https://keybooks.ro/shop/">Books</a>
		WebElement booksLink = driver.findElement(By.linkText("BOOKS"));
		booksLink.click();
		
		String currentUrl = driver.getCurrentUrl();//citeste URL ul la care se afla pagina
		System.out.println(currentUrl);
		assertEquals(currentUrl, "https://keybooks.ro/shop/");
		
	}
		
	@Test(priority =3)
	public void partialLInkText() {
		WebElement cookingBook = driver.findElement(By.partialLinkText("Cooking"));
		cookingBook.click();
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/cooking-with-love/");
		
	}
	
	@Test(priority =4)
	public void classNameLocator() {
		
		WebElement price = driver.findElement(By.className("price"));
		
		System.out.println(price.getText());
		assertTrue(price.getText().contains("18.49"));
			
	}
	
	
	@Test(priority =5)
	public void idLocator() {
		
		Actions action = new Actions(driver);
		action.scrollByAmount(0, 800).perform(); //face un scroll in interiorul aplicatiei daca avem rezolutii diferite
				
		WebElement reviewTab = driver.findElement(By.id("tab-title-reviews"));
		reviewTab.click();
		WebElement commentBox = driver.findElement(By.id("comment")); //dam click in comment boxul de la Review
		
		assertTrue(commentBox.isDisplayed());
		
		
	}
	
	@Test(priority =6)
	public void nameLocator() {
		
		WebElement commentBox = driver.findElement(By.name("comment"));
		commentBox.sendKeys("My super duper message");// punem un String in inbteriorul unui WebeElement
				
	}
	
	@Test(priority =7)
	public void cssLocator() throws InterruptedException {
		WebElement nameBox = driver.findElement(By.cssSelector("input[name='author']"));
		nameBox.sendKeys("Johnny Bravo");
		Thread.sleep(3000);
		nameBox.clear(); //sterge ce am scris, de mai sus
		Thread.sleep(3000);
		nameBox.sendKeys("John Doe");
		Thread.sleep(3000);
		
	}
	
	@Test(priority =8)
	public void xpathLocator() {
		
		WebElement emailBox = driver.findElement(By.xpath("//input[@type='email']"));
		emailBox.sendKeys("john.doe@test.com");
		
		
	}
	
}
