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
 * 	 in this class I created the main scene to be the first secne shown 
 * 	where the user decide what they want to predict their risk or to check out the statics
 */
public class MainScene {
	//Feilds
	private Button statics;
	private Button predict;
	private GridPane pane;

	/*
	 * Constructor
	 */
	/**
	 * @param stage
	 */
	public MainScene(Stage stage) {
		initialize(stage);
	}
	/*
	 * this is a method that initialize the scene style and nodes
	 */
	/**
	 * @param stage
	 */
	private void initialize(Stage stage){
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);

		pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(70, 150,70, 150));
		pane.setHgap(15);
		pane.setVgap(15);
		pane.setBackground(background);
		
		GridPane pane1 = new GridPane();
		pane1.setAlignment(Pos.CENTER);
		pane1.setHgap(15);
		pane1.setVgap(15);
		pane1.setBackground(background);
		pane.add(pane1, 0, 0);
		
		Image img1 = new Image("resources/risk.png");
		ImageView v1 = new ImageView(img1);
		v1.setFitWidth(190);
		v1.setFitHeight(190);
		
		Image img2 = new Image("resources/statics.png");
		ImageView v2 = new ImageView(img2);
		v2.setFitWidth(190);
		v2.setFitHeight(190);
		
		Image img = new Image("resources/logo.png");
		ImageView v = new ImageView(img);
		v.setFitWidth(100);
		v.setFitHeight(100);
		
		Button logo = new Button();
		logo.setPrefSize(100, 100);
		logo.setGraphic(v);
		logo.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
		GridPane.setHalignment(logo, HPos.CENTER);
		pane1.add(logo, 0, 0);
		
		Label ms=new Label("Hello User!");
		ms.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		ms.setTextFill(Color.DARKGREEN);
		pane1.add(ms, 1, 0);
		
		statics = new Button();
		statics.setPrefSize(200, 200);
		statics.setGraphic(v2);
		statics.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 7;-fx-background-color: darkgreen;");
		GridPane.setHalignment(statics, HPos.CENTER);
		pane.add(statics, 0, 2);
		
		Label statics=new Label("Curious about Diabeties Statics?");
		statics.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		statics.setTextFill(Color.DARKRED);
		pane.add(statics, 0, 1);
		
		predict = new Button();
		predict.setPrefSize(200, 200);
		predict.setGraphic(v1);
		predict.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 7;-fx-background-color: darkgreen;");
		GridPane.setHalignment(predict, HPos.CENTER);
		pane.add(predict, 0, 4);
		
		Label predict=new Label("Are you at risk of Diabeties?");
		predict.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		predict.setTextFill(Color.DARKRED);
		pane.add(predict, 0, 3);
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
		stage.setTitle("Diabites Predictor");
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