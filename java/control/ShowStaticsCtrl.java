/**
 * 
 */
package control;

import java.util.ArrayList;

import dataAccess.ReturnAttributesSummary;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.AttributeSummary;
import visualization.ShowStaticsScene;
import weka.core.Instances;

/**
 * This class I created to Control the Show statics scene
 */
public class ShowStaticsCtrl {
	//Fields
	private Stage stage;
	private ShowStaticsScene scene;
	private Button cancel;
	private Button numeric;
	private Button plots;
	private MainCtrl scene1;
	
	//Constructor
	/**
	 * @param stage
	 */
	public ShowStaticsCtrl(Stage stage) {
		setStage(stage);
	}
	/*
	 * This method shows the scene
	 */
	/**
	 * @param data
	 */
	public void show(Instances data) {
		setScene(new ShowStaticsScene(getStage()));
		initialize(data);
	}
	
	/*
	 * Initialize the scene
	 */
	/**
	 * @param data
	 */
	private void initialize(Instances data) {
		setCancel(getScene().getCancel());
		setNumeric(getScene().getNumeric());
		setPlots(getScene().getPlots());
		handle_cancel(cancel, stage, data);
		handle_numeric(numeric, data);
		handle_plots(plots, data);		
	}
	/*
	 * Handlers
	 */
	/**
	 * @param plots2
	 * @param stage2
	 * @param data
	 */
	private void handle_plots(Button plots2, Instances data) {
		plots2.setOnAction(e->{
			PieChartCtrl scene = new PieChartCtrl(data);
			scene.show();
		});		
	}
	/*
	 * This metod handles the numbers choice whwere the user is redirected to see the statics table
	 */
	/**
	 * @param numeric2
	 * @param data
	 */
	private void handle_numeric(Button numeric2, Instances data) {
		numeric2.setOnAction(e->{
			ArrayList<AttributeSummary> list = ReturnAttributesSummary.getSummaries(data);
			// show the alert if the list summary statics was found empt
			if(list.isEmpty()) {
				AlertBoxCtrl alert = new AlertBoxCtrl("Summary List is empty!", "Empty List");
				alert.show();
			}
			TableViewCtrl scene = new TableViewCtrl(list);
			scene.getStage().show();
		});		
	}
	/*
	 * When the user clicks cancel handle teh button by getting back to the main scene
	 */
	/**
	 * @param cancel2
	 * @param stage
	 * @param data
	 */
	private void handle_cancel(Button cancel2, Stage stage, Instances data) {
		cancel2.setOnAction(o->{
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
	public ShowStaticsScene getScene() {
		return scene;
	}
	/**
	 * @param scene the scene to set
	 */
	public void setScene(ShowStaticsScene scene) {
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
}