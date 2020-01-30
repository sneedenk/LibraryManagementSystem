/**
 * 
 */
package com.ss.oop.assignment1;

/**
 * @author Kyle Sneeden
 * Defines printAsterisk to print in the shape of a pyramid.
 */
public class Pyramid extends ThreeSides 
{

	/**
	 * @param name
	 * @param height
	 * @param rightSideUp
	 */
	public Pyramid(String name, Integer height, boolean rightSideUp) 
	{
		super(name, height, rightSideUp);
	}

	@Override
	public void printAsterisk() 
	{
		System.out.println("Another test change2");
		
		Integer width = new Integer((height.intValue() * 2) - 1);
				
		if(rightSideUp)
		{
			for(int i = 0; i < height.intValue(); i++)
			{
				String asterisk = "  ";

				int j;
				for(j = i; j < height.intValue() - 1; j++)
				{
					asterisk += " ";
				}
				asterisk += "*";
				for(j = width.intValue() - i; j < width.intValue(); j++)
				{
					asterisk += "**";
				}
				
				System.out.println(asterisk);
			}
			ThreeSides.printDots();
		}
		else
		{
			ThreeSides.printDots();
			for(int i = 0; i < height.intValue(); i++)
			{
				String asterisk = "  ";
				
				int j;
				for(j = width.intValue() - i; j < width.intValue(); j++)
				{
					asterisk += " ";
				}
				asterisk += "*";
				for(j = i; j < height.intValue() - 1; j++)
				{
					asterisk += "**";
				}
				
				System.out.println(asterisk);
			}
		}
		System.out.println();
	}
}
