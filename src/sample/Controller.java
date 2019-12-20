package sample;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.ArrayList;


public class Controller {

    @FXML
    Button start;

    @FXML
    AnchorPane paness;

    @FXML
    Text h1;
    @FXML
    Text h2;
    @FXML
    Text h3;
    @FXML
    Text h4;
    @FXML
    Text h5;
    @FXML
    Text h6;
    @FXML
    Text h7;
    @FXML
    Text h8;
    @FXML
    Text h9;
    @FXML
    Text h10;

    @FXML
     TextField height;
    @FXML
     TextField coefficient ;
    private double ht;
    private double e;
    PathTransition p;
    Circle c;
    private  Circle circle = Main.circle.getCircle();
    public void Start()
    {
        Transition();
    }

    private  Timeline timeline;
    private  ArrayList<Double> heights =  new ArrayList<>();

    @FXML
    public void Reset()
    {
        height.clear();
        coefficient.clear();
        paness.getChildren().remove(c);
        p.stop();
        h1.setVisible(false);
        h1.setText("");
        h2.setVisible(false);
        h2.setText("");
        h3.setVisible(false);
        h3.setText("");
        h4.setVisible(false);
        h4.setText("");
        h5.setVisible(false);
        h5.setText("");
        h6.setVisible(false);
        h6.setText("");
        h7.setVisible(false);
        h7.setText("");
        h8.setVisible(false);
        h8.setText("");
        h9.setVisible(false);
        h9.setText("");
        h10.setVisible(false);
        h10.setText("");
        heights.clear();


    }
    public void Transition()
    {
        ht = Double.parseDouble(height.getText());
        e = Double.parseDouble(coefficient.getText());

        Double[] arr = new Double[40];

        Double startx = 150.0;
        Double starty = 600-ht;
        c = new Circle();
        c.setRadius(10);
        c.setStroke(Color.RED);
        c.setCenterY(starty);
        c.setCenterX(startx);
        arr[0]=startx;
        arr[1]=starty;
        arr[2]=150.0;
        arr[3]=575.0;

        heights.add(Math.round(ht * 100.0) / 100.0);
        System.out.println(startx + " "+starty);
        for(int i=4;i<=36;i=i+4)
        {
            arr[i]= 150.0;
            arr[i+1]= 575-e*ht;
            arr[i+2] = 150.0;
            arr[i+3] = 575.0;
            System.out.println(arr[i] +" "+arr[i+1]);
            System.out.println(arr[i+2] +" "+arr[i+3]);
            System.out.println(ht);
            ht = e*e*ht;
            heights.add(Math.round(ht * 100.0) / 100.0);
        }
        arr[39]=565.0;
        System.out.println(c.getCenterX()+" "+c.getCenterY());
        paness.getChildren().add(c);
        h1.setText("H1 = "+heights.get(0));
        h1.setVisible(true);
        h2.setText("H2 = "+heights.get(1));
        h2.setVisible(true);
        h3.setText("H3 = "+heights.get(2));
        h3.setVisible(true);
        h4.setText("H4 = "+heights.get(3));
        h4.setVisible(true);
        h5.setText("H5 = "+heights.get(4));
        h5.setVisible(true);
        h6.setText("H6 = "+heights.get(5));
        h6.setVisible(true);
        h7.setText("H7 = "+heights.get(6));
        h7.setVisible(true);
        h8.setText("H8 = "+heights.get(7));
        h8.setVisible(true);
        h9.setText("H9 = "+heights.get(8));
        h9.setVisible(true);
        h10.setText("H10 = "+heights.get(9));
        h10.setVisible(true);

        Polyline polyline = new Polyline();
        polyline.getPoints().addAll(arr);
        p  = new PathTransition();
        p.setNode(c);
        if(e<0.75)
        {
            p.setDuration(Duration.seconds(5));
        } else if(e==1){
            System.out.println("help");
            p.setDuration(Duration.seconds(20));
        }else{
            p.setDuration(Duration.seconds(15));
        }
        p.setPath(polyline);
        p.setCycleCount(1);
        p.play();
    }
}
