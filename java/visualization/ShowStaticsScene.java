/**
 * 
 */
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

/**
 * In this class I create the show statics scene that lets the user decide what type of statics they want
 * to see
 */
public class ShowStaticsScene {
	//Fields
	private Button cancel;
	private Button numeric;
	private Button plots;
	/*
	 * Constructor
	 */
	/**
	 * @param stage
	 */
	public ShowStaticsScene(Stage stage) {
		initialize(stage);
	}
	/*
	 * Initialize the scene
	 */
	
	/**
	 * @param stage
	 */
	private void initialize(Stage stage) {
		GridPane pane = new GridPane();
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);

		pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(70, 150,70, 150));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setBackground(background);
		
		Image img1 = new Image("resources/binoculars.png");
		ImageView v1 = new ImageView(img1);
		v1.setFitWidth(190);
		v1.setFitHeight(190);
		
		Image img2 = new Image("resources/statics.png");
		ImageView v2 = new ImageView(img2);
		v2.setFitWidth(190);
		v2.setFitHeight(190);
		
		numeric = new Button();
		numeric.setPrefSize(200, 200);
		numeric.setGraphic(v2);
		numeric.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 7;-fx-background-color: darkgreen;");
		GridPane.setHalignment(numeric, HPos.CENTER);
		pane.add(numeric, 0, 2);
		
		Label statics=new Label("Numbers Fan?");
		statics.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		statics.setTextFill(Color.DARKRED);
		GridPane.setHalignment(statics, HPos.CENTER);

		pane.add(statics, 0, 1);
		
		plots = new Button();
		plots.setPrefSize(200, 200);
		plots.setGraphic(v1);
		plots.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 7;-fx-background-color: darkgreen;");
		GridPane.setHalignment(plots, HPos.CENTER);
		pane.add(plots, 1, 2);
		
		Label predict=new Label("Prefer visuals?");
		predict.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		predict.setTextFill(Color.DARKRED);
		GridPane.setHalignment(predict, HPos.CENTER);
		pane.add(predict, 1, 1);

		//User button to exit
		cancel = new Button("Cancel");
		cancel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
		cancel.setPrefSize(80, 20);
		cancel.setTextFill(Color.WHITE);
		GridPane.setHalignment(cancel,HPos.RIGHT);
		cancel.setStyle("-fx-background-radius: 18, 7;-fx-background-color:darkred;");
		pane.add(cancel,1,6); 
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
		stage.setTitle("Diabites Statics");
	}
	
	/**
	 * @return the numeric
	 */
	public Button getNumeric() {
		return numeric;
	}
	/**
	 * @param numeric the numeric to set
	 */
	public void setNumeric(Button numeric) {
		this.numeric = numeric;
	}
	/**
	 * @return the plots
	 */
	public Button getPlots() {
		return plots;
	}
	/**
	 * @param plots the plots to set
	 */
	public void setPlots(Button plots) {
		this.plots = plots;
	}
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