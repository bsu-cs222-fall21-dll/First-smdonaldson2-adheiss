package cs222.bsu.edu.wikipedia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("GUI.fxml")));

        Scene scene = new Scene(root,552,551);

        primaryStage.setTitle("Wikipedia Revisions");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
