package com.capT.Test;

import static org.junit.jupiter.api.Assertions.fail;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Parameter;
import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DemoTest {
	
	@Test
	public void demo1()
	{
		Assertions.assertEquals("xyz","xyz");
	}
	@Test
	public void demo2()
	{
		Assertions.assertNotNull(99,"Null Value is not allpwed.");
	}
	@Test
	public void demo3()
	{
		Assertions.assertThrows(ArithmeticException.class,()->{int res = 7/0;});
	}
	@Test
	public void demo4()
	{
		Assertions.assertDoesNotThrow(()->{int res=9/9;});
	}
	@Test
	public void demo5()
	{
		String s1="XYZ", s2="XYZ";
		Assertions.assertSame(s1, s2);
	}
	@Test
	public void demo6()
	{
		if(17<18)
			fail("Invalid: Age must be 18");
	}
	
	@Test
	public void demo7()
	{
		boolean res = true;
		Assertions.assertTrue(res);
		
	}
	@Test
	public void demo8()
	{
		boolean res = true;
		Assertions.assertFalse(res);
		
	}
	@Test
	public void demo9()
	{
		int[] a1 = {10,20};
		int[] a2 = {20,10};
		Assertions.assertArrayEquals(a1,a2);
		
	}
	@ParameterizedTest
	@CsvSource({"2,3,5","10,20,30","-1,1,0"})
	void testAddition(int a,int b,int expected)
	{
		int res = a+b;
		Assertions.assertEquals(expected, res);
	}
	@BeforeAll
	public static void m1()
	{
		System.out.println("Before All");
	}
	@AfterAll
	public static void m2()
	{
		System.out.println("After All");
	}
	@BeforeEach
	public void m3()
	{
		System.out.println("Before Each");
	}
	@AfterEach
	public void m4()
	{
		System.out.println("After Each");
	}
	
	
}
