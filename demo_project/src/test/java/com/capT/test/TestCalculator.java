package com.capT.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capT.Calculator;

public class TestCalculator {

	static Calculator c = null;
	@BeforeAll
	public static void CreateOBJ()
	{
		c = new Calculator();
		System.out.println("Calculator object created");
	}
	
	@Test
	public void testAdd()
	{
		int expectedOutput = 11;
		int res = c.add(5, 6);
		Assertions.assertEquals(expectedOutput,res);
		System.out.println("Add Method Testing PASS");

	}
	@Test
	public void testMul()
	{
		int expectedOutput = 30;
		int res = c.mul(5, 6);
		Assertions.assertEquals(expectedOutput,res);
		System.out.println("Mul Method Testing PASS");

	}
	@Test
	public void testSub()
	{
		int expectedOutput = 1;
		int res = c.sub(5,6);
		Assertions.assertEquals(expectedOutput,res);
		System.out.println("Sub Method Testing PASS");

	}
	@Test
	public void testMod()
	{
		int expectedOutput = 3;
		int res = c.mod(15,6);
		Assertions.assertEquals(expectedOutput,res);
		System.out.println("Mod Method Testing PASS");

	}
	@Test
	public void testDiv()
	{
		int expectedOutput = 2;
		int res = c.div(15,6);
		Assertions.assertEquals(expectedOutput,res);
		System.out.println("Div Method Testing PASS");
	}
	
}
