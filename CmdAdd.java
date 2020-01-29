/**
 * 
 */
package com.ss.oop.assignment2;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * @author Kyle Sneeden
 *
 */
public class CmdAdd 
{
	public static void main(String[] args) 
	{
		try(Scanner scan = new Scanner(System.in))
		{
			ArrayList<Double> doubleList = new ArrayList<Double>();
			System.out.println("Enter numeric values to add. Enter a non-whitespace, non-numeric value to see the sum.");
			
			while(scan.hasNextDouble())
			{
				System.out.println("Enter numeric values to add. Enter a non-whitespace, non-numeric value to see the sum");
				doubleList.add(scan.nextDouble());
			}
			
			System.out.println(addInputs(doubleList));
		}
		catch(Exception e)
		{
			System.err.println("Please try again with legal input.");
		}
	}
	
	public static Double addInputs(ArrayList<Double> doubleList)
	{
		Double sum = 0.0;
		for(int i = 0; i < doubleList.size(); i++)
		{
			sum += doubleList.get(i);
		}
		
		return sum;
	}

}
