/**
 * 
 */
package control;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import machineLearning.DecisionTree;
import visualization.RiskResultScene;
import weka.core.Instance;
import weka.core.Instances;
/**
 * In this class I create a controller for the risk result stage
 */
public class RiskResultCtrl {
	// Attributes
	private Stage window;
	private Label message;
	private Button cancel;
	private RiskResultScene scene;
	private double risk;
	private double answer;

	/*
	 * Constructor
	 */

	/**
	 * @param data
	 * @param newInstance
	 * @throws Exception
	 */
	public RiskResultCtrl(Instances data, Instance newInstance, Stage stage) throws Exception {
		initialize(data, newInstance, stage);
	}

	/*
	 * Initialize scene
	 */
	/**
	 * @param data
	 * @param newInstance
	 * @throws Exception
	 */
	private void initialize(Instances data, Instance newInstance, Stage stage) throws Exception {
		try {
			DecisionTree tree = new DecisionTree(data);
			setAnswer(tree.predict(newInstance));
			setScene(new RiskResultScene(getAnswer()));
			setCancel(getScene().getCancel());
			setMessage(getScene().getMessage());
			setWindow(getScene().getWindow());
			window.show();
			handle_cancel(getCancel(), stage, data);
		} catch (Exception e) {
			AlertBoxCtrl alert = new AlertBoxCtrl(e.getMessage(), e.getLocalizedMessage());
			alert.show();
		}
	}

	/*
	 * create a handler method for cancel
	 */
	private void handle_cancel(Button cancel2, Stage stage, Instances data) {
		cancel2.setOnAction(e -> {
			FormCtrl scene = new FormCtrl(stage);
			scene.show(data);
			getWindow().close();
		});
	}

	/**
	 * @return the window
	 */
	public Stage getWindow() {
		return window;
	}

	/**
	 * @param window the window to set
	 */
	public void setWindow(Stage window) {
		this.window = window;
	}

	/**
	 * @return the message
	 */
	public Label getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(Label message) {
		this.message = message;
	}

	/**
	 * @return the cancel
	 */
	public Button getCancel() {
		return cancel;
	}

	/**
	 * @param cancel the cancel to set
	 */
	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}

	/**
	 * @return the scene
	 */
	public RiskResultScene getScene() {
		return scene;
	}

	/**
	 * @param scene the scene to set
	 */
	public void setScene(RiskResultScene scene) {
		this.scene = scene;
	}

	/**
	 * @return the risk
	 */
	public double getRisk() {
		return risk;
	}

	/**
	 * @param risk the risk to set
	 */
	public void setRisk(double risk) {
		this.risk = risk;
	}

	/**
	 * @return the answer
	 */
	public double getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(double answer) {
		this.answer = answer;
	}
}