
package project3;

import java.io.Serializable;
import java.util.ArrayList;

public class LowestHealthAttackStrategy implements AttackStrategy,Serializable{
    public Unit PrioritizeUnitToAttack(ArrayList<Unit> Units){
        Unit LowestHealthUnit = Units.get(0);
        for (Unit element : Units)
            if(LowestHealthUnit.getATK() > element.getATK())
                LowestHealthUnit = element;
        return LowestHealthUnit;
    }
}