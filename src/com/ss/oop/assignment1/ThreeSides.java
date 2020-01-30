/**
 * 
 */
package com.ss.oop.assignment1;

/**
 * @author Kyle Sneeden
 * An abstract class to provide some shared code for Triangle and Pyramid. 
 * There is one abstract method to be defined by subclasses.
 */
public abstract class ThreeSides 
{
	protected String name;
	protected Integer height;
	protected boolean rightSideUp;
	private static Integer numDots = new Integer(9);
	
	public ThreeSides(String name, Integer height, boolean rightSideUp)
	{
		this.name = name;
		this.height = height;
		this.rightSideUp = rightSideUp;
	}
	
	public void printName()
	{
		System.out.println(name);
	}
	
	public static void printDots()
	{
		for(int i = 0; i < numDots.intValue(); i++)
		{
			System.out.print(".");
		}
		System.out.println();
		
	}
	
	public static void incrementNumDots()
	{
		numDots = new Integer(numDots.intValue() + 1);
	}
	
	public static void printNumDots()
	{
		System.out.println(numDots);
	}
	
	abstract void printAsterisk();
}
