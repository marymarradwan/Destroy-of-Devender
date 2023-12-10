
package project3;

import java.io.IOException;
import java.io.Serializable;


public class DefenderTeam extends Team implements Serializable {
    public DefenderTeam() throws IOException{
        teamId=1;
        teamPlayer=TeamPlayer.Defender;
        for (int i=0;i<PlayerNumber;i++)
            players[i]=new GUIPlayer();
        teamUnitsInitializationPositions=new CreateTeamFile().DefenderPositionRead();
    }
}