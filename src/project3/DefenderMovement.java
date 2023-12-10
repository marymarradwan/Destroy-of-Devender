
package project3;


public class DefenderMovement extends Movement{
    SideMovement sideMovement = null;
    public void move(Unit unit){
        if(unit.getUnitType()==UnitType.Structure) return;
        if(sideMovement==SideMovement.Left) Left(unit);
        else Right(unit);
    }
    public void Right(Unit unit){
        if(sideMovement==null)
            sideMovement=SideMovement.Right;
        int x1=unit.getPositionNext().getCenterX();
        int y1=unit.getPositionNext().getCenterY();
        int x2=DoDGameManager.MainBase.getPosition().getCenterX();
        int y2=DoDGameManager.MainBase.getPosition().getCenterY();
        int r=Math.abs(x1-x2);
        if(r<Math.abs(y1-y2))
            r=Math.abs(y1-y2);
        if((Math.abs(x1+1-x2)<=r) && (y1-y2==r*(-1))) x1++;
        else if((Math.abs(y1+1-y2)<=r) && (x1-x2==r)) y1++;
        else if((Math.abs(y1-1-y2)<=r) && (x1-x2==r*(-1))) y1--;
        else if((Math.abs(x1-1-x2)<=r) && (y1-y2==r)) x1--;
        UnitPosition p = new UnitPosition(unit.getPosition().getCenterX(),unit.getPosition().getCenterY(),unit.getPosition().getRadius());
        unit.getPosition().setPosition(x1,y1,unit.getPosition().getRadius());
        if(!unit.getPosition().SquareIsOccupied()){
            unit.getPosition().setPosition(p.getCenterX(),p.getCenterY(),p.getRadius());
            if(sideMovement!=SideMovement.Left)
                Left(unit);
        }
        else if(!unit.getPosition().SquareIsOccupiedTerrains(unit)){
            unit.getPosition().setPosition(p.getCenterX(),p.getCenterY(),p.getRadius());
            if(sideMovement!=SideMovement.Left)
                Left(unit);
        }
        else {
            Commander commander = new MovementCommander();
            commander.index1=unit.getIndex();
            commander.x=x1;
            commander.y=y1;
            DoDGameManager.Commanders.add(commander);
            unit.getPosition().setPosition(p.getCenterX(),p.getCenterY(),p.getRadius());
            DoDGameManager.Units.get(unit.getIndex()).getPositionNext().setPosition(x1, y1, p.getRadius());
            sideMovement=SideMovement.Right;
        }

    }
    public void Left(Unit unit){
        if(sideMovement==null)
            sideMovement=SideMovement.Left;
        int x1=unit.getPosition().getCenterX();
        int y1=unit.getPosition().getCenterY();
        int x2=DoDGameManager.MainBase.getPosition().getCenterX();
        int y2=DoDGameManager.MainBase.getPosition().getCenterY();
        int r=Math.abs(x1-x2);
        if(r<Math.abs(y1-y2))
            r=Math.abs(y1-y2);
        if((Math.abs(x1-1-x2)<=r) && (y1-y2==r*(-1))) x1--;
        else if((Math.abs(y1-1-y2)<=r) && (x1-x2==r)) y1--;
        else if((Math.abs(y1+1-y2)<=r) && (x1-x2==r*(-1))) y1++;
        else if((Math.abs(x1+1-x2)<=r) && (y1-y2==r)) x1++;
        UnitPosition p = new UnitPosition(unit.getPosition().getCenterX(),unit.getPosition().getCenterY(),unit.getPosition().getRadius());
        unit.getPosition().setPosition(x1,y1,unit.getPosition().getRadius());
        if(!unit.getPosition().SquareIsOccupied()){
            unit.getPosition().setPosition(p.getCenterX(),p.getCenterY(),p.getRadius());
            if(sideMovement!=SideMovement.Right)
                Right(unit);
        }
        else if(!unit.getPosition().SquareIsOccupiedTerrains(unit)){
            unit.getPosition().setPosition(p.getCenterX(),p.getCenterY(),p.getRadius());
            if(sideMovement!=SideMovement.Right)
                Right(unit);
        }
        else {
            Commander commander = new MovementCommander();
            commander.index1=unit.getIndex();
            commander.x=x1;
            commander.y=y1;
            DoDGameManager.Commanders.add(commander);
            DoDGameManager.Units.get(unit.getIndex()).getPositionNext().setPosition(x1, y1, p.getRadius());
            sideMovement=SideMovement.Left;
        }
    }
}