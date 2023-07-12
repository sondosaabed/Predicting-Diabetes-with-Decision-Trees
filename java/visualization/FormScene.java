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
import javafx.scene.control.TextField;
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
 * In this class I create the Form scene where the user fills the attributes of
 * a diabetis record to check If they have a risk of diabetes or not
 * All the values are numbers to be entered
 */
public class FormScene {
	/*
	 * FEilds
	 */
	private Button cancel;
	private Button submit;
	private TextField npg;
	private TextField pgl;
	private TextField dia;
	private TextField tsf;
	private TextField ins;
	private TextField bmi;
	private TextField dpf;
	private TextField age;

	/*
	 * Constructor
	 */
	/**
	 * @param stage
	 */
	public FormScene(Stage stage) {
		initialize(stage);
	}

	// This method will initialize feilds and set their styles
	/**
	 * @param stage
	 */
	private void initialize(Stage stage) {
		GridPane pane = new GridPane();
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);

		pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(70, 150, 70, 150));
		pane.setHgap(15);
		pane.setVgap(15);
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

		Label ms = new Label("Fill in the Form");
		ms.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		ms.setTextFill(Color.DARKGREEN);
		pane1.add(ms, 1, 0);

		Label npgLabel = new Label("NPG:");
		npgLabel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		npgLabel.setTextFill(Color.DARKGREEN);

		GridPane.setHalignment(npgLabel, HPos.CENTER);

		pane.add(npgLabel, 0, 1);
		npg = new TextField();
		npg.setPadding(new Insets(7, 10, 7, 10));
		npg.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
		pane.add(npg, 1, 1);

		Label pglLabel = new Label("PGL:");
		pglLabel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		pglLabel.setTextFill(Color.DARKGREEN);
		GridPane.setHalignment(pglLabel, HPos.CENTER);

		pane.add(pglLabel, 0, 2);
		pgl = new TextField();
		pgl.setPadding(new Insets(7, 10, 7, 10));
		pgl.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));

		pane.add(pgl, 1, 2);

		Label diaLabel = new Label("DIA:");
		diaLabel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		diaLabel.setTextFill(Color.DARKGREEN);
		GridPane.setHalignment(diaLabel, HPos.CENTER);

		pane.add(diaLabel, 0, 3);
		dia = new TextField();
		dia.setPadding(new Insets(7, 10, 7, 10));
		dia.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));

		pane.add(dia, 1, 3);

		Label tsfLabel = new Label("TSF:");
		tsfLabel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		tsfLabel.setTextFill(Color.DARKGREEN);
		GridPane.setHalignment(tsfLabel, HPos.CENTER);

		pane.add(tsfLabel, 0, 4);
		tsf = new TextField();
		tsf.setPadding(new Insets(7, 10, 7, 10));
		tsf.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));

		pane.add(tsf, 1, 4);

		Label insLabel = new Label("INS:");
		insLabel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		insLabel.setTextFill(Color.DARKGREEN);
		GridPane.setHalignment(insLabel, HPos.CENTER);

		pane.add(insLabel, 0, 5);
		ins = new TextField();
		ins.setPadding(new Insets(7, 10, 7, 10));
		ins.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
		pane.add(ins, 1, 5);

		Label bmiLabel = new Label("BMI:");
		bmiLabel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		bmiLabel.setTextFill(Color.DARKGREEN);
		GridPane.setHalignment(bmiLabel, HPos.CENTER);

		pane.add(bmiLabel, 0, 6);
		bmi = new TextField();
		bmi.setPadding(new Insets(7, 10, 7, 10));
		bmi.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));

		pane.add(bmi, 1, 6);

		Label dpfLabel = new Label("DPF:");
		dpfLabel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		dpfLabel.setTextFill(Color.DARKGREEN);
		GridPane.setHalignment(dpfLabel, HPos.CENTER);

		pane.add(dpfLabel, 0, 7);
		dpf = new TextField();
		dpf.setPadding(new Insets(7, 10, 7, 10));
		dpf.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));

		pane.add(dpf, 1, 7);

		Label ageLabel = new Label("AGE:");
		ageLabel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		ageLabel.setTextFill(Color.DARKGREEN);
		GridPane.setHalignment(ageLabel, HPos.CENTER);
		pane.add(ageLabel, 0, 8);

		age = new TextField();
		age.setPadding(new Insets(7, 10, 7, 10));
		age.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
		pane.add(age, 1, 8);

		// User button to exit
		cancel = initializeButton("Cancel", 80, 20, Color.WHITE);
		pane.add(cancel, 1, 9);

		// User button to submit
		submit = initializeButton("Submit", 80, 20, Color.WHITE);
		pane.add(submit, 0, 9);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
		stage.setTitle("Diabites Predictor");
	}

	/*
	 * This method was written to initialize a button
	 */
	/**
	 * @param name
	 * @param size1
	 * @param size2
	 * @param color
	 * @return
	 */
	private Button initializeButton(String name, int size1, int size2, Color color) {
		Button btn = new Button(name);
		btn.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
		btn.setPrefSize(size1, size2);
		btn.setTextFill(color);
		GridPane.setHalignment(btn, HPos.CENTER);
		btn.setStyle("-fx-background-radius: 18, 7;-fx-background-color:darkred;");
		return btn;
	}

	/*
	 * Getters and Setters
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
	 * @return the submit
	 */
	public Button getSubmit() {
		return submit;
	}

	/**
	 * @param submit the submit to set
	 */
	public void setSubmit(Button submit) {
		this.submit = submit;
	}

	/**
	 * @return the npg
	 */
	public TextField getNpg() {
		return npg;
	}

	/**
	 * @param npg the npg to set
	 */
	public void setNpg(TextField npg) {
		this.npg = npg;
	}

	/**
	 * @return the pgl
	 */
	public TextField getPgl() {
		return pgl;
	}

	/**
	 * @param pgl the pgl to set
	 */
	public void setPgl(TextField pgl) {
		this.pgl = pgl;
	}

	/**
	 * @return the dia
	 */
	public TextField getDia() {
		return dia;
	}

	/**
	 * @param dia the dia to set
	 */
	public void setDia(TextField dia) {
		this.dia = dia;
	}

	/**
	 * @return the tsf
	 */
	public TextField getTsf() {
		return tsf;
	}

	/**
	 * @param tsf the tsf to set
	 */
	public void setTsf(TextField tsf) {
		this.tsf = tsf;
	}

	/**
	 * @return the ins
	 */
	public TextField getIns() {
		return ins;
	}

	/**
	 * @param ins the ins to set
	 */
	public void setIns(TextField ins) {
		this.ins = ins;
	}

	/**
	 * @return the bmi
	 */
	public TextField getBmi() {
		return bmi;
	}

	/**
	 * @param bmi the bmi to set
	 */
	public void setBmi(TextField bmi) {
		this.bmi = bmi;
	}

	/**
	 * @return the dpf
	 */
	public TextField getDpf() {
		return dpf;
	}

	/**
	 * @param dpf the dpf to set
	 */
	public void setDpf(TextField dpf) {
		this.dpf = dpf;
	}

	/**
	 * @return the age
	 */
	public TextField getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(TextField age) {
		this.age = age;
	}
}