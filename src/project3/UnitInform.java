
package project3;

import java.io.Serializable;


public class UnitInform implements Serializable{
    private UnitType unitType;
    private UnitPosition unitPosition;
    public UnitType getUnitType() {
        return unitType;
    }
    public UnitPosition getUnitPosition() {
        return unitPosition;
    }
    public UnitInform(){}
    public UnitInform(UnitType unitType,int x,int y,int r){
        this.unitType=unitType;
        unitPosition=new UnitPosition(x,y,r);
    }
}