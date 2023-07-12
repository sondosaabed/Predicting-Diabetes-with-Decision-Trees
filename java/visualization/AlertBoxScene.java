package visualization;

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
/*
 * In this class I create a scene that shows a new window with some specific alert for the user
 *	this scene is shown in a new stage that is opened 
 *	the users are able to close the scene but the error must be handled  
 */
public class AlertBoxScene {
	//Attributes
	private Stage window;
	private Label message;
	private Button cancel;
	private GridPane pane;
	
	/*
	 * this is the constructor of the scene
	 */
	public AlertBoxScene() {
		initialize();
	}
	/*
	 * This method initialize the scene style and nodes
	 */
	private void initialize() {
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);

		pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(100, 100, 100, 100));
		pane.setHgap(15);
		pane.setVgap(15);
		pane.setBackground(background);

		Image img = new Image("resources/logo.png");
		ImageView v = new ImageView(img);
		v.setFitWidth(70);
		v.setFitHeight(70);

		Button logo = new Button();
		logo.setPrefSize(70, 70);
		logo.setGraphic(v);
		logo.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
		GridPane.setHalignment(logo, HPos.CENTER);
		pane.add(logo, 0, 0);
		
		message=new Label();
		message.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		message.setTextFill(Color.DARKRED);
		pane.add(message, 0, 1);
		
		//User button to exit
		cancel = new Button("Okay");
		cancel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
		cancel.setPrefSize(80, 20);
		cancel.setTextFill(Color.WHITE);
		GridPane.setHalignment(cancel,HPos.CENTER);
		cancel.setStyle("-fx-background-radius: 18, 7;-fx-background-color:darkred;");
		pane.add(cancel,0,2); 

		Scene scene = new Scene(pane);
		window=new Stage();
		window.setScene(scene);
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