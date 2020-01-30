/**
 * 
 */
package com.ss.oop.assignment1;

/**
 * @author Kyle Sneeden
 * Defines printAsterisk to print in the shape of a triangle.
 */
public class Triangle extends ThreeSides 
{

	/**
	 * @param name
	 * @param height
	 * @param rightSideUp
	 */
	public Triangle(String name, Integer height, boolean rightSideUp) 
	{
		super(name, height, rightSideUp);
	}

	@Override
	public void printAsterisk() 
	{
		String asterisk = "";
		
		if(rightSideUp)
		{
			for(int i = 0; i < height.intValue(); i++)
			{
				asterisk += "*";
				System.out.println(asterisk);
			}
			ThreeSides.printDots();
		}
		else
		{
			ThreeSides.printDots();
			for(int i = 0; i < height.intValue(); i++)
			{
				asterisk = "";
				for(int j = i; j < height.intValue(); j++)
				{
					asterisk += "*";
				}
				System.out.println(asterisk);
			}
		}
		System.out.println();
	}

}
