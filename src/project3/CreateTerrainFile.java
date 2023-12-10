
package project3;

import java.io.*;
import java.util.ArrayList;

public class CreateTerrainFile {
    public void Accept() throws IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Terrain.txt"));
        Terrain terrain1 =  new Terrain().createFile(TerrainType.bridge);
        Terrain terrain2 =  new Terrain().createFile(TerrainType.flight_base);
        Terrain terrain3 =  new Terrain().createFile(TerrainType.river);
        Terrain terrain4 =  new Terrain().createFile(TerrainType.valley);
        UnitPosition position = new UnitPosition();
        position.setPosition(0,0,0);
        terrain1.setPosition(position);
        position.setPosition(0,0,0);
        terrain2.setPosition(position);
        position.setPosition(0,0,0);
        terrain3.setPosition(position);
        position.setPosition(0,0,0);
        terrain4.setPosition(position);
        Terrain terrain5 = null;
        try {
            out.writeObject(terrain1);
            out.writeObject(terrain2);
            out.writeObject(terrain3);
            out.writeObject(terrain4);
            out.writeObject(terrain5);
        }
        catch (IOException o){}
        finally { out.close();}
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("Terrain.txt"));
        try{
            while (true){
                terrain1 = (Terrain) in.readObject();
                if(terrain1==null) break;;
            }

        }
        catch (ClassNotFoundException o){}
        finally { in.close(); }
    }
    public void AcceptWrite() throws IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Terrain.txt"));
        Terrain terrain1 =  new Terrain().createFile(TerrainType.bridge);
        Terrain terrain2 =  new Terrain().createFile(TerrainType.flight_base);
        Terrain terrain3 =  new Terrain().createFile(TerrainType.river);
        Terrain terrain4 =  new Terrain().createFile(TerrainType.valley);
        Terrain terrain5 = null;
        try {
            out.writeObject(terrain1);
            out.writeObject(terrain2);
            out.writeObject(terrain3);
            out.writeObject(terrain4);
            out.writeObject(terrain5);
        }
        catch (IOException o){}
        finally { out.close();}
    }
    public void TerrainPositionWrite() throws IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("TerrainPosition.txt"));
        TerrainInform terrainInform1 = new TerrainInform(TerrainType.bridge,1000,1000,100);
        TerrainInform terrainInform2 = new TerrainInform(TerrainType.flight_base,6200,4200,200);
        TerrainInform terrainInform3 = new TerrainInform(TerrainType.river,2500,2500,400);
        TerrainInform terrainInform4 = new TerrainInform(TerrainType.valley,1500,8500,500);
        TerrainInform terrainInform5 = null;
        try {
            out.writeObject(terrainInform1);
            out.writeObject(terrainInform2);
            out.writeObject(terrainInform3);
            out.writeObject(terrainInform4);
            out.writeObject(terrainInform5);
        }
        catch (IOException o){}
        finally { out.close();}
    }
    public Terrain TerrainRead(TerrainType terrainType) throws IOException{
        new CreateTerrainFile().AcceptWrite();
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("Terrain.txt"));
        Terrain terrain = new Terrain();
        try{
            while (true){
                terrain = (Terrain) in.readObject();
                if(terrain==null) break;
                if(terrain.getType()==terrainType) break;
            }
        }
        catch (ClassNotFoundException o){}
        finally { in.close(); }
        return terrain;
    }
    public ArrayList <Terrain> TerrainPositionRead() throws IOException{
        new CreateTerrainFile().TerrainPositionWrite();
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("TerrainPosition.txt"));
        TerrainInform terrainInform= new TerrainInform();
        Terrain terrain = new Terrain();
        ArrayList <Terrain> terrains = new ArrayList<>();
        try{
            while (true){
               terrainInform = (TerrainInform) in.readObject();
                if(terrainInform==null) break;
                terrain = TerrainRead(terrainInform.getTerrainType());
                terrain.setPosition(terrainInform.getUnitPosition());
                terrains.add(terrain);
            }
        }
        catch (ClassNotFoundException o){}
        finally { in.close(); }
        return terrains;
    }
}