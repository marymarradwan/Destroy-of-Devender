package project3;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;


public class StartGame extends Pane {
          //انشاء الازرار
        Button start = new Button("Start");
    Button settings = new Button("Settings");
    Button exit = new Button("Exit");
    
     public StartGame(){
      //تحديد موقع الازرار
     start.setTranslateX(220);
        start.setTranslateY(120);
        settings.setTranslateX(220);
        settings.setTranslateY(230);
        exit.setTranslateX(220);
        exit.setTranslateY(350);
    //تحديد حجم الازرار
      start.setPrefSize(340, 80);
        settings.setPrefSize(340, 80);
        exit.setPrefSize(340, 80);
        
         
        Font font = new Font(25);               
 
        start.setFont(font);                              
      settings.setFont(font); 
        exit.setFont(font); 
        
        
        
    
      //اضافة الازرار الى الواجهة
       getChildren().add(start);
       getChildren().add(settings);
        getChildren().add(exit);
      
        start.setOnAction((Action) -> {
           // App.ViewGame(App.start);
            DoDGameManager d = new DoDGameManager();
            d.start();
        });

      settings.setOnAction((Action) -> {
            App.ViewGame(App.settings);
    
    
           });
        exit.setOnAction((Action) -> {
            System.exit(0);
        });
              }
}
    

