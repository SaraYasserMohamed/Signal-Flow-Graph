package application.guiShapes;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.QuadCurve;

public class Arc {
	private Group root;
	private Circle c1;
	private Circle c2;
	QuadCurve arc;
	private double width;
	public Arc(Group root,Circle c1,Circle c2,double width) {
		this.root = root;
		this.c1 = c1;
		this.c2 = c2;
		this.width = width;
		drawArc();
	}
	private void drawArc() {
		arc = new QuadCurve();  
		
		arc.startXProperty().bind(c1.centerXProperty());
		arc.startYProperty().bind(c1.centerYProperty());
		arc.endXProperty().bind(c2.centerXProperty());
		arc.endYProperty().bind(c2.centerYProperty());
		
		double X = (c1.getCenterX()+c2.getCenterX())/2.0;
		double Y = (c1.getCenterX()-c2.getCenterX())/4.0;
		arc.setControlX(X);
		arc.setControlY(350+Y);
		
		arc.setStroke(Color.YELLOW);
		arc.setStrokeWidth(width);
		arc.setFill(null);
		root.getChildren().add(2, arc);
		
	}
	void setWidth(double width) {
		arc.setStrokeWidth(width);
	}

}
