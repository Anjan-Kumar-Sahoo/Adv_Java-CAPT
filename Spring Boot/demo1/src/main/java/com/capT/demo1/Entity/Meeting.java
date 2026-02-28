package com.capT.demo1.Entity;

public class Meeting {
	public static void main(String[] args) {
		String phone = "123-456-7898";
		System.out.println(checkPhone(phone));
	}
	public static boolean checkPhone(String p)
	{
		return p.matches("\\d{3}-\\d{3}-\\d{3}");
	}
}
