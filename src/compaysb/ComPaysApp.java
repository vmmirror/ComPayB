package compaysb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ComPaysApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ComPaysApp.class.getResource("ComPays.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 670, 270);
        stage.setTitle("Комунальные платежи");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}