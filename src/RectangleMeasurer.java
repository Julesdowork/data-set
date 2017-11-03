import java.awt.Rectangle;

/**
 * Rectangle doesn't implement Measurable interface, so objects of this class
 * measure rectangles by area.
 * @author Julian McNeill
 */
public class RectangleMeasurer implements Measurer<Rectangle>,
	Measurable<Rectangle>
{
	private double area;
	
	public double measure(Object anObject)
	{
		Rectangle aRectangle = (Rectangle) anObject;
		area = aRectangle.getWidth() * aRectangle.getHeight();
		return area;
	}
	
	public double getMeasure()
	{
		return area;
	}
}
