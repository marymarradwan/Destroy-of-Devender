
package project3;

import java.io.*;
import java.util.ArrayList;

public class CreateTeamFile implements Serializable {
    private void AttackerPositionWrite() throws IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("AttackerPosition.txt"));
        UnitPosition unitPosition1 = new UnitPosition(10,10,10);
        UnitPosition unitPosition2 = new UnitPosition(90,90,10);
        UnitPosition unitPosition3 = new UnitPosition(90,10,10);
        UnitPosition unitPosition4 = new UnitPosition(10,90,10);
        UnitPosition unitPosition5 = null;
        try {
            out.writeObject(unitPosition1);
            out.writeObject(unitPosition2);
            out.writeObject(unitPosition3);
            out.writeObject(unitPosition4);
            out.writeObject(unitPosition5);
        }
        catch (IOException o){}
        finally { out.close();}
    }
    public ArrayList<UnitPosition> AttackerPositionRead() throws IOException{
        AttackerPositionWrite();
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("AttackerPosition.txt"));
        ArrayList<UnitPosition> unitPositions = new ArrayList<>();
        UnitPosition unitPosition = new UnitPosition();
        try{
            while (true){
                unitPosition = (UnitPosition) in.readObject();
                if(unitPosition==null) break;;
                unitPositions.add(unitPosition);
            }
        }
        catch (ClassNotFoundException o){}
        finally { in.close(); }
        return unitPositions;
    }
    private void DefenderPositionWrite() throws IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("DefenderPosition.txt"));
        UnitPosition unitPosition1 = new UnitPosition(30,40,10);
        UnitPosition unitPosition2 = new UnitPosition(40,30,10);
        UnitPosition unitPosition3 = new UnitPosition(60,70,10);
        UnitPosition unitPosition4 = new UnitPosition(70,60,10);
        UnitPosition unitPosition5 = null;
        try {
            out.writeObject(unitPosition1);
            out.writeObject(unitPosition2);
            out.writeObject(unitPosition3);
            out.writeObject(unitPosition4);
            out.writeObject(unitPosition5);
        }
        catch (IOException o){}
        finally { out.close();}
    }
    public ArrayList<UnitPosition> DefenderPositionRead() throws IOException{
        DefenderPositionWrite();
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("DefenderPosition.txt"));
        ArrayList<UnitPosition> unitPositions = new ArrayList<>();
        UnitPosition unitPosition = new UnitPosition();
        try{
            while (true){
                unitPosition = (UnitPosition) in.readObject();
                if(unitPosition==null) break;;
                unitPositions.add(unitPosition);
            }
        }
        catch (ClassNotFoundException o){}
        finally { in.close(); }
        return unitPositions;
    }
}