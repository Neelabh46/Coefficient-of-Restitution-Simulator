package sample;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball extends Node {
    private Circle circle;
    private double x;
    private double y;
    Circle getCircle() {
        return circle;
    }

    Ball(){
        circle= new Circle(10, Color.NAVY);
        circle.relocate(50,25);
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public Node getStyleableNode() {
        return null;
    }
}