import java.util.ArrayList;

/**
 * Analyzes a set of data values.
 * @author Julian McNeill
 */
public class DataSet<T>
{
	private int count;
	private double sum;
	private T maximum;
	private T minimum;
	private ArrayList<T> list;
	private Measurer<T> measurer;
	
	/**
	 * Constructs an empty data set.
	 */
	public DataSet()
	{
		count = 0;
		sum = 0;
		maximum = null;
		minimum = null;
		list = new ArrayList<>();
		measurer = null;
	}
	
	/**
	 * Constructs an empty data set with a given measurer.
	 * @param aMeasurer the measurer that is used to measure data values
	 */
	public DataSet(Measurer<T> aMeasurer)
	{
		count = 0;
		sum = 0;
		maximum = null;
		minimum = null;
		list = new ArrayList<>();
		measurer = aMeasurer;
	}
	
	/**
	 * Adds a data value to the data set.
	 * @param obj a data value
	 */
	public void add(T obj)
	{
		if (measurer == null)
		{
			// If measurer is null, then T must implement Measurable
			Measurable<T> m = (Measurable<T>) obj;
			sum += m.getMeasure();
			Measurable<T> max = (Measurable<T>) maximum;
			Measurable<T> min = (Measurable<T>) minimum;
			if (count == 0 || m.getMeasure() > max.getMeasure())
				maximum = (T) obj;
			if (count == 0 || m.getMeasure() < min.getMeasure())
				minimum = (T) obj;
		}
		else
		{
			sum += measurer.measure(obj);
			if (count == 0 || measurer.measure(obj) > measurer.measure(maximum))
				maximum = obj;
			if (count == 0 || measurer.measure(obj) < measurer.measure(minimum))
				minimum = obj;
		}
		list.add(obj);
		count++;
	}
	
	public void addAll(DataSet<T> otherDataSet)
	{
		for (T element : otherDataSet.list)
			add(element);
	}
	
	/**
	 * Gets the average value of the added data.
	 * @return the average of the data
	 */
	public double getAverage()
	{
		if (count == 0) return 0;
		else
			return sum / count;
	}
	
	/**
	 * Gets the maximum value of the data set.
	 * @return the maximum
	 */
	public T getMaximum()
	{
		return (T) maximum;
	}
	
	/**
	 * Gets the minimum value of the data set.
	 * @return the maximum
	 */
	public T getMinimum()
	{
		return (T) minimum;
	}
}
