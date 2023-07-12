package model;

/*
 * I have created this class to use in the table view scene
 * It is for each attribute
 */
public class AttributeSummary {
	/*
	 * Feilds
	 */
	private String name;
	private double mean;
	private double median;
	private double standard_deviation;
	private double min;
	private double max;
	private double count;
	/*
	 * Constructor
	 */
	/**
	 * @param mean
	 * @param median
	 * @param standard_deviation
	 * @param min
	 * @param max
	 * @param count2 
	 */

	/*
	 * Getters and Setters
	 */
	/**
	 * @return the mean
	 */
	public double getMean() {
		return mean;
	}
	/**
	 * @param name
	 * @param mean
	 * @param median
	 * @param standard_deviation
	 * @param min
	 * @param max
	 * @param count
	 */
	public AttributeSummary(String name, double mean, double median, double standard_deviation, double min, double max,
			double count) {
		super();
		setName(name);
		setMean(mean);
		setMedian(median);
		setStandard_deviation(standard_deviation);
		setMin(min);
		setMax(max);
		setCount(count);
	}
	/**
	 * @param mean the mean to set
	 */
	public void setMean(double mean) {
		this.mean = mean;
	}
	/**
	 * @return the median
	 */
	public double getMedian() {
		return median;
	}
	/**
	 * @param median the median to set
	 */
	public void setMedian(double median) {
		this.median = median;
	}
	/**
	 * @return the standard_deviation
	 */
	public double getStandard_deviation() {
		return standard_deviation;
	}
	/**
	 * @param standard_deviation the standard_deviation to set
	 */
	public void setStandard_deviation(double standard_deviation) {
		this.standard_deviation = standard_deviation;
	}
	/**
	 * @return the min
	 */
	public double getMin() {
		return min;
	}
	/**
	 * @param min the min to set
	 */
	public void setMin(double min) {
		this.min = min;
	}
	/**
	 * @return the max
	 */
	public double getMax() {
		return max;
	}
	/**
	 * @param max the max to set
	 */
	public void setMax(double max) {
		this.max = max;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the count
	 */
	public double getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(double count) {
		this.count = count;
	}
}	