package assignment2;

import java.util.Scanner;

public class Twointegers {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter two numbers");
		
		int a=sc.nextInt();

		int b=sc.nextInt();
		
		int s=a+b;
		
		System.out.println("Sum of "+a+" and "+b+" is " +s);
		
	}

}
