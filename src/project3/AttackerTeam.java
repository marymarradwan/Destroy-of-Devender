
package project3;

import java.io.IOException;
import java.io.Serializable;

public class AttackerTeam extends Team implements Serializable {
    public AttackerTeam() throws IOException{
        teamId=0;
        teamPlayer=TeamPlayer.Attacker;
        players[0]=new ConsolePlayer();
        for (int i=1;i<PlayerNumber;i++)
            players[i]=new GUIPlayer();
        teamUnitsInitializationPositions=new CreateTeamFile().AttackerPositionRead();
    }
}