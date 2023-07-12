
package machineLearning;
import weka.core.Instance;
import weka.core.Instances;

import java.text.DecimalFormat;

import weka.classifiers.trees.REPTree;

/**
 * In this class based on the work I did using WEKA analysis the selected model was the one that splits 
 * the data using the 50:50 rule
 * So the analysis of comparing two model was done on WEKA and elaborated on the report 
 * but in this class I only train the model here and use it to predict the new instance 
 */
public class DecisionTree {
	// Fields
	private REPTree REPTree;
	private Instances data;

	/*
	 * Constructor
	 */
	/**
	 * @param data
	 * @throws Exception
	 */
	public DecisionTree(Instances data) throws Exception {
		setREPTree50(new REPTree());
		setData(data);
		REPTree = trainModel(REPTree, 0.5);
	}
	/*
	 * this is the training method
	 */
	/**
	 * @param tree
	 * @param trainSplit
	 * @return
	 * @throws Exception
	 */
	private REPTree trainModel(REPTree tree, double trainSplit) throws Exception {
		int trainSize = (int) (data.numInstances() * trainSplit);
		Instances trainingData = new Instances(data, 0, trainSize);
		tree.buildClassifier(trainingData);
		return tree;
	}

	/*
	 * This method takes a new instanse and predict wether it is in risk of diabetis or not
	 */
	/**
	 * @param newInput
	 * @return
	 * @throws Exception
	 */
	public double predict(Instance newInput) throws Exception {
		DecimalFormat decimalFormat = new DecimalFormat("#.####");
		String ans = decimalFormat.format(getREPTree50().classifyInstance(newInput));
		return Double.parseDouble(ans);
	}

	/*
	 * Getters and Setters
	 */
	/**
	 * @param data the data to set
	 */
	public void setData(Instances data) {
		this.data = data;
	}

	public Instances getData() {
		return data;
	}

	/**
	 * @return the rEPTree50
	 */
	public REPTree getREPTree50() {
		return REPTree;
	}

	/**
	 * @param rEPTree50 the rEPTree50 to set
	 */
	public void setREPTree50(REPTree rEPTree50) {
		REPTree = rEPTree50;
	}
}