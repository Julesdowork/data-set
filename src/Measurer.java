/**
 * Describes any class whose objects can measure other objects.
 * @author Julian McNeill
 */
public interface Measurer<T>
{
	/**
	 * Computes the measure of an object.
	 * @param anObject the object to be measured
	 * @return the measure
	 */
	double measure(Object anObject);
}
