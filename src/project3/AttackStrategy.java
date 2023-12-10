
package project3;

import java.util.ArrayList;

public interface AttackStrategy  {
  public Unit PrioritizeUnitToAttack(ArrayList<Unit> Units);
}