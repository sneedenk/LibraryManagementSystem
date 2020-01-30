/**
 * 
 */
import com.ss.oop.assignment1.*;

/**
 * @author Kyle Sneeden
 * A driver class that creates Triangle and Pyramid objects and 
 * calls their respective print methods to print the desired shapes.
 */
public class SS1 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{		
		System.out.println("test change2");
		Triangle rightSideUpTriangle = new Triangle("1)", 4, true);
		Triangle upsideDownTriangle = new Triangle("2)", 4, false);
		Pyramid rightSideUpPyramid = new Pyramid("3)", 4, true);
		Pyramid upsideDownPyramid = new Pyramid("4)|", 4, false);
		
		rightSideUpTriangle.printName();
		rightSideUpTriangle.printAsterisk();
		ThreeSides.incrementNumDots();
		upsideDownTriangle.printName();
		upsideDownTriangle.printAsterisk();
		ThreeSides.incrementNumDots();
		rightSideUpPyramid.printName();
		rightSideUpPyramid.printAsterisk();
		ThreeSides.incrementNumDots();
		upsideDownPyramid.printName();
		upsideDownPyramid.printAsterisk();
	}
	
}
