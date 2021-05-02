package application;

import application.graph.Graph;
import application.guiShapes.ControlArea;
import application.guiShapes.NodeShapes;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//import javafx.scene.paint.Color;

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
	private void setBackground(Group root) {
		Image background1 = new Image("https://www.edarabia.com/ar/wp-content/uploads/2020/11/5-historical-monuments-world-take-sightseeing-historical-tour.jpg");
		ImageView vm = new ImageView(background1);
		vm.setFitHeight(700);
		vm.setFitWidth(1200);
		  
        // create a image
		Image background2 = new Image("https://sm.mashable.com/t/mashable_in/photo/default/nasa-galaxy_9pu4.1920.jpg");
		ImageView vm2 = new ImageView(background2);
		vm2.setLayoutX(1200);
		root.getChildren().addAll(vm);
		root.getChildren().addAll(vm2);
	}

	public static void main(String args[]) {
		launch(args);
	}
}
