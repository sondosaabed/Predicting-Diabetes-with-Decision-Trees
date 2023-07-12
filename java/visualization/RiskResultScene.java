/**
 * 
 */
package visualization;

import java.text.DecimalFormat;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * In this class I create the scene of the risk result
 */
public class RiskResultScene {
	// Attributes
	private Stage window;
	private Label message;
	private Button cancel;
	private GridPane pane;
	//Constructor
	/**
	 * @param string
	 */
	public RiskResultScene(double prediction) {
		initialize(prediction);
	}
	/*
	 * This method will initialize feilds and set their styles
	 */
	/**
	 * @param string
	 */
	private void initialize(double prediction) {
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);

		pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(100, 100, 100, 100));
		pane.setHgap(15);
		pane.setVgap(15);
		pane.setBackground(background);

		Image img = new Image("resources/noJunk.png");
		ImageView v = new ImageView(img);
		v.setFitWidth(150);
		v.setFitHeight(150);

		Image img2 = new Image("resources/freeD.png");
		ImageView v2 = new ImageView(img2);
		v2.setFitWidth(150);
		v2.setFitHeight(150);
		
		Image img1 = new Image("resources/warning.png");
		ImageView v1 = new ImageView(img1);
		v1.setFitWidth(150);
		v1.setFitHeight(150);

		Image img3 = new Image("resources/dr.png");
		ImageView v3 = new ImageView(img3);
		v3.setFitWidth(150);
		v3.setFitHeight(150);


		message = new Label();
		message.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		message.setTextFill(Color.DARKRED);
		pane.add(message, 0, 1);

		Button logo = new Button();
		logo.setPrefSize(160, 160);
		/*
		 * the threshold is 0.5, and I made different variations to show to the user
		 */
		DecimalFormat format = new DecimalFormat("#.###");
		if(prediction>=0.5 && prediction < 0.8) {
			logo.setGraphic(v);
			message.setText("You're at "+ format.format(prediction*100) +" % risk of diabetes, Beaware!");
			logo.setStyle(
					"-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 7;-fx-background-color: darkred;");
		}else if (prediction < 0.4){
			logo.setGraphic(v2);
			message.setText("Congratulations! you're at low risk of diabetes "+ format.format(prediction*100) + "%");
			logo.setStyle(
					"-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 7;-fx-background-color: darkgreen;");
			
		}else if (prediction >= 0.4 && prediction<0.5){
			logo.setGraphic(v1);
			message.setText("Warning! you're at close risk of diabetes "+ format.format(prediction*100) + "%");
			logo.setStyle(
					"-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 7;-fx-background-color: darkorange;");
		}if(prediction>=0.8 ) {
			logo.setGraphic(v3);
			message.setText("You have a very high risk"+ format.format(prediction*100) + " %, Seek dr");
			logo.setStyle(
					"-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 7;-fx-background-color: red;");
		}
		
		GridPane.setHalignment(logo, HPos.CENTER);
		pane.add(logo, 0, 0);

		// User button to exit
		cancel = new Button("Okay");
		cancel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
		cancel.setPrefSize(80, 20);
		cancel.setTextFill(Color.WHITE);
		GridPane.setHalignment(cancel, HPos.CENTER);
		cancel.setStyle("-fx-background-radius: 18, 7;-fx-background-color:darkred;");
		pane.add(cancel, 0, 2);

		Scene scene = new Scene(pane);
		window = new Stage();
		window.setScene(scene);
		window.setTitle("Are you at risk?");
		window.getIcons().add(new Image("resources/logo.png"));
	}

	/*
	 * Getters and Setters
	 */
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
	 * @return the pane
	 */
	public GridPane getPane() {
		return pane;
	}
	/**
	 * @param pane the pane to set
	 */
	public void setPane(GridPane pane) {
		this.pane = pane;
	}
}