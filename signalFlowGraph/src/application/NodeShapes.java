package application;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class NodeShapes {

	private int ScreenWidth = 1200, NodeNum = 2;
	private double radius, distance;
	private Group root;
	private ArrayList<Circle> circles;

	public NodeShapes(Group root) {
		this.root = root;
		circles = new ArrayList<Circle>();
		initialize();
	}

	private void SetNodeShapes() {
		Circle c;
		for (int i = 0; i < NodeNum; i++) {
			c = new Circle(i * distance + distance / 2, 350, radius);
			if (i == 0)
				c.setFill(Color.GREEN);
			else if (i == NodeNum - 1)
				c.setFill(Color.RED);
			else
				c.setFill(Color.GRAY);
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
			c.setFill(Color.GRAY);
		c = new Circle(i * distance + distance / 2, 350, radius);
		c.setFill(Color.RED);
		circles.add(c);
		root.getChildren().add(c);
	}
	private void setCalculations() {
		radius = 200 / NodeNum;
		distance = ScreenWidth / NodeNum;
	}

	public ArrayList<Circle> getNodes() {
		return circles;
	}

}
