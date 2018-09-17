package demo;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGDependencyDemo {
	
	@Test(dependsOnMethods= {"test2", "test3"}, groups="regression")
	public void test1() {
		System.out.println("I am inside test 1" ); 
	}
	
	@Test(priority=1, groups="sanity2") // executes test2 first anyway since test1 depends on test2
	public void test2() {
		System.out.println("I am inside test 2" ); 
	}
	
	@Test()
	public void test3() {
		System.out.println("I am inside test 3" ); 
	}
	
}
