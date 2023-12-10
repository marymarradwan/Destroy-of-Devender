
package project3;

import java.io.Serializable;

public class
UnitPosition implements Serializable{
    private int centerX;
    private int centerY;
    private int radius;
    public void setCenterX(int centerX){this.centerX=centerX;}
    public void setCenterY(int centerY){this.centerY=centerY;}
    public void setRadius(int radius) {
        this.radius = radius;
    }
    public int getCenterX() {
        return centerX;
    }
    public int getCenterY() {
        return centerY;
    }
    public int getRadius() {
        return radius;
    }
    public void setPosition(int x,int y,int r){
        this.centerX=x;
        this.centerY=y;
        this.radius=r;
    }
    public void setPosition(UnitPosition unitPosition){
        setPosition(unitPosition.getCenterX(), unitPosition.getCenterY(), unitPosition.getRadius());
    }
    public boolean CheckPosition(UnitPosition unitposition) {
        if(this.centerY==unitposition.getCenterY()&&this.centerX==unitposition.getCenterX())
            return true;
        return false;
    }
    public UnitPosition(){}
    public UnitPosition(int x,int y,int r){
        this.centerX=x;
        this.centerY=y;
        this.radius=r;
    }
    public boolean SquareIsOccupied(){
        if(centerX-radius<0 || centerX+radius>=DoDGameManager.size) return false;//delet
        if(centerY-radius<0 || centerY+radius>=DoDGameManager.size) return false;//delete
        for (Unit element : DoDGameManager.Units){
            int x=element.getPosition().getCenterX();
            int y=element.getPosition().getCenterY();
            int r=element.getPosition().getRadius();
            if (element.getHealth()<=0);
            else if(element.getUnitName()==UnitName.Black_Eagle);
            else if(x==centerX&&y==centerY&&r==radius);
            else if(Math.abs(y-centerY)<=radius+r && Math.abs(x-centerX)<=radius+r) return false;
        }
        return true;
    }
    public boolean SquareIsOccupiedTerrains(Unit unit){
        if(centerX-radius<0 || centerX+radius>=DoDGameManager.size) return false;
        if( centerY-radius<0 || centerY+radius>=DoDGameManager.size) return false;
        for (Terrain element : DoDGameManager.Terrains){
            int x=element.getPosition().getCenterX();
            int y=element.getPosition().getCenterY();
            int r=element.getPosition().getRadius();
            if(x==centerX&&y==centerY&&r==radius&& element.Check_Allow(unit));
            else if(Math.abs(y-centerY)<=radius+r && Math.abs(x-centerX)<=radius+r&&!element.Check_Allow(unit)) return false;
        }
        return true;
    }
}