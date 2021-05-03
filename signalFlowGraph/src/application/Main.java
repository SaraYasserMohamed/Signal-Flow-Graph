package application;

import java.io.File;

import application.graph.Graph;
import application.guiShapes.ControlArea;
import application.guiShapes.NodeShapes;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Main extends Application {

	public void start(Stage stage) {
		Graph graph = new Graph();
		Group root = new Group();
		setBackground(root);
		NodeShapes shapes = new NodeShapes(root,graph);
		new ControlArea(root,shapes,graph);
		// Setting the stage
		Scene scene = new Scene(root, 1500, 700);
		stage.setTitle("Signal Flow Graph");
		stage.setScene(scene);
		stage.show();
	}
	public static void setBackground(Group root) {
		
		Image background1 = new Image(new File("Crystal-clear-sea-10.jpg").toURI().toString());
		ImageView vm = new ImageView(background1);
		vm.setLayoutX(5);
		vm.setLayoutY(5);
		vm.setFitHeight(690);
		vm.setFitWidth(1190);
		  
        // create a image
		Image background2 = new Image(new File("backGround.jpg").toURI().toString());
		ImageView vm2 = new ImageView(background2);
		vm2.setLayoutX(1200);
		root.getChildren().addAll(vm);
		root.getChildren().addAll(vm2);
	}

	public static void main(String args[]) {
		launch(args);
	}
}
