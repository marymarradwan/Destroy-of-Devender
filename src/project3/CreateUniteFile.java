
package project3;

import java.io.*;
import java.util.ArrayList;

public class CreateUniteFile {
    public void Accept() throws IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Unit.txt"));
        Unit unit[] = new Unit[UnitName.values().length+1];
        unit[0] = new Unit().CreateFile(UnitName.MAIN_BASE);
        unit[1] = new Unit().CreateFile(UnitName.Black_Eagle);
        unit[2] = new Unit().CreateFile(UnitName.Grizzly_Tank);
        unit[3] = new Unit().CreateFile(UnitName.Prism_tank);
        unit[4] = new Unit().CreateFile(UnitName.Grand_Cannon);
        unit[5] = new Unit().CreateFile(UnitName.Infantry);
        unit[6] = new Unit().CreateFile(UnitName.Mirage_tank);
        unit[7] = new Unit().CreateFile(UnitName.Navy_SEAL);
        unit[8] = new Unit().CreateFile(UnitName.Patriot_Missile);
        unit[9] = new Unit().CreateFile(UnitName.Pillbox);
        unit[10] = new Unit().CreateFile(UnitName.Prism_Tower);
        unit[11] = new Unit().CreateFile(UnitName.Sniper);
        unit[12] = new Unit().CreateFile(UnitName.Tank_destroyer);
        unit[13] = new Unit().CreateFile(UnitName.TeslaTank);
        unit[14] = null;
        try {
            for (Unit element : unit)
                out.writeObject(element);
        }
        catch (IOException o){}
        finally { out.close();}
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("Unit.txt"));
        try{
            while (true){
                unit[0] = (Unit) in.readObject();
                if(unit[0]==null) break;;
                System.out.println(unit[0].getUnitName());
            }
        }
        catch (ClassNotFoundException o){}
        finally { in.close(); }
    }//delete
    public void AcceptWrite() throws IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Unit.txt"));
        Unit unit[] = new Unit[UnitName.values().length+1];
        unit[0] = new Unit().CreateFile(UnitName.MAIN_BASE);
        unit[1] = new Unit().CreateFile(UnitName.Black_Eagle);
        unit[2] = new Unit().CreateFile(UnitName.Grizzly_Tank);
        unit[3] = new Unit().CreateFile(UnitName.Prism_tank);
        unit[4] = new Unit().CreateFile(UnitName.Grand_Cannon);
        unit[5] = new Unit().CreateFile(UnitName.Infantry);
        unit[6] = new Unit().CreateFile(UnitName.Mirage_tank);
        unit[7] = new Unit().CreateFile(UnitName.Navy_SEAL);
        unit[8] = new Unit().CreateFile(UnitName.Patriot_Missile);
        unit[9] = new Unit().CreateFile(UnitName.Pillbox);
        unit[10] = new Unit().CreateFile(UnitName.Prism_Tower);
        unit[11] = new Unit().CreateFile(UnitName.Sniper);
        unit[12] = new Unit().CreateFile(UnitName.Tank_destroyer);
        unit[13] = new Unit().CreateFile(UnitName.TeslaTank);
        unit[14] = null;
        try {
            for (Unit element : unit)
                out.writeObject(element);
        }
        catch (IOException o){}
        finally { out.close();}
    }
    public ArrayList<UnitInform> TerrainPositionRead() throws IOException{
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("UnitPosition1.txt"));
        ArrayList<UnitInform> unitInforms = new ArrayList<>();
        UnitInform unitInform = new UnitInform();
        try{
            while (true){
                unitInform = (UnitInform) in.readObject();
                if(unitInform==null) break;;
                unitInforms.add(unitInform);
            }
        }
        catch (ClassNotFoundException o){}
        finally { in.close(); }
        return unitInforms;
    }
}