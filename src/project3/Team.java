
package project3;

import java.io.Serializable;
import java.util.ArrayList;


public abstract class Team implements Serializable {
    static int Idplayer = 0;
    protected int teamId;
    static protected int PlayerNumber = 2;
    protected TeamPlayer teamPlayer;
    protected Player players[] = new Player[PlayerNumber];
    protected ArrayList<UnitPosition> teamUnitsInitializationPositions = new ArrayList<UnitPosition>();
}