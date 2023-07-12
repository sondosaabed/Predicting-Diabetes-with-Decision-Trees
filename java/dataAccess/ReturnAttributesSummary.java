
package dataAccess;

import java.text.DecimalFormat;
import java.util.ArrayList;
import model.AttributeSummary;
import weka.core.Attribute;
import weka.core.AttributeStats;
import weka.core.Instances;

/**
 * I have created this class to return the attributes Summaries in the form of
 * array list
 */
public class ReturnAttributesSummary {
	/*
	 * This method sets the list of the Attributes Summaries to be shown in the
	 * table
	 */
	/**
	 * @param data
	 */
	public static ArrayList<AttributeSummary> getSummaries(Instances data) {
		DecimalFormat decimalFormat = new DecimalFormat("#.####"); // I used this to have 3 digits answer
		ArrayList<AttributeSummary> list = new ArrayList<>();

		for (int i = 0; i < data.numAttributes(); i++) {
			/*
			 * For each attribute create an attribute status object provided by WEKA
			 */
			Attribute attribute = data.attribute(i);
			AttributeStats stats = data.attributeStats(i);
			
			double mean = Double.parseDouble(decimalFormat.format(stats.numericStats.mean));
			double stdDev = Double.parseDouble(decimalFormat.format(stats.numericStats.stdDev));
			double min = Double.parseDouble(decimalFormat.format(stats.numericStats.min));
			double max = Double.parseDouble(decimalFormat.format(stats.numericStats.max));
			double count = Double.parseDouble(decimalFormat.format(stats.numericStats.count));

			double[] attributeValues = data.attributeToDoubleArray(i);
			double median = calculateMedian(attributeValues); // Calculate the median using the below method

			AttributeSummary attributeSummary = new AttributeSummary(attribute.name(), mean, median, stdDev, min, max, count);

			list.add(attributeSummary);
		}
		return list;
	}

	/*
	 * this method calculates the median by sorting the array and getting the middle
	 * elemnt Since the AttributeStats class doesn't get the median
	 */
	/**
	 * @param values
	 * @return
	 */
	private static double calculateMedian(double[] values) {
		double[] sortedValues = values.clone();
		java.util.Arrays.sort(sortedValues);

		if (values.length % 2 == 0) {
			return (sortedValues[(values.length / 2) - 1] + sortedValues[values.length / 2]) / 2.0;
		} else {
			return sortedValues[values.length / 2];
		}
	}
}