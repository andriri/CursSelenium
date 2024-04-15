package curs12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class OpenBrowser {

	@Test
	public void testOpenBrowser() {
		
		WebDriver driver = new ChromeDriver(); //FireFoxDriver() sau EdgeDriver()
		driver.get("https://keybooks.ro/"); //metoda ce permite sa navigam intr-un URL
		
		
	}
	
}
