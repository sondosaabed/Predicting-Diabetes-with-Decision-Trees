/**
 * 
 */
package control;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import visualization.FormScene;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

/**
 * In this class I create a controller for the form submitted
 */
public class FormCtrl {
	// Feilds
	private Stage stage;
	private FormScene scene;
	private MainCtrl scene1;
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

	// Constructor
	/**
	 * @param stage Stage
	 */
	public FormCtrl(Stage stage) {
		setStage(stage);
	}

	// this method shows the scene on teh stage
	/**
	 * @param data Instances
	 */
	public void show(Instances data) {
		setScene(new FormScene(getStage()));
		initilize(getStage(), data);
	}

	// Initilize scene
	/**
	 * @param stage Stage
	 * @param data  Instances
	 */
	private void initilize(Stage stage2, Instances data) {
		setNpg(getScene().getNpg());
		setPgl(getScene().getPgl());
		setDia(getScene().getDia());
		setTsf(getScene().getTsf());
		setIns(getScene().getIns());
		setBmi(getScene().getBmi());
		setDpf(getScene().getDpf());
		setAge(getScene().getAge());
		setCancel(getScene().getCancel());
		setSubmit(getScene().getSubmit());
		handle_cancel(getCancel(), stage2, data);
		handle_submit(getSubmit(), data);
	}

	/*
	 * create Handlers methods for buttons
	 */
	/*
	 * This is a method that handles the form submission
	 */
	/**
	 * @param submit2
	 * @param data
	 */
	private void handle_submit(Button submit2, Instances data) {
		submit2.setOnAction(e -> {
			RiskResultCtrl result;
			try {
				// Create a new instance based on the user's input on the form
				Instance newInstance = new DenseInstance(data.numAttributes());
				newInstance.setDataset(data);
				newInstance.setValue(0, Integer.parseInt(npg.getText()));
				newInstance.setValue(1, Integer.parseInt(pgl.getText()));
				newInstance.setValue(2, Integer.parseInt(dia.getText()));
				newInstance.setValue(3, Integer.parseInt(tsf.getText()));
				newInstance.setValue(4, Integer.parseInt(ins.getText()));
				newInstance.setValue(5, Double.parseDouble(bmi.getText()));
				newInstance.setValue(6, Double.parseDouble(dpf.getText()));
				newInstance.setValue(7, Integer.parseInt(age.getText()));
				//create a new scene to show the result
				result = new RiskResultCtrl(data, newInstance, stage);
				result.getWindow().show();
			} catch (Exception e1) {
				//If an exception is thrown show it in a new Alert box 
				AlertBoxCtrl alert = new AlertBoxCtrl(e1.getMessage(), e1.getLocalizedMessage());
				alert.show();
			}
		});
	}

	/*
	 * This method handles the Cancel the scene and returns back to show the main
	 * scene;
	 */
	/**
	 * @param cancel2
	 * @param stage
	 * @param data
	 */
	private void handle_cancel(Button cancel2, Stage stage, Instances data) {
		cancel2.setOnAction(o -> {
			setScene1(new MainCtrl(stage, data));
		});
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

	/**
	 * @return the scene
	 */
	public FormScene getScene() {
		return scene;
	}

	/**
	 * @param scene the scene to set
	 */
	public void setScene(FormScene scene) {
		this.scene = scene;
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
	 * @return the scene1
	 */
	public MainCtrl getScene1() {
		return scene1;
	}

	/**
	 * @param scene1 the scene1 to set
	 */
	public void setScene1(MainCtrl scene1) {
		this.scene1 = scene1;
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