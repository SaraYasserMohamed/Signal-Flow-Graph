package application.guiShapes;

import java.util.ArrayList;

import application.graph.Graph;
import javafx.scene.Group;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class NodeShapes {

	private int ScreenWidth = 1200, NodeNum = 2;
	private double radius, distance;
	private Group root;
	private ArrayList<Circle> circles;
	private Graph graph;

	public NodeShapes(Group root,Graph graph) {
		this.root = root;
		this.graph = graph;
		circles = new ArrayList<Circle>();
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
		}
	}

	private void initialize() {
		setCalculations();
		SetNodeShapes();
		this.root.getChildren().addAll(circles);
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
	}
	public void reDraw() {
		Circle c;
		for (int i = 0; i < circles.size(); i++) {
			c = circles.get(i);
			c.setCenterX(i * distance + distance / 2);
			c.setRadius(radius);
		}
	}
	private void setCalculations() {
		radius = 200 / (double)NodeNum;
		distance = ScreenWidth /(double)NodeNum;
	}
	
	
	private int Node1ID,Node2ID;
	private Circle circle1,circle2 ;
	private String Gain;
	private boolean AddEdge = false;
	private boolean firstClick = true;
	private void addActions(Circle c) {
		c.setOnMouseClicked(e -> {
			if (AddEdge) {
				if (firstClick) {
					Node1ID = circles.indexOf(c);
					circle1 = c ;
					System.out.println("first click At Node "+Node1ID);
					firstClick = false;
				}else {
					Node2ID = circles.indexOf(c);
					circle2 = c ;
					System.out.println("second click At Node "+Node2ID);
					graph.addNode(Node1ID, Node2ID, Gain);
					new Arc(root,circle1,circle2,3.0);
					reDraw();
					firstClick = true;
					AddEdge = false;
				}
			}
		});
	}
	
	
	public void AddEdge(String Gain) {
		AddEdge = true;
		this.Gain = Gain;
	}

	public ArrayList<Circle> getNodes() {
		return circles;
	}

}
