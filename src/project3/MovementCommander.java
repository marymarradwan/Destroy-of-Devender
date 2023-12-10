
package project3;


public class MovementCommander extends Commander{
    public void command(){
        Unit unit = DoDGameManager.Units.get(index1);
        if(unit.getHealth()<=0)
            DoDGameManager.Printarray.add("A Unite " + index1 + " is  Destroying ," + index1 + " can't movement .");
        else{
            UnitPosition position1 = new UnitPosition(x,y,unit.getPosition().getRadius());
            UnitPosition position2 = new UnitPosition();
            position2.setPosition(unit.getPosition());
            unit.setPosition(position1);
            if(!unit.getPosition().SquareIsOccupied());
            else if(!unit.getPosition().SquareIsOccupiedTerrains(unit));
            else{
                DoDGameManager.Printarray.add("A Unite " + index1 + " movement to " + x + " " + y);
                DoDGameManager.Units.get(index1).setPosition(unit.getPosition());
                if(unit.getPositionLoad().CheckPosition(unit.getPosition()))
                    unit.setCanAttack(true);
            }

        }
    }
}
