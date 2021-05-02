package application;
	

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {
   public void start(Stage stage) {
      //Creating a Label
      Label labelNode = new Label("Nodes Number:");
      Label labelEdge = new Label("Gain:");
      //Setting font to the label
      Font font = Font.font("Brush Script MT", FontWeight.BOLD, FontPosture.REGULAR, 15);
      labelNode.setFont(font);
      //Filling color to the label
      labelNode.setTextFill(Color.WHITE);
      //Setting the position
      labelNode.setTranslateX(5);
      labelNode.setTranslateY(7);
      TextField Nodes = new TextField("2");
      Nodes.setLayoutX(80);
      Nodes.setLayoutY(5);
      Nodes.setMaxWidth(90); Nodes.setMinWidth(90);
      Nodes.setEditable(false);
      //tf.setDisable(true);
      
      Button addNode = new Button("Add Node");
      addNode.setLayoutX(180);
      addNode.setLayoutY(5);
      addNode.setMaxWidth(80); addNode.setMinWidth(80);
      
      labelEdge.setFont(font);
      //Filling color to the label
      labelEdge.setTextFill(Color.WHITE);
      labelEdge.setTranslateX(15);
      labelEdge.setTranslateY(37);
      
      TextField Gain = new TextField();
      Gain.setLayoutX(80);	  
      Gain.setLayoutY(35);
      Gain.setMaxWidth(90); Gain.setMinWidth(90);
      
      Button addEdge = new Button("Add Edge");
      addEdge.setLayoutX(180);
      addEdge.setLayoutY(35);
      addEdge.setMaxWidth(80); addEdge.setMinWidth(80);
      
      Button clear = new Button("Clear");
      clear.setLayoutX(20);
      clear.setLayoutY(75);
      clear.setMaxWidth(230); clear.setMinWidth(230);
      clear.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #ffffff");
      //clear.setStyle("-fx-text-fill: #ffffff");
      
      Button slove = new Button("SLove");
      slove.setLayoutX(20);
      slove.setLayoutY(125);
      slove.setMaxWidth(230); slove.setMinWidth(230);
      slove.setStyle("-fx-background-color: #00ff00");
      
      
      TextArea textArea = new TextArea();
      textArea.setLayoutX(5);
      textArea.setLayoutY(160);
      textArea.setMaxWidth(260); textArea.setMinWidth(260);
      textArea.setMaxHeight(450); textArea.setMinHeight(450);
      textArea.setEditable(false);
     
      Group root = new Group();
      root.getChildren().add(labelNode);
      root.getChildren().add(labelEdge);
      root.getChildren().add(Nodes);
      root.getChildren().add(Gain);
      root.getChildren().add(addNode);
      root.getChildren().add(addEdge);
      root.getChildren().add(clear);
      root.getChildren().add(slove);
      root.getChildren().add(textArea);
      //Setting the stage
      Scene scene = new Scene(root, 900, 650, Color.GRAY);
      stage.setTitle("Signal Flow Graph");
      stage.setScene(scene);
      stage.show();
   }
   public static void main(String args[]){
      launch(args);
   }
}