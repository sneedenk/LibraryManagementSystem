/**
 * 
 */
import com.ss.oop.assignment2.Rectangle;
import com.ss.oop.assignment2.Circle;
import com.ss.oop.assignment2.Triangle;

/**
 * @author Kyle Sneeden
 *
 */
public class ShapeTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Rectangle rectangle = new Rectangle(4.0, 6.5);
		rectangle.display();
		
		Circle circle = new Circle(8.8);
		circle.display();
		
		Triangle triangle = new Triangle(6.6, 8.1);
		triangle.display();
	}

}
