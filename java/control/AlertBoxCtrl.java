package control;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import visualization.AlertBoxScene;

/*
 * Creates a controller for the Alert window, 
 * In which it shows a message and sets a title
 */
public class AlertBoxCtrl {
	// Attributes
	private AlertBoxScene scene;
	private Label message;
	private Button cancel;

	// Constructor
	/**
	 * @param meassage String
	 * @param title String
	 */
	public AlertBoxCtrl(String meassage, String title) {
		initialize(meassage, title);
	}
	/**
	 * @param meassage String
	 * @param title String
	 */
	// A method to initialize the scene
	private void initialize(String meassage, String title) {
		setScene(new AlertBoxScene());
		setMessage(getScene().getMessage());
		setCancel(getScene().getCancel());

		getScene().getWindow().setTitle(title);
		getMessage().setText(meassage);

		handle_cancel(cancel);
	}

	// A method that shows a new stage
	public void show() {
		getScene().getWindow().show();
	}

	/*
	 * Handlers
	 */
	/**
	 * @param cancel2 Button
	 */
	private void handle_cancel(Button cancel2) {
		// Method that handles cancel
		cancel2.setOnAction(e -> {
			getScene().getWindow().close();
		});
	}
	/*
	 * Getters and Setters
	 */

	/**
	 * @return the scene
	 */
	public AlertBoxScene getScene() {
		return scene;
	}

	/**
	 * @param scene the scene to set
	 */
	public void setScene(AlertBoxScene scene) {
		this.scene = scene;
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
}