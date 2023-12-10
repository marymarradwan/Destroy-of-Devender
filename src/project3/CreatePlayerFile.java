package project3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CreatePlayerFile  implements Serializable{
    private void PlayerWrite() throws IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ConsolePlayer.txt"));
        Player player1= new ConsolePlayer();
        player1.coins=0;
        player1.IdPlayer=1;
        player1.Name="Player1";
        player1.unitNames.add(UnitName.Prism_tank);
        try {
            out.writeObject(player1);
        }
        catch (IOException o){}
        finally { out.close();}
    }
    private void GuiPlayerWrite() throws IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("GuiPlayer.txt"));
        Player player2= new GUIPlayer();
        player2.coins=0;
        player2.IdPlayer=1;
        player2.Name="Player1";
        player2.unitNames.add(UnitName.Prism_tank);
        try {
            out.writeObject(player2);
        }
        catch (IOException o){}
        finally { out.close();}
    }
}
