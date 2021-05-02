package application;
	
import application.guiShapes.NodeShapes;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public synchronized void start(Stage primaryStage) {
		try {
			Group root = new Group();
			Scene scene = new Scene(root,1200,700);
			NodeShapes shapes = new NodeShapes(root);
			primaryStage.setTitle("Signal Flow Graph");
			primaryStage.setScene(scene);
			primaryStage.show();
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
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
