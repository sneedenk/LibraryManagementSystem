/**
 * 
 */
package com.ss.oop.assignment2;
import java.util.Random;
/**
 * @author Kyle Sneeden
 *
 */
public class TwoDArray 
{
	public static void main(String[] args) 
	{
		Integer[][] numbers = populate2DArray(5,6);
		Integer[] maxValues = TwoDMax(numbers);
		System.out.println("Max Value: " + maxValues[0]);
		System.out.println("Row Index of Max Value: " + maxValues[1]);
		System.out.println("Column Index of Max Value: " + maxValues[2]);
	}
	
	public static Integer[][] populate2DArray(int rows, int cols)
	{
		Integer[][] numbers = new Integer[rows][cols];
		Random r = new Random();
		System.out.println("2D Array: ");
		
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				numbers[i][j] = r.ints(-10000, 10001).limit(1).findFirst().getAsInt();
				System.out.print(numbers[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		return numbers;
	}
	
	public static Integer[] TwoDMax(Integer[][] numbers)
	{
		Integer[] maxValues = {Integer.MIN_VALUE, -1, -1}; //[max, rowMax, colMax]
		for(int i = 0; i < numbers.length; i++)
		{
			for(int j = 0; j < numbers[0].length; j++)
			{
				if(maxValues[0] < numbers[i][j])
				{
					maxValues[0] = numbers[i][j];
					maxValues[1] = i;
					maxValues[2] = j;
				}
			}
		}
		
		return maxValues;
	}

}
