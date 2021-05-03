package application.guiShapes;

import java.util.ArrayList;

import application.graph.Graph;
import javafx.scene.Group;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class NodeShapes {

	private int ScreenWidth = 1200, NodeNum = 2;
	private double radius, distance;
	private Group root;
	private ArrayList<Circle> circles;
	private ArrayList<Arc> Edges;
	private ArrayList<Text> texts;
	private Graph graph;
	public NodeShapes(Group root,Graph graph) {
		this.root = root;
		this.graph = graph;
		circles = new ArrayList<Circle>();
		Edges = new ArrayList<Arc>();
		texts = new ArrayList<Text>();
		initialize();
	}

	private void SetNodeShapes() {
		Circle c;
		for (int i = 0; i < NodeNum; i++) {
			graph.addNewBasicNode(i);
			c = new Circle(i * distance + distance / 2, 350, radius);
			c.setEffect(new DropShadow());
			addActions(c);
			if (i == 0)
				c.setFill(Color.GREEN);
			else if (i == NodeNum - 1)
				c.setFill(Color.RED);
			else
				c.setFill(Color.BLACK);
			circles.add(c);
			root.getChildren().add(c);
			AddText(c,i);
		}
	}

	private void initialize() {
		setCalculations();
		SetNodeShapes();
	}

	public void AddNode() {
		NodeNum++;
		setCalculations();
		Circle c = null;
		int i;
		for (i = 0; i < circles.size(); i++) {
			c = circles.get(i);
			c.setCenterX(i * distance + distance / 2);
			c.setRadius(radius);
		}
		if (i != 0)
			c.setFill(Color.BLACK);
		c = new Circle(i * distance + distance / 2, 350, radius);
		c.setEffect(new DropShadow());
		addActions(c);
		c.setFill(Color.RED);
		circles.add(c);
		root.getChildren().add(c);
		AddText(c,i);
		modifyEdges();
		modifyText();
	}
	
	public void ClearData() {
		circles = new ArrayList<Circle>();
		Edges = new ArrayList<Arc>();
		texts = new ArrayList<Text>();
	}
	
	private void AddText (Circle circle , int id) {
		Text text = new Text(id+"");
		text.setFill(Color.BLACK);
		text.setStroke(Color.GOLD);
		text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.ITALIC, 15));
		text.setStrokeWidth(1.5);
		text.setX(circle.getCenterX()-10);
		text.setY(circle.getCenterY()+circle.getRadius()+15);
		texts.add(text);
		//modifyText(circle, id);
		root.getChildren().add(text);
	}
	
	private void modifyText() {
		Text text;Circle circle;
		for (int i = 0 ; i < texts.size()-1;i++) {
			text = texts.get(i);
			circle = circles.get(i);
			text.setX(circle.getCenterX()-10);
			text.setY(circle.getCenterY()+circle.getRadius()+15);
		}
	}
	

	private void setCalculations() {
		radius = 200 / (double)NodeNum;
		distance = ScreenWidth /(double)NodeNum;
	}
	
	
	private int Node1ID,Node2ID;
	private Circle circle1;
	private String Gain;
	private boolean AddEdge = false;
	private boolean firstClick = true;
	private void addActions(Circle c) {
		c.setOnMouseClicked(e -> {
			if (AddEdge) {
				if (firstClick) {
					//Node1ID = circles.indexOf(c);
					circle1 = c ;
					//System.out.println("first click At Node "+Node1ID);
					firstClick = false;
				}else {
					Node1ID = circles.indexOf(circle1);
					Node2ID = circles.indexOf(c);
					//System.out.println("second click At Node "+Node2ID);
					graph.addNode(Node1ID, Node2ID, Gain);
					//double w = 10 / (double) NodeNum ;
					Edges.add(new Arc(root,circle1,c,4,Gain));
					firstClick = true;
					AddEdge = false;
				}
			}
		});
	}
	
	private void modifyEdges() {
		//double w = 10 / (double) NodeNum ;
		for (Arc arc : Edges) {
			arc.setControl();
			//arc.setWidth(1.5*w);
		}
	}
	
	
	public void AddEdge(String Gain) {
		AddEdge = true;
		this.Gain = Gain;
	}

	public ArrayList<Circle> getNodes() {
		return circles;
	}

}
