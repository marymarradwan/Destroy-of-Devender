
package project3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Terrain implements Serializable {
    private  TerrainType terrainType;
    private UnitPosition position;
    private  int health;
    boolean Allow;
    ArrayList<UnitType> unitTypesAllow = new ArrayList<UnitType>();
    double Slowly;
    ArrayList<UnitType> unitTypesSlowly = new ArrayList<UnitType>();
    public Terrain(){}
    public Terrain(TerrainType type){
        this.terrainType=type;

    }
    public void setType(TerrainType type) {
        this.terrainType = type;
    }
    public void setPosition(UnitPosition position) {
        this.position = position;
    }
    public int getHealth() {
        return health;
    }
    boolean Check_Allow(Unit unit){
        if(Allow&&health!=0) return true;
        for (UnitType element : unitTypesAllow)
            if(unit.getUnitType()==element)
                return true;
        return false;
    }
    boolean Check_Slowly(UnitType unitType){
        for (UnitType element : unitTypesSlowly)
            if(unitType==element)
                return true;
        return false;
    }
    boolean CheckUnit(UnitPosition position){
        if((Math.abs(position.getCenterX()-this.position.getCenterX())<= position.getRadius()+this.position.getRadius())
                &&Math.abs(position.getCenterY()-this.position.getCenterY())<=position.getRadius()+this.position.getRadius())
            return true;
        return false;
    }
    public double Slow (Unit unit){
        if(CheckUnit(unit.getPosition())&&Check_Slowly(unit.getUnitType()))
            return Slowly;
        return 1;

    }
    public TerrainType getType() {
        return terrainType;
    }
    public UnitPosition getPosition() {
        return position;
    }
    public Terrain createFile(TerrainType terrainType){
        this.terrainType=terrainType;
        //this.position.setPosition(unitPosition);
        if(terrainType==TerrainType.bridge){
            health=10000;
            Allow=true;
            Slowly=1;
        }
        else if(terrainType==TerrainType.river){
            health=-1;
            Allow=true;
            Slowly=2;
            unitTypesSlowly.add(UnitType.Solider);
            unitTypesSlowly.add(UnitType.Tank);
        }
        else if(terrainType==TerrainType.valley){
            health=-1;
            Allow=false;
            Slowly=1;
            unitTypesAllow.add(UnitType.Airplane);
        }
        else if(terrainType==TerrainType.flight_base){
            health=1000;
            Allow=false;
            Slowly=1;
            unitTypesAllow.add(UnitType.Airplane);
        }
        return this;
    }
    public Terrain CreateTerrain(TerrainType terrainType) throws IOException{
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
}