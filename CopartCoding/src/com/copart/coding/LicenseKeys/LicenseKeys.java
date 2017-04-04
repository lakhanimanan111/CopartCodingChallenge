package com.copart.coding.LicenseKeys;

import java.util.*;

// Programming Assignment - License Keys

public class LicenseKeys 
{
	
	private static Scanner sc;

	public static void main(String args[])
	{
		sc = new Scanner(System.in);
		System.out.println("Enter the String S: ");
		String string = sc.nextLine();
		System.out.println("Enter K: ");
	
		int k = sc.nextInt();
		String output = "";
	    String input[] = string.split("-");
	    
	    System.out.println("Temp: " + output);
	    for(int i=0; i<input.length; i++)
	    	output += (input[i].toString()).toUpperCase();
	    System.out.println(output);
	    System.out.println("Output: ");
	    for(int i=output.length()-1; i>=0; )
	    {
	    	int count = k;
	    	while(count != 0)
	    	{
	    		count--;
	    		i--;
	    	}
	    	
	    	if(i>=0)
	    	output = output.substring(0, i+1) + "-" + output.substring(i+1);
	    	
	    	
	    }
	    System.out.print(output);
		
		
	}
	
	
}