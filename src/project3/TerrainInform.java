
package project3;

import java.io.Serializable;

public class TerrainInform implements Serializable{
    private TerrainType terrainType;
    private UnitPosition unitPosition;
    public TerrainType getTerrainType() {
        return terrainType;
    }
    public UnitPosition getUnitPosition() {
        return unitPosition;
    }
    public TerrainInform(){}
    public TerrainInform(TerrainType terrainType,int x,int y,int r){
        this.terrainType = terrainType;
        unitPosition=new UnitPosition(x,y,r);
    }
}