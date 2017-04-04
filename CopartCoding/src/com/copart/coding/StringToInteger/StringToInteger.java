package com.copart.coding.StringToInteger;

import java.util.*;

// Convert String to Integer

public class StringToInteger 
{
	private static Scanner sc;

	public static void main(String args[])
	{
		sc = new Scanner(System.in);
		
		//Scanning Inputs
		
		System.out.println("Enter the numbers");
		String numbers = sc.nextLine();
		
		//Function Call and store in result
		
		int result = stringToInt(numbers);
		
		//Display
		
		System.out.println("Result: " + result);
		
	}
	
	// Function to Convert String into Number
	
	public static int stringToInt(String numbers) 
	{
	    int result = 0; 
	    int factor = 1;
	    for (int i = numbers.length()-1; i >= 0; i--) 
	    {
	        result += (numbers.charAt(i) - '0') * factor;
	        factor *= 10;
	    }
	    return result;
	}

}
