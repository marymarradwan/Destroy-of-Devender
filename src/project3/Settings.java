package project3;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class Settings extends Pane {

    Label label = new Label("Player Name:");
    TextField playerName = new TextField("player");
    Label time = new Label("Time Game:");
    static ComboBox sizetime = new ComboBox();
    Button back = new Button("Back");
    //String name = get
    ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("photo.jpg")));

    public Settings() {

        label.setPrefSize(200, 200);
        playerName.setPrefSize(200, 60);
        time.setPrefSize(250, 60);
        back.setPrefSize(250, 60);
        sizetime.setPrefSize(200, 60);

        label.setTranslateX(270);
        label.setTranslateY(90);
        playerName.setTranslateX(430);
        playerName.setTranslateY(160);
        time.setTranslateX(280);
        time.setTranslateY(250);
        sizetime.setTranslateX(430);
        sizetime.setTranslateY(260);
        back.setTranslateX(250);
        back.setTranslateY(350);

        imageView.setFitWidth(800);
        imageView.setFitHeight(900);

        Font font = new Font(25);
        label.setFont(font);
        playerName.setFont(font);
        back.setFont(font);
        
         time.setStyle(
                "-fx-font-family: Arial;"
                + "-fx-font-size: 25px;"
                + "-fx-text-fill: white;"
                + "-fx-font-weight: bold;"
        );
         label.setStyle(
                "-fx-font-family: Arial;"
                + "-fx-font-size: 25px;"
                + "-fx-text-fill: white;"
                + "-fx-font-weight: bold;"
        );
        
        
        

        sizetime.getItems().addAll("10:00", "15:00", "50:00");
         getChildren().add(imageView);
        getChildren().add(label);
        getChildren().add(playerName);
        getChildren().add(time);

        getChildren().add(back);
        getChildren().add(sizetime);
       

        back.setOnAction((Action) -> {
            App.ViewGame(App.startgame);
        });

    }

}
