/**
 * 
 */
package com.ss.oop.assignment2;

/**
 * @author Kyle Sneeden
 *
 */
public class Rectangle implements Shape 
{

	/**
	 * @param length
	 * @param wideth
	 */
	
	private Double length;
	private Double width;
	
	public Rectangle(Double length, Double width) 
	{
		this.length = length;
		this.width = width;
	}

	@Override
	public Double calculateArea() 
	{
		return length * width;
	}

	@Override
	public void display() 
	{
		System.out.println("Length: " + length);
		System.out.println("Width: " + width);
		System.out.println("Area: " + calculateArea());
	}

}
