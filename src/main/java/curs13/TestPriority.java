package curs13;

import org.testng.annotations.Test;

public class TestPriority {

	@Test(priority = 1) //stabilesti prioritatea la rulare
	public void one() {
		   System.out.println("First");
	}
	
	@Test(priority = 2)
	public void two() {
		   System.out.println("Second");
	}
	
	@Test(priority = 3)
	public void three() {  //TestNG ruleaza alfabetic, deci va rula third inaintea lui two
		   System.out.println("Third");
	}
	
	@Test
	public void four() {
		System.out.println("Fourth");
	}
	
	@Test
	public void five() {
		System.out.println("Fifth");
	}
}
