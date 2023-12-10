
package project3;

import java.io.Serializable;
import java.util.ArrayList;

public class HighestDamageAttackStrategy implements AttackStrategy,Serializable {
    public Unit PrioritizeUnitToAttack(ArrayList<Unit> Units){
        Unit HighestDamageUnit = Units.get(0);
        for (Unit element : Units)
            if(HighestDamageUnit.getATK() < element.getATK())
                HighestDamageUnit = element;
        return HighestDamageUnit;
    }
}