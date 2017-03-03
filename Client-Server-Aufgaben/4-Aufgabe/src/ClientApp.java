/**
 * Created by Borri Mirco on 03.03.2017.
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("rootLayout.fxml"));               //GUI erstellen
            primaryStage.setTitle("4-Gewinnt-IP-Spiel");
            primaryStage.setScene(new Scene(root, 800, 460));
            primaryStage.setResizable(false);
            primaryStage.getIcons().add(new Image("icon.png"));
            primaryStage.show();
            primaryStage.setOnCloseRequest(windowEvent -> {
                Platform.exit();
                primaryStage.close();
                System.exit(-1);
            });


        } catch (IOException e) {

            e.printStackTrace();


        }
    }

}
