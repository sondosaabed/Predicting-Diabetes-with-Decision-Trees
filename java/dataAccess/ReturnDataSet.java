/**
 * 
 */
package dataAccess;

import java.io.File;
import java.util.Random;

import weka.core.Instances;
import weka.core.converters.CSVLoader;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NumericToNominal;

/**
 * This class is created to load the dataset that was gotten from the csv file
 * and returns the dataset for further use and training ...
 */
public class ReturnDataSet {
	/*
	 * Returns the data instances and sets the target class from numerical to nominal
	 */
	/**
	 * @return dataset
	 */
	public static Instances getTData() {
		CSVLoader loader = new CSVLoader();
		Instances data = null;
		try {
			loader.setSource(new File("resources/DiabetesData.csv"));
			data = loader.getDataSet();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * shuffle the dataset
		 */
		data.randomize(new Random(1));
		targetToNominal(data);
		data.setClassIndex(data.numAttributes() - 1);
		return data;
	}

	/*
	 * In this method I convert the target class from numerical to nominal
	 */
	/**
	 * @param data
	 * @return data
	 */
	private static Instances targetToNominal(Instances data) {

		NumericToNominal filter = new NumericToNominal();
		filter.setAttributeIndices(String.valueOf(data.numAttributes() - 1));
		try {
			filter.setInputFormat(data);
			data = Filter.useFilter(data, filter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}