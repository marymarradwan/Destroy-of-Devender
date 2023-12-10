
package project3;

public class AttackerMovement extends Movement{
    public void move(Unit unit){
        int x=unit.getPositionNext().getCenterX();
        int y=unit.getPositionNext().getCenterY();
        int r=unit.getPosition().getRadius();
        UnitPosition p = new UnitPosition(x,y,r);
        int Xbase,Ybase;
        if(unit.isCanAttack()) {
            Xbase= DoDGameManager.MainBase.getPosition().getCenterX();
            Ybase=DoDGameManager.MainBase.getPosition().getCenterY();
        }
        else {
            Xbase=unit.getPositionLoad().getCenterX();
            Ybase=unit.getPositionLoad().getCenterY();
        }
        if(x<Xbase) x+= 1;
        else if(x>Xbase) x -= 1;
        if(y<Ybase) y += 1;
        else if(y>Ybase) y -= 1;
        unit.getPosition().setPosition(x,y,r);
        if((!unit.getPosition().SquareIsOccupied()&&unit.getUnitName()!=UnitName.Black_Eagle)
                ||(x==DoDGameManager.MainBase.getPosition().getCenterX()&&y==DoDGameManager.MainBase.getPosition().getCenterY())
                ||!unit.getPosition().SquareIsOccupiedTerrains(unit));
        else {
            Commander commander = new MovementCommander();
            commander.index1=unit.getIndex();
            commander.x=x;
            commander.y=y;
            DoDGameManager.Commanders.add(commander);
            DoDGameManager.Units.get(unit.getIndex()).getPositionNext().setPosition(x, y, r);
        }
        unit.getPosition().setPosition(p.getCenterX(),p.getCenterY(),p.getRadius());

    }
}