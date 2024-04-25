package curs16;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import seleniumutils.BaseTest;

public class IsSelectedExample  extends BaseTest {
	
	/*
	 * isDisplayed() --> verifica daca elementul este vizibil
	 * se aplica pe orice tip de element
	 * 
	 * isSelected()--> verifica daca un element de tip checkbox sau radiobutton
	 * este selectat sau nu
	 * Se aplica doar pe elemente care au atributul type = checkbox sau radio button
	 * 
	 * 
	 * isEnabled()--> actioneaza doar asupra elementelor care primesc un input de la tastatura
	 */
	
	@Test
	public void isSelectedTest() {
		
		driver.findElement(By.cssSelector("ul[class^='menu_user_nav']>li>a")).click();
		//jse.executeScript("arguments[0].setAttribute('style', 'background: pink; border: 6px solid black;')", loginMenu);
		
		WebElement rememberMeCheckbox= driver.findElement(By.cssSelector("input[type='checkbox']"));
		
		System.out.println(rememberMeCheckbox.isSelected());
		assertFalse(rememberMeCheckbox.isSelected());
		
		rememberMeCheckbox.click();
		
		System.out.println(rememberMeCheckbox.isSelected());
		assertTrue(rememberMeCheckbox.isSelected());
		
		System.out.println("-----------------------");
		
		WebElement usernameFields = driver.findElement(By.cssSelector("input[id='log']"));
		
		System.out.println(usernameFields.isSelected());
		
		usernameFields.click();
		
		System.out.println(usernameFields.isSelected()); //isSelected intoarce False pt ca NU este ckeckbox sau radio button
	
	}
	

}
