package curs15;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import seleniumutils.BaseTest;

public class CssSelectorExample extends BaseTest{ //pentru a avea acces la driver
	
	//@Test
	public void cssExample1() {
		
		// atribut class....cu 3 valori
		// <h2 class="sc_title sc_title_underline sc_align_center margin_bottom_tiny" style="margin-top: 1.15em;text-align:center;"><em>Discover</em> Your Next Book</h2>
		// .sc_title_underline -> cauta doar dupa aceasta valoare
		// h2[class='sc_title sc_title_underline sc_align_center margin_bottom_tiny']
		
		// CssSelector pentru atribut class
		// .menu_main_nav_area
		// nav[class='menu_main_nav_area'] --de preferat fata de cea anterioara
		
		// CssSelector pentru atribut id --> #
		// #menu_user ---> gaseste orice element care are id ( #) cu valoarea '#menu_user'
		// ul#menu_user ->gaseste doar elementele care au tagname 'ul si id (#) cu valoarea '#menu_user'
		// ul[id='#menu_user'] -->aseste doar elementele care au tagname 'ul si id (#) cu valoarea '#menu_user'
		// ul = tagname
		// id(#) = atribut
		// menu_user = valoarea atributului
		
		JavascriptExecutor jse =(JavascriptExecutor) driver; //pt a putea face modificari pe pagina web, a colora elementele
		
		WebElement loginMenu = driver.findElement(By.cssSelector("#menu_user"));
		
		jse.executeScript("arguments[0].setAttribute('style', 'border:4px solid red;')", loginMenu);  //pune border rosu la Login
		
		WebElement logoSlogan = driver.findElement(By.cssSelector("div[class='logo_slogan']"));
		jse.executeScript("arguments[0].setAttribute('style', 'border:4px solid red;')", logoSlogan); //pune border rosu la LogoSlogan	
		
	}
	
	//@Test --le-am comentat pt ca nu vrem sa le ruleze
	public void cssExample2() {
		
		WebElement loginPopup = driver.findElement(By.cssSelector("a[href='#popup_login']"));
		loginPopup.click();	
		
		//input#log  --> acelasi lucru cu sintaxa
		//input[id='log']
		//input[id='log'][name='log'][placeholder='Login or Email']
		
		//logical AND unde pun mai multe atribute cu AND trebuie indeplinite toate
		WebElement usernameField = driver.findElement(By.cssSelector("input[id='log'][name='log'][placeholder='Login or Email']"));
		usernameField.sendKeys("Test User");
		
		
		//logical OR - se pune virgula intre atribute [],[]
		WebElement passwordField = driver.findElement(By.cssSelector("input[id='password'],[name='pwd'"));
		passwordField.sendKeys("parola");
	}
	
	@Test
	public void cssExample3() {
		
		// * --> contains
		// ex:
		// a[href='the-long-road-to-the-deep-silence']
		// a[href*='road-to-the-deep']
		WebElement book1 = driver.findElement(By.cssSelector("a[href*='road-to-the-deep']"));
		System.out.println(book1.getText());  //printeaza numele la book1
		
		// ~ --> contains word
		WebElement book2 = driver.findElement(By.cssSelector("h3[class~='sc_title_regular']"));
		System.out.println(book2.getText());
		
		// ^--> start with
		WebElement book3 = driver.findElement(By.cssSelector("a[href^='life']"));
		System.out.println(book3.getText());
		
		//$ --> ends with
		WebElement book4 = driver.findElement(By.cssSelector("a[href$='story']"));
		System.out.println(book4.getText());
	}
	
	@Test
	public void cssExample4() throws InterruptedException {
		JavascriptExecutor jse =(JavascriptExecutor) driver; 
		
		//direct child in css: >
		List<WebElement> menuEntries = driver.findElements(By.cssSelector("ul[role='tablist']>li"));
		jse.executeScript("arguments[0].setAttribute('style', 'border:6px solid green;')", menuEntries);
		
		WebElement selectMenuEntry = driver.findElement(By.cssSelector("a[href$='story']"));
		//ul[role='tablist']>li[aria-selected='true']
		jse.executeScript("arguments[0].setAttribute('style', 'border:6px solid blue;')", selectMenuEntry);
		
		List<WebElement> notSelectedMenuEntries = driver.findElements(By.cssSelector("ul[role='tablist']>li:not[aria-selected='true]"));
		
			for(WebElement element : notSelectedMenuEntries) {
				
				Thread.sleep(3000);
				jse.executeScript("arguments[0].setAttribute('style', 'border:6px solid orange;')", element);
			}
			
		//ancestor
		//ul[role='tablist'] >li[role='tab']>a[href*='#sc_tab']
		//ul --> parinte al lui li
		//li --> copil a lui ul si parinte al lui a
		//a --> copil al lui lis si nepot al lui ul
		//ca sa cobor de la UL direct la A, adica sa sar peste LI care este la mijloc
		//nu mai fac referinta cu > (direct child) ci pun doar spatiu
	
		List<WebElement> menuLinks = driver.findElements(By.cssSelector("ul[role='tablist'] >li[role='tab']>a[href*='#sc_tab']")) ;
		
		for (WebElement element : menuLinks) {
			
			Thread.sleep(3000);
			jse.executeScript("arguments[0].setAttribute('style', 'border:6px solid pink;')", element);
		}
		
	}
	
	
	
}
