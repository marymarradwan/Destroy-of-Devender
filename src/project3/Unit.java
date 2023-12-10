
package project3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class Unit implements Serializable{
    private int ATK;
    private int Health;
    private int Range;
    private double Armor;
    private int index;
    private int Price;
    private int Level;
    private int MaxLevel;
    private double LastTimeAttack;
    private double SpeedAttack;
    private double SpeedMovement;
    private int DestroyUnit;
    private TeamPlayer teamPlayer;
    private int  PlayerOwner;
    private ArrayList<UnitType> TargetType = new ArrayList<UnitType>();
    private UnitPosition position = new UnitPosition();
    private Unit targetedUnit;
    private UnitType unitType;
    private Movement movement;
    private AttackStrategy attackStrategy;
    private boolean autoLoad;
    private int VirtualShots;
    private int LoadedShots;
    private UnitPosition PositionLoad;
    private UnitAttack unitAttack;
    private UnitPosition PositionNext = new UnitPosition();
    private boolean CanAttack=true;
    private UnitName unitName;

    public Unit(){}
    public Unit(int x, int y, TeamPlayer teamPlayer, int playerOwner, UnitType unitType){
        position.setCenterX(x);
        position.setCenterY(y);
        this.teamPlayer = teamPlayer;
        this.PlayerOwner = playerOwner;
        this.unitType=unitType;
    }
    public Unit generator(int x,int y,TeamPlayer teamPlayer,int playerOwner){
        SpeedMovement/=10;
        position.setCenterX(x);
        position.setCenterY(y);
        PositionNext.setPosition(position);
        this.teamPlayer = teamPlayer;
        this.PlayerOwner = playerOwner;
        attackStrategy = new RandomAttackStrategy();
        this.MaxLevel=2;
        if(teamPlayer==TeamPlayer.Attacker)
            movement = new AttackerMovement();
        else
            movement = new DefenderMovement();
        PositionLoad = new UnitPosition();
       /*if(unitType==UnitType.CarBomb)
            unitAttack=new Attack().new AreaOfDestructionUnitAttack();
        else*/
        unitAttack=new Attack().new NormalUnitAttack();
        return this;
    }

    public TeamPlayer getTeamPlayer() {
        return teamPlayer;
    }
    public UnitPosition getPosition() {
        return position;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public void setPosition(UnitPosition position) {
        this.position =new UnitPosition(position.getCenterX(),position.getCenterY(), position.getRadius());
        this.PositionNext =new UnitPosition(position.getCenterX(),position.getCenterY(), position.getRadius());
    }
    public int getATK() {
        return this.ATK;
    }
    public int getPlayerOwner() {
        return PlayerOwner;
    }
    public UnitType getUnitType() {
        return unitType;
    }
    public int getIndex() {
        return index;
    }
    public int getHealth() {
        return Health;
    }
    public int getPrice() {
        return Price;
    }
    public UnitPosition getPositionNext() {
        return PositionNext;
    }
    public boolean isCanAttack() {
        return CanAttack;
    }
    public UnitPosition getPositionLoad() {
        return PositionLoad;
    }
    public void setCanAttack(boolean CanAttack) {
        this.CanAttack = CanAttack;
    }
    public UnitName getUnitName() {
        return unitName;
    }
    public void setLastTimeAttack(double lastTimeAttack) {
        LastTimeAttack = lastTimeAttack;
    }
    public void setPositionLoad(UnitPosition positionLoad) {
        PositionLoad = positionLoad;
    }

    public boolean upgrade(){
        if(MaxLevel==Level) return false;
        Level++;
        Health -= (Health*0.15);
        SpeedAttack += (SpeedAttack*0.15);
        SpeedMovement +=(SpeedMovement*0.15);
        return true;
    }
    public void IncDestroyUnit(){
        DestroyUnit++;
        if(DestroyUnit%3==0)
            if(upgrade())
               DoDGameManager.Printarray.add("A Unit " + index + "is upgrade ");;
    }
    public boolean AcceptDamage(double damage){
        this.Health -= (damage-(damage*Armor));
        if(Health<=0){
            if(TeamPlayer.Attacker==teamPlayer)
                DoDGameManager.remainingAttackerUnits--;
            Health=0;
            return true;
        }
        return false;
    }
    //ask'''''
    public double slowly(){
        for (Terrain element :DoDGameManager.Terrains){
            if(element.Slow(this)>1)
                return element.Slow(this);
        }
        return 1;
    }
    public class Attack implements Serializable{
        public boolean AttackCommand(){
            return unitAttack.PerformAttack(DoDGameManager.Units);
        }
        private ArrayList<Unit> Check_Unite(ArrayList<Unit> Units){
            ArrayList Unite = new ArrayList();
            int radius=Range+position.getRadius();
            for(Unit element : Units)
                if(element.getHealth()>0)
                    if(Math.abs(element.getPosition().getCenterY()-getPosition().getCenterY())<=radius+element.getPosition().getRadius())
                        if (Math.abs(element.getPosition().getCenterX()-getPosition().getCenterX())<=radius+element.getPosition().getRadius())
                            if(TargetType.contains(element.unitType)&&teamPlayer!=element.getTeamPlayer())
                                Unite.add(element);
            return Unite;
        }
        private ArrayList<Unit> Check_Unite_Range(ArrayList<Unit> Units){
            ArrayList Unite = new ArrayList();
            int radius=Range+position.getRadius();
            for(int i=0;i<Units.size();i++)
                if(Units.get(i).getPosition().getCenterY()-getPosition().getCenterY()<=radius+Units.get(i).getPosition().getRadius())
                    if (Units.get(i).getPosition().getCenterX()-getPosition().getCenterX()<=radius+Units.get(i).getPosition().getRadius())
                        Unite.add(Units.get(i));
            return Unite;
        }
        public class NormalUnitAttack extends UnitAttack{
            public boolean PerformAttack(ArrayList<Unit> unitArrayList){
                if (DoDGameManager.time-LastTimeAttack<SpeedAttack) return false;
                ArrayList<Unit> TargetUnit = Check_Unite(unitArrayList);
                if(TargetUnit.size()==0) return false;
                Commander commander = new AttackCommander();
                commander.index1=index;
                commander.index2= attackStrategy.PrioritizeUnitToAttack(TargetUnit).getIndex();
                DoDGameManager.Commanders.add(commander);
                if(unitName==UnitName.Black_Eagle)
                    CanAttack=false;
                return true;
            }
        }
        public class AreaOfDestructionUnitAttack extends UnitAttack{
            public boolean PerformAttack(ArrayList<Unit> unitArrayList){
                ArrayList<Unit> TargetUnit = Check_Unite_Range(unitArrayList);
                if(TargetUnit.size()==0) return false;
                Commander commander = new AttackCommander();
                commander.index1=index;
                for (Unit element : TargetUnit){
                    commander.index2= element.getIndex();
                    DoDGameManager.Commanders.add(commander);
                }
                return true;
            }
        }
    }
    public void Strategy(){
        if(this.Health<=0||index==0){
            return;
        }
        if (!new Attack().AttackCommand()){
            for (int i=0;i<SpeedMovement/slowly();i++)
                movement.move(this);
        }
    }
    public Unit CreateFile(UnitName unitName){
        attackStrategy=new RandomAttackStrategy();
        Attack attack = new Attack();
        unitAttack = attack.new NormalUnitAttack();
        this.unitName=unitName;
        autoLoad=true;
        Level=0;
        DestroyUnit=0;
        if(unitName==UnitName.TeslaTank){
            ATK=300;
            Health=1000;
            Armor=0.50;
            Range=250;
            Price=50;
            MaxLevel=2;
            SpeedAttack=0.60;
            SpeedMovement=30;
            TargetType.add(UnitType.Solider);
            TargetType.add(UnitType.Tank);
            VirtualShots=-1;
            LoadedShots=-1;
            position.setRadius(20);
            unitType=UnitType.Tank;

        }
        else if(unitName==UnitName.Sniper){
            ATK=75;
            Health=250;
            Armor=0.10;
            Range=700;
            Price=5;
            MaxLevel=2;
            SpeedAttack=0.4;
            SpeedMovement=10;
            TargetType.add(UnitType.Solider);
            VirtualShots=-1;
            LoadedShots=-1;
            position.setRadius(3);
            unitType=UnitType.Solider;
        }
        else if(unitName==UnitName.Mirage_tank){
            ATK=1000;
            Health=750;
            Armor=0.10;
            Range=10;
            Price=70;
            MaxLevel=2;
            SpeedAttack=1;
            SpeedMovement=60;
            TargetType.add(UnitType.Tank);
            TargetType.add(UnitType.Solider);
            TargetType.add(UnitType.Structure);
            VirtualShots=-1;
            LoadedShots=-1;
            position.setRadius(15);
            unitType=UnitType.Tank;
        }
        else if(unitName==UnitName.Infantry){
            ATK=50;
            Health=250;
            Armor=0.20;
            Range=50;
            Price=3;
            MaxLevel=2;
            SpeedAttack=1.5;
            SpeedMovement=10;
            TargetType.add(UnitType.Solider);
            VirtualShots=-1;
            LoadedShots=-1;
            position.setRadius(3);
            unitType=UnitType.Solider;
        }
        else if(unitName==UnitName.Grizzly_Tank){
            ATK=250;
            Health=1000;
            Armor=0.40;
            Range=250;
            Price=50;
            MaxLevel=2;
            SpeedAttack=0.60;
            SpeedMovement=30;

            TargetType.add(UnitType.Tank);
            TargetType.add(UnitType.Solider);
            TargetType.add(UnitType.Structure);
            VirtualShots=-1;
            LoadedShots=-1;
            position.setRadius(20);
            unitType=UnitType.Solider;
        }
        else if(unitName==UnitName.Navy_SEAL){
            ATK=60;
            Health=400;
            Armor=0.20;
            Range=50;
            Price=10;
            MaxLevel=2;
            SpeedAttack=2;
            SpeedMovement=20;
            TargetType.add(UnitType.Tank);
            TargetType.add(UnitType.Solider);
            VirtualShots=-1;
            LoadedShots=-1;
            position.setRadius(3);
            unitType=UnitType.Solider;
        }
        else if(unitName==UnitName.Tank_destroyer){
            ATK=400;
            Health=1000;
            Armor=0.50;
            Range=150;
            Price=50;
            MaxLevel=2;
            SpeedAttack=0.60;
            SpeedMovement=20;
            TargetType.add(UnitType.Tank);
            VirtualShots=-1;
            LoadedShots=-1;
            position.setRadius(20);
            unitType=UnitType.Tank;
        }
        else if(unitName==UnitName.Prism_tank){
            ATK=300;
            Health=1000;
            Armor=0.35;
            Range=150;
            Price=60;
            MaxLevel=2;
            SpeedAttack=0.60;
            SpeedMovement=20;
            TargetType.add(UnitType.Tank);
            TargetType.add(UnitType.Solider);
            TargetType.add(UnitType.Structure);
            VirtualShots=-1;
            LoadedShots=-1;
            position.setRadius(20);
            unitAttack= attack.new AreaOfDestructionUnitAttack();
            unitType=UnitType.Tank;
        }
        else if(unitName==UnitName.Pillbox){
            ATK=100;
            Health=4000;
            Armor=0.70;
            Range=200;
            Price=150;
            MaxLevel=2;
            SpeedAttack=0.70;
            SpeedMovement=0;
            TargetType.add(UnitType.Solider);
            VirtualShots=-1;
            LoadedShots=-1;
            position.setRadius(40);
            unitType=UnitType.Structure;
        }
        else if(unitName==UnitName.Prism_Tower){
            ATK=100;
            Health=4000;
            Armor=0.70;
            Range=200;
            Price=150;
            MaxLevel=2;
            SpeedAttack=0.50;
            SpeedMovement=0;
            TargetType.add(UnitType.Tank);
            TargetType.add(UnitType.Solider);
            VirtualShots=3;
            LoadedShots=3;
            position.setRadius(30);
            unitType=UnitType.Structure;
        }
        else if(unitName==UnitName.Grand_Cannon){
            ATK=150;
            Health=6500;
            Armor=0.30;
            Range=400;
            Price=200;
            MaxLevel=2;
            SpeedAttack=0.90;
            SpeedMovement=0;
            TargetType.add(UnitType.Tank);
            TargetType.add(UnitType.Solider);
            VirtualShots=3;
            LoadedShots=3;
            position.setRadius(40);
            unitType=UnitType.Structure;
        }
        else if(unitName==UnitName.MAIN_BASE){
            ATK=0;
            Health=10000;
            Armor=0.00;
            Range=0;
            // Price=200;
            MaxLevel=2;
            SpeedAttack=0.00;
            SpeedMovement=0;
            VirtualShots=3;
            LoadedShots=3;
            position.setRadius(50);
            unitType=UnitType.Structure;
        }
        else if(unitName==UnitName.Black_Eagle){
            ATK=400;
            Health=1500;
            Armor=0.00;
            Range=30;
            Price=75;
            MaxLevel=2;
            // SpeedAttack=0.00;
            SpeedMovement=100;
            TargetType.add(UnitType.MAIN_BASE);
            autoLoad=false;
            VirtualShots=3;
            LoadedShots=3;
            // position.setRadius(50);
            unitType=UnitType.Airplane;
        }
        else if(unitName==UnitName.Patriot_Missile){
            ATK=50;
            Health=2500;
            Armor=0.20;
            Range=400;
            Price=175;
            MaxLevel=2;
            SpeedAttack=0.90;
            SpeedMovement=0;
            TargetType.add(UnitType.Airplane);
            VirtualShots=3;
            LoadedShots=3;
            position.setRadius(40);
            unitType=UnitType.Structure;
        }
        return this;
    }
    public Unit CreateUnite(UnitName unitName) throws IOException{
        new CreateUniteFile().AcceptWrite();
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("Unit.txt"));
        Unit unit = new Unit();
        try{
            while (true){
                unit = (Unit) in.readObject();
                if(unit==null) break;
                if(unit.getUnitName()==unitName) break;
            }
        }
        catch (ClassNotFoundException o){}
        finally { in.close(); }
        return unit;
    }
    public void print(){
        System.out.println("=============================");
        System.out.println("Unite type : " + unitType);
        System.out.println("Atk : " + ATK);
        System.out.println("Health : " + Health);
        System.out.println("Index : " + index);
        System.out.println("Range : " + Range);
        System.out.println("Armor : " + Armor);
        System.out.println("position : "+ position.getCenterX() + " " + position.getCenterY() + " " + position.getRadius());
        System.out.println("price : " + Price);
        System.out.println("Team player : " + teamPlayer);
        System.out.println("Target type : " + TargetType);
        System.out.println("speed attack : " + SpeedAttack);
        System.out.println("speed movement : " + SpeedMovement);
        System.out.println("id : " + this.PlayerOwner);
        System.out.println("==============================");
    }
}
