package application.guiShapes;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.QuadCurve;

public class Arc {
	private Group root;
	private Circle c1;
	private Circle c2;
	private Arrow arrow;
	QuadCurve arc;
	private double width;
	public Arc(Group root,Circle c1,Circle c2,double width) {
		this.root = root;
		this.c1 = c1;
		this.c2 = c2;
		this.width = width;
		drawArc();
		drawArrow();
	}
	private void drawArc() {
		arc = new QuadCurve();  
		
		arc.startXProperty().bind(c1.centerXProperty());
		arc.startYProperty().bind(c1.centerYProperty());
		arc.endXProperty().bind(c2.centerXProperty());
		arc.endYProperty().bind(c2.centerYProperty());
		
		double X = (c1.getCenterX()+c2.getCenterX())/2;
		double Y = (c1.getCenterX()-c2.getCenterX())/4;
		arc.setControlX(X);
		arc.setControlY(350+Y);
		
		arc.setStroke(Color.YELLOW);
		arc.setStrokeWidth(width);
		arc.setFill(null);
		root.getChildren().add(2, arc);
		
	}
	public void setControl () {
		double X = (c1.getCenterX()+c2.getCenterX())/2;
		double Y = ((c1.getCenterX()-c2.getCenterX())/4)+350;
		arc.setControlX(X);
		arc.setControlY(Y);
		arrow.updateRotate(arc);
		
	}
	private void drawArrow() {
		 arrow = new Arrow(arc);
		c1.centerXProperty().addListener(e ->{
		arrow.updateRotate(arc);
		});
		c1.centerYProperty().addListener(e ->{
		arrow.updateRotate(arc);
		});
		c2.centerXProperty().addListener(e ->{
		arrow.updateRotate(arc);
		});
		c2.centerYProperty().addListener(e ->{
		arrow.updateRotate(arc);
		});
		root.getChildren().add(arrow.getShape());
		
	}
	void setWidth(double width) {
		arc.setStrokeWidth(width);
	}

}
