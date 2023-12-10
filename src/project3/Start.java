
package project3;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Start extends Pane
{
    static int click=0;
    GridPane grid = new GridPane();
    Button[][] b = new Button[20][20];
    Button stop = new Button("Stop");
    Button btn1 = new Button("Up");
    Button btn2 = new Button("Down");
    Button btn3 = new Button("<-");
    Button btn4 = new Button("->");
    Button btn5 = new Button("+");
    Button btn6 = new Button("-");
    Line line1 = new Line();
    Line line2 = new Line();
    Line line3 = new Line();
    Line line4 = new Line();
    Line line5 = new Line();
    Line line6 = new Line();
    Label lb1 = new Label("River");
    Label lb2 = new Label("Valley");
    Label lb3 = new Label("Attacker");
    Label lb4 = new Label("Bridge");
    Label lb5 = new Label("Defender");
    Label lb6 = new Label("Base");
    ImageView imageView2 = new ImageView(new Image(getClass().getResourceAsStream("photo2.jpg")));
    void colorStyle(int x,int y,color c)
    {
        if (c==color.red)
        {
            b[x][y].setStyle("-fx-color:red;");
        }
        else if (c==color.CORAL)
        {
            b[x][y].setStyle("-fx-color:CORAL;");
        }
        else if (c==color.CORNFLOWERBLUE)
        {
            b[x][y].setStyle("-fx-color:CORNFLOWERBLUE;");
        }
        else if (c==color.DARKBLUE)
        {
            b[x][y].setStyle("-fx-color:DARKBLUE;");
        }
        else if (c==color.GRAY)
        {
            b[x][y].setStyle("-fx-color:GRAY;");
        }
        else if (c==color.YELLOW)
        {
            b[x][y].setStyle("-fx-color:YELLOW;");
        }
        else
            if(b[x][y].getStyle()!="-fx-color:WHITE;")
                b[x][y].setStyle("-fx-color:WHITE;");

    }
    void colorborderStyle(int x,int y,color c)
    {
        if (c==color.red)
        {
            b[x][y].setStyle(b[x][y].getStyle()
                    +" -fx-border-color:red;"
                    +"  -fx-border-width: 0.5 0.5 0.5 0.5;");
        }
        else if (c==color.CORAL)
        {
            b[x][y].setStyle(b[x][y].getStyle()
                    +" -fx-border-color:CORAL;"
                    +"  -fx-border-width: 0.5 0.5 0.5 0.5;");
        }
        else if (c==color.CORNFLOWERBLUE)
        {
            b[x][y].setStyle(b[x][y].getStyle()
                    +" -fx-border-color:CORNFLOWERBLUE;"
                    +"  -fx-border-width: 0.5 0.5 0.5 0.5;");
        }
        else if (c==color.DARKBLUE)
        {
            b[x][y].setStyle(b[x][y].getStyle()
                    +" -fx-border-color:DARKBLUE;"
                    +"  -fx-border-width: 0.5 0.5 0.5 0.5;");
        }
        else if (c==color.GRAY)
        {
            b[x][y].setStyle(b[x][y].getStyle()
                    +" -fx-border-color:GRAY;"
                    +"  -fx-border-width: 0.5 0.5 0.5 0.5;");
        }
        else if (c==color.YELLOW)
        {
            b[x][y].setStyle(b[x][y].getStyle()
                    +" -fx-border-color:YELLOW;"
                    +"  -fx-border-width: 0.5 0.5 0.5 0.5;");
        }
        else
            b[x][y].setStyle(b[x][y].getStyle()
                    +" -fx-border-color:White;"
                    +"  -fx-border-width: 0.0 0.0 0.0 0.0;");

    }
    public Start()
    {
        getChildren().add(imageView2);
        stop.setPrefSize(80, 50);
        stop.setTranslateX(650);
        stop.setTranslateY(520);

        btn4.setPrefSize(80, 50);
        btn4.setTranslateX(650);
        btn4.setTranslateY(460);

        btn3.setPrefSize(80, 50);
        btn3.setTranslateX(650);
        btn3.setTranslateY(400);

        btn2.setPrefSize(80, 50);
        btn2.setTranslateX(650);
        btn2.setTranslateY(340);

        btn1.setPrefSize(80, 50);
        btn1.setTranslateX(650);
        btn1.setTranslateY(280);

        btn5.setPrefSize(30,30);
        btn5.setTranslateX(620);
        btn5.setTranslateY(230);

        btn6.setPrefSize(40,30);
        btn6.setTranslateX(700);
        btn6.setTranslateY(230);


        line1.setStartX(680);
        line1.setStartY(30);
        line1.setEndX(750);
        line1.setEndY(30);
        line1.setScaleY(10);
        line1.setStroke(Color.CORNFLOWERBLUE);
        getChildren().add(line1);

        line2.setStartX(680);
        line2.setStartY(60);
        line2.setEndX(750);
        line2.setEndY(60);
        line2.setScaleY(10);
        line2.setStroke(Color.CORAL);
        getChildren().add(line2);

        line3.setStartX(680);
        line3.setStartY(90);
        line3.setEndX(750);
        line3.setEndY(90);
        line3.setScaleY(10);
        line3.setStroke(Color.DARKBLUE);
        getChildren().add(line3);

        line4.setStartX(680);
        line4.setStartY(120);
        line4.setEndX(750);
        line4.setEndY(120);
        line4.setScaleY(10);
        line4.setStroke(Color.GRAY);
        getChildren().add(line4);

        line5.setStartX(680);
        line5.setStartY(150);
        line5.setEndX(750);
        line5.setEndY(150);
        line5.setScaleY(10);
        line5.setStroke(Color.RED);
        getChildren().add(line5);

        line6.setStartX(680);
        line6.setStartY(180);
        line6.setEndX(750);
        line6.setEndY(180);
        line6.setScaleY(10);
        line6.setStroke(Color.YELLOW);
        getChildren().add(line6);

        lb1.setLayoutX(610);
        lb1.setLayoutY(10);
        getChildren().add(lb1);

        lb2.setLayoutX(610);
        lb2.setLayoutY(40);
        getChildren().add(lb2);

        lb3.setLayoutX(590);
        lb3.setLayoutY(70);
        getChildren().add(lb3);

        lb4.setLayoutX(610);
        lb4.setLayoutY(100);
        getChildren().add(lb4);

        lb5.setLayoutX(590);
        lb5.setLayoutY(130);
        getChildren().add(lb5);

        lb6.setLayoutX(610);
        lb6.setLayoutY(160);
        getChildren().add(lb6);



        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                b[i][j] = new Button();
                b[i][j].setStyle("-fx-pref-width:10px;-fx-pref-Height:5px" + b[i][j].getStyle());
                //b[i][j].setStyle("-fx-pref-Padding:5px;" + b[i][j].getStyle());
                // b[i][j].setPrefSize(5,5);
                grid.setAlignment(Pos.CENTER);
                grid.add(b[i][j], i, j);
                // getChildren().add(b[20][20]);

            }
        }
        imageView2.setFitWidth(800);
        imageView2.setFitHeight(900);
        grid.setPadding(new Insets(10));

        getChildren().add(stop);
        getChildren().add(btn1);
        getChildren().add(btn2);
        getChildren().add(btn3);
        getChildren().add(btn4);
        colorStyle(7, 5, color.DARKBLUE);

       //colorStyle(5, 5, color.WHITE);
        getChildren().add(grid);

        stop.setOnAction((Action) -> {
            DoDGameManager.state=GameState.Paused;
            App.map.View();
            App.ViewGame(App.map);
        });
        btn1.setOnAction((Action) -> {
            if (CreateMap.i1 >= 200) {
                CreateMap.i1 -= 200;
                View();
                //App.start.View();
            }

        });
        btn2.setOnAction((Action) -> {
            if (10000 - CreateMap.i1  >= 200) {
                CreateMap.i1 += 200;
                View();
                //App.start.View();
            }
        });
        btn3.setOnAction((Action) -> {
            if (CreateMap.j1 >= 200) {
                CreateMap.j1 -= 200;
                View();
                //App.start.View();
            }

        });
        btn4.setOnAction((Action) -> {
            if (10000 - CreateMap.j1 >= 200) {
                CreateMap.j1 += 200;
                View();
               // App.start.View();
            }
        });

    }
    public void View(){
        if(click%10==0){
            new CreateMap().Map();
            new CreateMap().MapTerrain();
            for (int i=0;i<20;i++)
                for (int j=0;j<20;j++){
                    colorStyle(i, j, CreateMap.colors1[i][j]);
                    colorborderStyle(i, j, CreateMap.colorsterrain1[i][j]);
                }
        }


    }
}
