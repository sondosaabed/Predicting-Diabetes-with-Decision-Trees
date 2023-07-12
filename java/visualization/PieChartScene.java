/**
 * 
 */
package visualization;

import java.text.DecimalFormat;

import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
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
import weka.core.Attribute;
import weka.core.Instances;

/**
 * This java class is cretaed to show the pie chart scene
 */
public class PieChartScene {
	// Fields
	private Stage stage;
	private Button cancel;

	/*
	 * Constructor
	 */
	public PieChartScene(Instances data) {
		initialize(data);
	}

	/*
	 * Initializer
	 */
	/**
	 * @param data
	 */
	private void initialize(Instances data) {
		stage = new Stage();
		GridPane pane = new GridPane();
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);

		pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(70, 150, 70, 150));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setBackground(background);

		GridPane pane1 = new GridPane();
		pane1.setAlignment(Pos.CENTER);
		pane1.setHgap(15);
		pane1.setVgap(15);
		pane1.setBackground(background);
		pane.add(pane1, 0, 0);

		Image img = new Image("resources/logo.png");
		ImageView v = new ImageView(img);
		v.setFitWidth(100);
		v.setFitHeight(100);

		Button logo = new Button();
		logo.setPrefSize(100, 100);
		logo.setGraphic(v);
		logo.setStyle(
				"-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
		GridPane.setHalignment(logo, HPos.CENTER);
		pane1.add(logo, 0, 0);

		Label ms = new Label("Diabetic people percentages");
		ms.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		ms.setTextFill(Color.DARKGREEN);
		pane1.add(ms, 1, 0);

		Attribute diabeticAttribute = data.attribute("Diabetic");

		double classCount0 = 0;
		double classCount1 = 0;

		for (int i = 0; i < data.numInstances(); i++) {
			double value = data.instance(i).value(diabeticAttribute);
			if (value == 0) {
				classCount0++;
			} else if (value == 1) {
				classCount1++;
			}
		}

		// Calculate the percentages
		double total = classCount0 + classCount1;
		double percent0 = (classCount0 / total) * 100;
		double percent1 = (classCount1 / total) * 100;

		PieChart.Data[] pieChartData = { new PieChart.Data("Positive (" + formatDecimal(percent0) + "%)", classCount0),
				new PieChart.Data("Negative (" + formatDecimal(percent1) + "%)", classCount1) };

		PieChart pieChart = new PieChart(FXCollections.observableArrayList(pieChartData));

		// Customize the colors of the pie chart slices
		pieChart.getData().forEach(t -> {
			if (t.getName().equals("Positive (" + formatDecimal(percent0) + "%)")) {
				/*
				 * Drak Red color for class 0
				 */
				t.getNode().setStyle("-fx-pie-color: darkred;"); 
			} else if (t.getName().equals("Negative (" + formatDecimal(percent1) + "%)")) {
				/*
				 * Dark Green  for class 1
				 */
				t.getNode().setStyle("-fx-pie-color: darkgreen;"); 
			}
		});
		pieChart.setLegendVisible(false);
		pieChart.setTitle("Diabetic atttribute");
		pieChart.setPadding(new Insets(20));
		pieChart.setStyle("-fx-background-color:white;-fx-border-color:black;-fx-border-radius:7;-fx-border-width:5;");
		pane.add(pieChart, 0, 2);

		// User button to cancel the stage
		cancel = new Button("Cancel");
		cancel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
		cancel.setPrefSize(80, 20);
		cancel.setTextFill(Color.WHITE);
		GridPane.setHalignment(cancel, HPos.CENTER);
		cancel.setStyle("-fx-background-radius: 18, 7;-fx-background-color:black;");
		pane.add(cancel, 0, 6);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("Diabites Pie Chart");
		stage.getIcons().add(new Image("resources/logo.png"));
	}

	/*
	 * In this method a double value is taken and formated into two digits
	 */
	/**
	 * @param value
	 * @return the new decimal format
	 */
	private String formatDecimal(double value) {
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		return decimalFormat.format(value);
	}

	/*
	 * Getters and setters
	 */
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