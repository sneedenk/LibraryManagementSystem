/**
 * 
 */
package com.ss.lms.biz;
import java.util.Scanner;



/**
 * @author Kyle Sneeden
 *
 */
public class LMS {

	/**
	 * @param args
	 */
	
	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) 
	{
		mainMenu();
		Integer userType = scan.nextInt();
		
		switch(userType){
			case 1: lib1();
					break;
			case 2: admin1();
					break;
			case 3:	borr1();
					break;
					
		}
	}
	
	public static void mainMenu()
	{
		System.out.println("Welcome to the Smoothstack Library Management System. Which category of user are you (enter number only)");
		System.out.println();
		System.out.println("1) Librarian");
		System.out.println("2) Administrator");
		System.out.println("3) Borrower");
	}
	
	public static void lib1()
	{
		System.out.println("1) Enter the branch you manage");
		System.out.println("2) Quit to previous");
	}
	
	public static void lib2()
	{
		System.out.println("1) University Library, Boston"); 
		System.out.println("2) State Library, New York"); 
		System.out.println("3) Federal Library, Washington DC"); 
		System.out.println("4) County Library, McLean VA"); 
		System.out.println("5) Quit to previous");  
	}
	
	public static void lib3()
	{
		System.out.println("1) Update the details of the Library");
		System.out.println("2) Quit to previous");
	}
	
	public static void lib4()
	{
		System.out.print("You have chosen to update the Branch with Branch Id: X and Branch Name: ABCD. Enter ‘quit’ at any prompt to cancel operation.");
		System.out.print("Please enter new branch name or enter N/A for no change:");
		System.out.print("Please enter new branch address or enter N/A for no change:");
	}
	
	public static void admin1()
	{
		System.out.println("1) Add/Update/Delete/Read Book and Author");
		System.out.println("2) Add/Update/Delete/Read Genres");
		System.out.println("3) Add/Update/Delete/Read Publishers");
		System.out.println("4) Add/Update/Delete/Read Library Branches");
		System.out.println("5) Add/Update/Delete/Read Borrowers");
	}
	
	public static void borr0()
	{
		System.out.println("Enter the your Card Number:");
	}
	
	public static void borr1()
	{
		System.out.println("1) Check out a book");
		System.out.println("2) Return a Book");
		System.out.println("3) Quit to Previous");
	}
	
	public static void borr2()
	{
		System.out.println("Pick the Branch you want to check out from:");
		System.out.println("1) University Library, Boston"); 
		System.out.println("2) State Library, New York");
		System.out.println("3) Federal Library, Washington DC");
		System.out.println("4) County Library, McLean VA"); 
		System.out.println("5) Quit to previous");
	}
	
	public static void borr3()
	{
		System.out.println("1) Lost Tribe by Sidney Sheldon");
		System.out.println("2) The Haunting by Stepehen King");
		System.out.println("3) Microtrends by Mark Penn");
		System.out.println("4) Quit to cancel operation");
	}
}
