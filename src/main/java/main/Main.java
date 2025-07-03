package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/joint_cell/tela_joint.fxml"));
        Scene scene = new Scene(root, 800,600);
        primaryStage.setTitle("Joint Cell");
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }

}