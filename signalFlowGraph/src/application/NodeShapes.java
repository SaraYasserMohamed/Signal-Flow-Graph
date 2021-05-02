package application;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class NodeShapes {
	
	private int ScreenWidth = 1200;
	private int NodeNum = 2;
	private Group root;
	private ArrayList<Circle> circles;
	
	public NodeShapes(Group root) {
		this.root = root;
		circles = new ArrayList<Circle>();
		initialize();
	}
	
	private void SetNodeShapes() {
		double radius = 200/NodeNum;
		double distance  = ScreenWidth/NodeNum;
		Circle c;
		for (int i = 0 ; i < NodeNum;i++) {
			c = new Circle(i*distance+distance/2,350,radius);
			if (i == 0) 
				c.setFill(Color.GREEN);
			else if (i == NodeNum-1)
				c.setFill(Color.RED);
			else
				c.setFill(Color.GRAY);
			circles.add(c);
		}
	}
	private void initialize() {
		SetNodeShapes();
		this.root.getChildren().addAll(circles);
	}
	
	public void AddNode() {
		NodeNum++;
		double radius = 200/NodeNum;
		double distance  = ScreenWidth/NodeNum;
		Circle c = null;int i;
		for (i = 0 ; i < circles.size() ; i++) {
			c = circles.get(i);
			c.setCenterX(i*distance+distance/2);
			c.setRadius(radius);
		}
		if (i!=0)
			c.setFill(Color.GRAY);
		c = new Circle(i*distance+distance/2,350,radius);
		c.setFill(Color.RED);
		circles.add(c);
		root.getChildren().add(c);
	}
	

	public ArrayList<Circle> getNodes() {
		return circles;
	}

}
