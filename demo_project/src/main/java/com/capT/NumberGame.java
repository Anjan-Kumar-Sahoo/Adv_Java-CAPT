package com.capT;

public class NumberGame {

	// Method to check if a number is prime
	public static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		if (n == 2) {
			return true;
		}
		if (n % 2 == 0) {
			return false;
		}
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	// Method to check if a number is an Armstrong number
	public static boolean isArmstrong(int n) {
		int original = n;
		int sum = 0;
		int digits = String.valueOf(n).length();
		
		while (n > 0) {
			int digit = n % 10;
			sum += Math.pow(digit, digits);
			n /= 10;
		}
		
		return sum == original;
	}
	
	// Method to check if a number is a palindrome
	public static boolean isPalindrome(int n) {
		int original = n;
		int reversed = 0;
		
		while (n > 0) {
			int digit = n % 10;
			reversed = reversed * 10 + digit;
			n /= 10;
		}
		
		return original == reversed;
	}

}
