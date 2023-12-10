
package project3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class RandomAttackStrategy implements AttackStrategy,Serializable{
    public Unit PrioritizeUnitToAttack(ArrayList<Unit> Units){
        if (Units.size()==0)
            return null;
        Random random = new Random();
        return Units.get(random.nextInt(Units.size()));
    }
}