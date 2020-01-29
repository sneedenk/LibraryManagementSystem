/**
 * 
 */
package com.ss.oop.assignment2;

/**
 * @author Kyle Sneeden
 *
 */
public class Triangle implements Shape {

	/**
	 * @param base
	 * @param height
	 */
	private Double base;
	private Double height;
	
	public Triangle(Double base, Double height) 
	{
		this.base = base;
		this.height = height;
	}

	@Override
	public Double calculateArea() 
	{
		return 0.5 * base * height;
	}

	@Override
	public void display() 
	{
		System.out.println("Base: " + base);
		System.out.println("Height: " + height);
		System.out.println("Area: " + calculateArea());
	}

}
