
package project3;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Player implements Serializable {
    int IdPlayer = Team.Idplayer++;
    protected int coins =3000;
    String Name;
    abstract void NewGame() throws IOException;
    abstract void BuyUnit()throws IOException;
    abstract void LoadGame() throws IOException;
    ArrayList<UnitName>  unitNames = new ArrayList<UnitName>();
    ArrayList<UnitPosition> unitPositions = new ArrayList<>();
}