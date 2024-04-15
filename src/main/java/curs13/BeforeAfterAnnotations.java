package curs13;

import org.testng.annotations.*;  //le importa pe toate

public class BeforeAfterAnnotations {
	
	@BeforeSuite  //cel mai inalt nivel echivalent cu proiectul
	public void beforeSuite() {
		System.out.println("Before suite");
	}
	

	@AfterSuite   //se executa ultimul dupa clase si metode
	public void afterSuite() {
		System.out.println("After suite");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After class");
	}
	
	@BeforeMethod
	public void beforeMethod() {  //se executa inaintea fiecarei metode
		System.out.println("Before method"); 
	}
	
	@AfterMethod
	public void afterMethod() {  //se executa inaintea fiecarei metode
		System.out.println("After method"); 
	}
	
	@Test
	public void test1() {
		System.out.println("Test 1"); 
	}
	
	@Test
	public void test2() {
		System.out.println("Test 2"); 
	}
	
	@Test
	public void test3() {
		System.out.println("Test 3"); 
	}
}
