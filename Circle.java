/**
 * 
 */
package com.ss.oop.assignment2;

/**
 * @author Kyle Sneeden
 *
 */
public class Circle implements Shape 
{

	/**
	 * @param radius
	 */
	private Double radius;
	
	public Circle(Double radius) 
	{
		this.radius = radius;	
	}

	@Override
	public Double calculateArea() 
	{
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	public void display() 
	{
		System.out.println("Radius: " + radius);
		System.out.println("Area: " + calculateArea());
	}

}
