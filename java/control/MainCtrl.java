/**
 * 
 */
package control;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import visualization.MainScene;
import weka.core.Instances;

/**
 * I have created this class to control the main scene
 */
public class MainCtrl {
	//Feilds
	private Button statics;
	private Button predict;
	private MainScene scene;
	/*
	 * Constructot
	 */
	/**
	 * @param stage
	 * @param data
	 */
	public MainCtrl(Stage stage, Instances data) {
		initialize(stage, data);
	}
	/*
	 * Initializer
	 */
	/**
	 * @param stage
	 * @param data
	 */
	private void initialize(Stage stage, Instances data) {
		setScene(new MainScene(stage));
		setStatics(getScene().getStatics());
		setPredict(getScene().getPredict());
		handle_statics(getStatics(), stage, data);
		handle_predict(getPredict(), stage, data);
	}
	/*
	 * Handlers
	 */
	/*
	 * This method redirects the user to the form page
	 */
	/**
	 * @param predict2
	 * @param stage
	 * @param data
	 */
	private void handle_predict(Button predict2, Stage stage, Instances data) {
		predict2.setOnAction(r->{
			FormCtrl scene = new FormCtrl(stage);
			scene.show(data);
		});
	}
	/*
	 * This method redirects the user to the statics screen where they decide what type of 
	 * ststics they wnat to see
	 */
	/**
	 * @param statics2
	 * @param stage
	 * @param data
	 */
	private void handle_statics(Button statics2, Stage stage, Instances data) {
		statics2.setOnAction(e->{
			ShowStaticsCtrl scene = new ShowStaticsCtrl(stage);
			scene.show(data);
		});
	}

	/**
	 * @return the statics
	 */
	public Button getStatics() {
		return statics;
	}

	/**
	 * @param statics the statics to set
	 */
	public void setStatics(Button statics) {
		this.statics = statics;
	}

	/**
	 * @return the predict
	 */
	public Button getPredict() {
		return predict;
	}

	/**
	 * @param predict the predict to set
	 */
	public void setPredict(Button predict) {
		this.predict = predict;
	}

	/**
	 * @return the scene
	 */
	public MainScene getScene() {
		return scene;
	}

	/**
	 * @param scene the scene to set
	 */
	public void setScene(MainScene scene) {
		this.scene = scene;
	}
}
