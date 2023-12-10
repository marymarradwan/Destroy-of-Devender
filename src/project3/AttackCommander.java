
package project3;

 
public class AttackCommander extends Commander{
    public void command(){
        if(DoDGameManager.Units.get(index2).getHealth()<=0)
            DoDGameManager.Printarray.add("A Unit " + index2 + "is  Destroying ," + index1 + "can't attack .");
        else {
            DoDGameManager.Printarray.add("A Unit " + index1 + " Attacker " + index2 + " By Damage " + DoDGameManager.Units.get(index1).getATK());
            if(DoDGameManager.Units.get(index2).AcceptDamage(DoDGameManager.Units.get(index1).getATK())){
                DoDGameManager.Units.get(index1).IncDestroyUnit();
                DoDGameManager.Printarray.add("A Unit " + index1 + " has Destroying " + index2);
            }
            DoDGameManager.Units.get(index1).setLastTimeAttack(DoDGameManager.time);
        }

    }
}