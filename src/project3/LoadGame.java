package project3;

import java.io.*;
public class LoadGame implements Serializable {
    private void WriteGame() throws IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("LoadGame.txt"));
        Player player1= new ConsolePlayer();
        player1.coins=0;
        player1.IdPlayer=1;
        player1.Name="Player1";
        player1.unitNames.add(UnitName.Prism_tank);
        player1.unitNames.add(UnitName.TeslaTank);
        player1.unitNames.add(UnitName.Sniper);
        player1.unitNames.add(UnitName.Mirage_tank);
        player1.unitNames.add(UnitName.Tank_destroyer);
        player1.unitNames.add(UnitName.Tank_destroyer);
        player1.unitNames.add(UnitName.Mirage_tank);
        player1.unitNames.add(UnitName.Mirage_tank);
        player1.unitPositions.add(new UnitPosition(100,100,20));
        player1.unitPositions.add(new UnitPosition(1000,1000,20));
        player1.unitPositions.add(new UnitPosition(3700,3500,3));
        player1.unitPositions.add(new UnitPosition(3700,3300,15));
        player1.unitPositions.add(new UnitPosition(3500,3700,20));
        player1.unitPositions.add(new UnitPosition(3800,3800,20));
        player1.unitPositions.add(new UnitPosition(3800,3400,20));
        player1.unitPositions.add(new UnitPosition(6200,4700,20));
        Player player2= new GUIPlayer();
        player2.coins=0;
        player2.IdPlayer=2;
        player2.Name="Player2";
        player2.unitNames.add(UnitName.Black_Eagle);
        player2.unitNames.add(UnitName.Infantry);
        player2.unitNames.add(UnitName.Grizzly_Tank);
        player2.unitNames.add(UnitName.Prism_tank);
        player2.unitNames.add(UnitName.Navy_SEAL);
        player2.unitNames.add(UnitName.Navy_SEAL);
        player2.unitNames.add(UnitName.Navy_SEAL);
        player2.unitNames.add(UnitName.Navy_SEAL);
        player2.unitPositions.add(new UnitPosition(6200,4200,20));
        player2.unitPositions.add(new UnitPosition(4200,5800,100));
        player2.unitPositions.add(new UnitPosition(3500,6000,3));
        player2.unitPositions.add(new UnitPosition(4200,6000,20));
        player2.unitPositions.add(new UnitPosition(5900,6200,3));
        player2.unitPositions.add(new UnitPosition(6000,6000,20));
        player2.unitPositions.add(new UnitPosition(6300,6000,3));
        player2.unitPositions.add(new UnitPosition(6500,6000,20));

        Player player3= new GUIPlayer();
        player3.coins=0;
        player3.IdPlayer=3;
        player3.Name="Player3";
        player3.unitNames.add(UnitName.Grand_Cannon);
        player3.unitNames.add(UnitName.Pillbox);
        player3.unitNames.add(UnitName.Prism_Tower);
        player3.unitNames.add(UnitName.Patriot_Missile);
        player3.unitNames.add(UnitName.TeslaTank);
        player3.unitPositions.add(new UnitPosition(4500,4500,40));
        player3.unitPositions.add(new UnitPosition(4500,5500,40));
        player3.unitPositions.add(new UnitPosition(5500,5500,0));
        player3.unitPositions.add(new UnitPosition(5500,4500,0));
        player3.unitPositions.add(new UnitPosition(4500,5000,0));
        Player player4= new GUIPlayer();
        player4.coins=0;
        player4.IdPlayer=4;
        player4.Name="Player4";
        player4.unitNames.add(UnitName.Prism_tank);
        player4.unitNames.add(UnitName.Sniper);
        player4.unitNames.add(UnitName.Infantry);
        player4.unitNames.add(UnitName.Grizzly_Tank);
        player4.unitNames.add(UnitName.Tank_destroyer);
        player4.unitPositions.add(new UnitPosition(5000,4500,20));
        player4.unitPositions.add(new UnitPosition(5500,5000,3));
        player4.unitPositions.add(new UnitPosition(5000,5500,3));
        player4.unitPositions.add(new UnitPosition(5000,4300,20));
        player4.unitPositions.add(new UnitPosition(4300,5000,20));
        Team team1=new AttackerTeam();
        team1.players[0]=player1;
        team1.players[1]=player2;
        Team team2=new DefenderTeam();
        team2.players[0]=player3;
        team2.players[1]=player4;
        Team team=null;
        try {
            out.writeObject(team1);
            out.writeObject(team2);
            out.writeObject(team);
        }
        catch (IOException o){}
        finally { out.close();}
    }
    public Team ReadGame(int index) throws IOException{
        new LoadGame().WriteGame();
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("LoadGame.txt"));
        Team team = new AttackerTeam();
        try{
            for (int i=0;i<=index;i++) {
                team = (Team) in.readObject();
                if (team==null) break;
            }
        }
        catch (ClassNotFoundException o){}
        finally { in.close(); }
        return team;
    }
}
