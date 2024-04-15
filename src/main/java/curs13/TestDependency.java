package curs13;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class TestDependency {

	@Test(priority = 1)
	public void test1() {
		assertTrue(false); //verific daca Expected este la fel cu Actual
						   //vrem sa pice petoda 1
		System.out.println("Test case 1");
	}

	@Test(priority = 2, dependsOnMethods = "test1") //punem un parametru aditional metoda 2 sa depinda de metoda 1
											        //va aparea astfel cu Skipped in loc de failed
	public void test2() {
		System.out.println("Test case 2");
	}
	
	@Test(priority = 3, dependsOnMethods = "test2", alwaysRun = true) // cele 2 NU ar trebui sa fie impreuna depends si always
	public void test3() {
		System.out.println("Test case 3");
	}
}
