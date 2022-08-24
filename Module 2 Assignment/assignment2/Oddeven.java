package assignment2;

import java.util.Scanner;

public class Oddeven 
{
	public static void main(String[] args) {
		
		int n;
		
		System.out.println("Enter Any number");
		 
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		
		if(n%2==0)
		{
			System.out.println("Given number is even");
		}
		
		else
		{
			System.out.println("Given number is odd");
		}
		
	}

}
