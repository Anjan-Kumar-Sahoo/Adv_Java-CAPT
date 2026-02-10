package com.capT.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.capT.NumberGame;

public class Test_NumberGame {

	static NumberGame ng = null;
	
	@BeforeAll
	public static void CreateOBJ() {
		ng = new NumberGame();
		System.out.println("NumberGame object created");
	}

	@Test
	public void testIsPrime_ValidPrimes() {
		boolean expectedOutput = true;
		boolean res1 = ng.isPrime(2);
		Assertions.assertEquals(expectedOutput, res1);
		
		boolean res2 = ng.isPrime(7);
		Assertions.assertEquals(expectedOutput, res2);
		
		boolean res3 = ng.isPrime(13);
		Assertions.assertEquals(expectedOutput, res3);
		
		System.out.println("isPrime Valid Test PASS");
	}
	
	@Test
	public void testIsPrime_InvalidPrimes() {
		boolean expectedOutput = false;
		boolean res1 = ng.isPrime(4);
		Assertions.assertEquals(expectedOutput, res1);
		
		boolean res2 = ng.isPrime(0);
		Assertions.assertEquals(expectedOutput, res2);
		
		boolean res3 = ng.isPrime(1);
		Assertions.assertEquals(expectedOutput, res3);
		
		System.out.println("isPrime Invalid Test PASS");
	}
	
	@Test
	public void testIsArmstrong_ValidArmstrong() {
		boolean expectedOutput = true;
		boolean res1 = ng.isArmstrong(153);
		Assertions.assertEquals(expectedOutput, res1);
		
		boolean res2 = ng.isArmstrong(370);
		Assertions.assertEquals(expectedOutput, res2);
		
		boolean res3 = ng.isArmstrong(1);
		Assertions.assertEquals(expectedOutput, res3);
		
		System.out.println("isArmstrong Valid Test PASS");
	}
	
	@Test
	public void testIsArmstrong_InvalidArmstrong() {
		boolean expectedOutput = false;
		boolean res1 = ng.isArmstrong(10);
		Assertions.assertEquals(expectedOutput, res1);
		
		boolean res2 = ng.isArmstrong(152);
		Assertions.assertEquals(expectedOutput, res2);
		
		boolean res3 = ng.isArmstrong(200);
		Assertions.assertEquals(expectedOutput, res3);
		
		System.out.println("isArmstrong Invalid Test PASS");
	}
	
	@Test
	public void testIsPalindrome_ValidPalindrome() {
		boolean expectedOutput = true;
		boolean res1 = ng.isPalindrome(121);
		Assertions.assertEquals(expectedOutput, res1);
		
		boolean res2 = ng.isPalindrome(1221);
		Assertions.assertEquals(expectedOutput, res2);
		
		boolean res3 = ng.isPalindrome(11);
		Assertions.assertEquals(expectedOutput, res3);
		
		System.out.println("isPalindrome Valid Test PASS");
	}
	
	@Test
	public void testIsPalindrome_InvalidPalindrome() {
		boolean expectedOutput = false;
		boolean res1 = ng.isPalindrome(123);
		Assertions.assertEquals(expectedOutput, res1);
		
		boolean res2 = ng.isPalindrome(10);
		Assertions.assertEquals(expectedOutput, res2);
		
		boolean res3 = ng.isPalindrome(1234);
		Assertions.assertEquals(expectedOutput, res3);
		
		System.out.println("isPalindrome Invalid Test PASS");
	}
}
