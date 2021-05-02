package application;

import application.guiShapes.ControlArea;
import application.guiShapes.NodeShapes;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;

//import javafx.scene.paint.Color;

public class Main extends Application {

	public void start(Stage stage) {

		Group root = new Group();
		new ControlArea(root);
		NodeShapes shapes = new NodeShapes(root);
		
		// Setting the stage
		Scene scene = new Scene(root, 1500, 700);
		stage.setTitle("Signal Flow Graph");
		stage.setScene(scene);
		stage.show();

		shapes.AddNode();
		shapes.AddNode();
		shapes.AddNode();
		shapes.AddNode();
		shapes.AddNode();
		shapes.AddNode();
		shapes.AddNode();
		shapes.AddNode();
		shapes.AddNode();
		shapes.AddNode();
		shapes.AddNode();

	}

	public static void main(String args[]) {
		launch(args);
	}
}
