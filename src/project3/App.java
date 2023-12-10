package project3;

import javafx
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
//import static javafx.scene.text.Font.font;

//يحتوي على جميع القيم المشتركة بين الكلاسات وقمنا بتعريفها ك ستاتيك 
public class App {

    static StartGame startgame = new StartGame();
    static Start start = new Start();
    static Settings settings = new Settings();
    static Map map = new Map();
    
    public static void ViewGame(Pane pane) {
        startgame.setVisible(false);
        start.setVisible(false);
        settings.setVisible(false);
        map.setVisible(false);
        pane.setVisible(true);
    }
    
    public static void setDefaultSettings() {
        Settings.sizetime.getSelectionModel().select(0);
        Font font = new Font(25);
        Settings.sizetime.setStyle("-fx-font-size: " + font.getSize() + "px;");
        
    }
}

