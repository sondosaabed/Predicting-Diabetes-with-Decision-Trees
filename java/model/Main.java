package model;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import control.MainCtrl;
import dataAccess.ReturnDataSet;

/*
 * 		  Sondos Ahmad Aabed
 * 		  1190652
 * 		  Section Number 1
 * 
 * 		In this project a decision tree is implemented using Weka and given diabities dataset to predict 
 * 		if the user is at risk of diabities or not and to show diabties statics. 
 * 		Find in the submission files the report that elaborates on the process of 
 * 		developing this predixtor
 */

public class Main extends Application {
	/*
	 * This is the Main class in which the project is launched
	 */
	/**
	 * @param args String []
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * @param stage Stage
	 */
	@Override
	public void start(Stage stage) throws Exception {
		stage = new Stage();
		@SuppressWarnings("unused")
		MainCtrl mainctrl = new MainCtrl(stage, ReturnDataSet.getTData());
		stage.getIcons().add(new Image("resources/logo.png"));
	}
}