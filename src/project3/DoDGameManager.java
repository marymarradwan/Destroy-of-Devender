
package project3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DoDGameManager extends Thread{
    static ArrayList<String> Printarray = new ArrayList<>();
    static int size=10000;
    static Unit MainBase = new Unit();
    static ArrayList<Unit> Units = new ArrayList<Unit>();
    static ArrayList<Terrain> Terrains = new ArrayList<Terrain>();
    static ArrayList<Commander> Commanders = new ArrayList<Commander>();
    static Team team[] = new Team[2];
    static int remainingAttackerUnits;
    static double Time=300;
    static double time = 0.0;
    static GameState state=GameState.Running;
    @Override
    public void run(){
        openGame();
    }
    public void openGame() {
        OpenGame openGame = new OpenGame();
        //openGame.PrintOrder();
        openGame.startGame();
    }
    public void creatfile() throws IOException{
        StartGame startGame = new StartGame();
        startGame.CreateGame();
    }
    public void createGame(){
        MainBase = new Unit();
        Units = new ArrayList<Unit>();
        Terrains = new ArrayList<Terrain>();
        Commanders = new ArrayList<Commander>();
        time = 0.0;
        state=GameState.Running;
    }
    public void WriteFile(){
            for (String element : Printarray) {
                if(Start.click%10==0)
                System.out.println(element);
            }


    }
    public class OpenGame {
        public void PrintOrder() {
                        startGame();
        }
        public void startGame() {
            StartGame startGame = new StartGame();
            startGame.Start();
        }
    }
    public class StartGame{
        public void CreateGame()throws IOException {
           MainBase=new Unit().CreateUnite(UnitName.MAIN_BASE);
           MainBase.generator(5000,5000,TeamPlayer.Defender,-1);
           MainBase.setIndex(0);
           DoDGameManager.Units.add(DoDGameManager.MainBase);
           team[0]=new LoadGame().ReadGame(0);
           team[1]=new LoadGame().ReadGame(1);
           int i=1;
           Terrains.addAll(new CreateTerrainFile().TerrainPositionRead());
           for (Team elementTeam : team){
               for (Player elementPlayer : elementTeam.players){
                   for (int j=0;j< elementPlayer.unitNames.size();j++){
                       Unit unit = new Unit().CreateUnite(elementPlayer.unitNames.get(j));
                       unit.generator(elementPlayer.unitPositions.get(j).getCenterX()
                               ,elementPlayer.unitPositions.get(j).getCenterY(),elementTeam.teamPlayer, elementPlayer.IdPlayer);
                       unit.setIndex(i);
                       if(unit.getUnitName()==UnitName.Black_Eagle)
                           for (Terrain elementTerrain : Terrains)
                               if(elementTerrain.getType()==TerrainType.flight_base)
                                     unit.setPositionLoad(elementTerrain.getPosition());
                       Units.add(unit);
                       i++;
                       if(elementTeam.teamPlayer==TeamPlayer.Attacker)
                           remainingAttackerUnits++;
                   }
               }
           }
        }
        public void Start(){
            while (time<Time){
                while (state==GameState.Paused){
                    try {
                        Thread.sleep(10);
                    }catch (InterruptedException e) {}
                }
                //System.out.println("<<<<<<<<<< "+time+" >>>>>>>>>>>>>");
                Printarray.clear();
                Commanders.clear();
                for (Unit element : Units){
                    element.Strategy();
                }
                for (Commander element : Commanders){
                    element.command();
                    if(MainBase.getHealth()<=0){
                        WriteFile();
                        System.out.println("Attackers are Winner");
                        App.start.View();
                        App.ViewGame(App.start);
                        return;
                    }
                    if(remainingAttackerUnits==0){
                        WriteFile();
                        System.out.println("Attackers are Loser");
                        App.start.View();
                        App.ViewGame(App.start);
                        return;
                    }
                }
                WriteFile();
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e) {}
                time += 0.1;
                Start.click++;
                if(GameState.Paused!=state){
                    App.start.View();
                    App.ViewGame(App.start);
                }
            }
            System.out.println("Attackers are Loser");
            return;
        }
    }
    public class Settings{
        public void PrintOrder(){
            Scanner sc = new Scanner(System.in);
            System.out.println("\t\t\t\tSettings");
            int choose;
            do{
                System.out.println("=================================");
                System.out.println("|\t\t\t  Player : " + Team.PlayerNumber*2 +"\t\t|");
                System.out.println("|\t\t\t   Time : " + Time + "\t\t|");
                System.out.println("|\t\t\t   Exit   \t\t\t|");
                System.out.println("=================================");
                System.out.print("Choose Number :");
                choose = sc.nextInt();
                switch (choose){
                    case 1:
                        if(Team.PlayerNumber==1) Team.PlayerNumber=2;
                        else Team.PlayerNumber=1;
                        break;
                    case 2:
                        if(Time==300.0) Time=500.0;
                        else if(Time==500.0) Time=1000.0;
                        else Time=300.0;
                        break;
                    case 0:
                        System.out.println("Exit...........");
                        break;
                    default:
                        System.out.println("Choose wrong !");
                }
            }while (choose!=0);
        }
    }
}