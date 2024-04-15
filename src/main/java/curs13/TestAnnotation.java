package curs13;

import org.testng.annotations.Test;

// @Test mai poate fi pusa si la nivelul clasei daca vrem sa includa toate metodele
public class TestAnnotation {

	@Test //adnotarea o punem deasupra fiecarei metode
	public void test1() {
		   System.err.println("Test1");
	}
	@Test
	public void test2() {
		   System.err.println("Test2");
	}
	@Test
	public void test3() {
		   System.err.println("Test3");
	}
}
