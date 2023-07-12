package visualization;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
import model.AttributeSummary;
/*
 * In this class I create the scene in which each attribute summary will be shown
 */
public class TableViewScene {
	// Fields 
	private Stage stage;
	private Button cancel;
	/*
	 * Constructor
	 */
	/**
	 * @param list
	 */
	public TableViewScene(ArrayList<AttributeSummary> list) {
		initialize(list);
	}
	/*
	 * Initializer
	 */
	/**
	 * @param list
	 */
	@SuppressWarnings("unchecked")
	private void initialize(ArrayList<AttributeSummary> list) {
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

		Label ms = new Label("Numeric Summary table");
		ms.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		ms.setTextFill(Color.DARKGREEN);
		pane1.add(ms, 1, 0);

		TableView<AttributeSummary> table = new TableView<>();

		TableColumn<AttributeSummary, Double> attributeNameCol = new TableColumn<>("Name");
		attributeNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

		TableColumn<AttributeSummary, Double> meanCol = new TableColumn<>("Mean");
		meanCol.setCellValueFactory(new PropertyValueFactory<>("mean"));

		TableColumn<AttributeSummary, Double> medianCol = new TableColumn<>("Median");
		medianCol.setCellValueFactory(new PropertyValueFactory<>("median"));

		TableColumn<AttributeSummary, Double> stdDevCol = new TableColumn<>("Std. Dev.");
		stdDevCol.setCellValueFactory(new PropertyValueFactory<>("standard_deviation"));

		TableColumn<AttributeSummary, Double> minCol = new TableColumn<>("Min");
		minCol.setCellValueFactory(new PropertyValueFactory<>("min"));

		TableColumn<AttributeSummary, Double> maxCol = new TableColumn<>("Max");
		maxCol.setCellValueFactory(new PropertyValueFactory<>("max"));
		
		TableColumn<AttributeSummary, Double> countCol = new TableColumn<>("Count");
		countCol.setCellValueFactory(new PropertyValueFactory<>("count"));

		table.getColumns().addAll(attributeNameCol, meanCol, medianCol, stdDevCol, minCol, maxCol, countCol);
		ObservableList<AttributeSummary> data = FXCollections.observableArrayList(list);
		table.setItems(data);

		table.setStyle("-fx-font-size: 14pt; -fx-font-family: 'Lucida Sans Unicode';");
		table.setPadding(new Insets(10));
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
		
		table.setCenterShape(true);
		table.setPrefWidth(700);
		pane.add(table, 0, 2);

		// User button to cancel the stage
		cancel = new Button("Cancel");
		cancel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
		cancel.setPrefSize(80, 20);
		cancel.setTextFill(Color.WHITE);
		GridPane.setHalignment(cancel, HPos.CENTER);
		cancel.setStyle("-fx-background-radius: 18, 7;-fx-background-color:darkred;");
		pane.add(cancel, 0, 3);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("Diabites Statics");
		stage.getIcons().add(new Image("resources/logo.png"));
	}

	/*
	 * Getters and Setter
	 */
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