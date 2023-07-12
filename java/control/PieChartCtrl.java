/**
 * 
 */
package control;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import visualization.PieChartScene;
import weka.core.Instances;

/**
 * this class I created to show thr pie chart of the target class
 */
/**
 * 
 */
public class PieChartCtrl {
	// FEilds
	private PieChartScene scene;
	private Button cancel;
	private Stage stage;

	/**
	 * @param data
	 */
	public PieChartCtrl(Instances data) {
		initialize(data);
	}

	/**
	 * @param data
	 */
	private void initialize(Instances data) {
		setScene(new PieChartScene(data));
		setCancel(getScene().getCancel());
		setStage(getScene().getStage());
		handle_cancel(getCancel());
	}

	/*
	 * Handle the button cancel and close the stage
	 */
	/**
	 * @param cancel2
	 */
	private void handle_cancel(Button cancel2) {
		cancel2.setOnAction(e -> {
			getScene().getStage().close();
		});
	}

	/*
	 * This shows the Scene
	 */
	public void show() {
		getScene().getStage().show();
	}

	/*
	 * Getters abd Setters
	 */
	/**
	 * @return the scene
	 */
	public PieChartScene getScene() {
		return scene;
	}

	/**
	 * @param scene the scene to set
	 */
	public void setScene(PieChartScene scene) {
		this.scene = scene;
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
	 * @return the stage
	 */
	public Stage getStage() {
		return stage;
	}

	/**
	 * @param stage the stage to set
	 */
	public void setStage(Stage stage) {
		this.stage = stage;
	}
}
