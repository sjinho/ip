package jinbot.gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jinbot.JinBot;

/**
 * A GUI for JinBot using FXML.
 */
public class Main extends Application {

    private JinBot jinbot = new JinBot();

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setJinBot(jinbot);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
