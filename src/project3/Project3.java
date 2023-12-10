package project3;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;



public class Project3 extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            ScrollPane scroll = new ScrollPane();
  GridPane root = new GridPane();
            Scene scene = new Scene(scroll,800, 600);
   scroll.setStyle("-fx-font-size: 20px;");
            root.getChildren().add(App.settings.imageView);
            root.getChildren().add(App.startgame);
            root.getChildren().add(App.start);
             root.getChildren().add(App.map);
            root.getChildren().add(App.settings);
            App.ViewGame(App.startgame);
            //   App.ViewGame(App.settings);
            App.setDefaultSettings();
            root.minWidthProperty().bind(Bindings.createDoubleBinding(() -> 
        scroll.getViewportBounds().getWidth(), scroll.viewportBoundsProperty()));
            root.minHeightProperty().bind(Bindings.createDoubleBinding(() -> 
        scroll.getViewportBounds().getHeight(), scroll.viewportBoundsProperty()));

            scroll.setContent(root);

            primaryStage.setTitle("Destroy OR Defend");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) throws IOException {
        DoDGameManager doDGameManager = new DoDGameManager();
        doDGameManager.creatfile();
        //doDGameManager.start();
        launch(args);
    }

}
