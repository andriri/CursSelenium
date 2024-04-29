package curs17;

import org.testng.annotations.Test;

import seleniumutils.BaseTest;

public class NavigationExample extends BaseTest {
	
	
	@Test
	public void navigationTest() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.get("http://emag.ro");
		Thread.sleep(3000);
		driver.navigate().to("http://altex.ro");
		Thread.sleep(3000);
		driver.navigate().back(); //sageata back in emag dupa ce le deschide pe toate
		Thread.sleep(3000);
		driver.navigate().forward(); //sageata forward
		Thread.sleep(3000);
		driver.navigate().refresh(); //reincarca pagina = refresh
		
		
	}


}
