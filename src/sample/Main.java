package sample;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;
import java.io.IOException;


public class Main extends Application {

    static Scene scene1 ;

    static Ball circle = new Ball();

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Coefficient of Restitution Simulator");
        scene1 = new Scene(root, 600, 600);
        primaryStage.setScene(scene1);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
