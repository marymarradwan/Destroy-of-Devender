
package project3;

import java.io.Serializable;
import java.util.ArrayList;


public abstract class UnitAttack implements Serializable{
    public abstract boolean PerformAttack(ArrayList<Unit> unitArrayList);
}
