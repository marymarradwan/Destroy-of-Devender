
package project3;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class ConsolePlayer extends Player implements Serializable {

    @Override
    void NewGame()throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name : ");
        String name = sc.next();
        BuyUnit();
    }
    @Override
    void BuyUnit() throws IOException {
        Scanner sc = new Scanner(System.in);
        Unit unit=new Unit();
        boolean stop = true;
        do {
            System.out.println("Enter The UnitType (0-exit 1-tesla 2-TeslaTank 3-Sniper 4-Gun 5-A 6-P 7-D 8-RBG )");
            int x=sc.nextInt();
            switch (x) {
                case 0:
                    stop=false;
                    break;
                case 1:
                    System.out.println("This Type Of Unit Is TeslaTank");
                    unit=new Unit().CreateUnite(UnitName.Prism_tank);
                    break;
                case 2:
                    System.out.println("This Type Of Unit Is ");
                    unit=new Unit().CreateUnite(UnitName.Sniper);
                    break;
                default:
                    break;
            }
            if(x!=0){
                if ( coins> unit.getPrice()) {
                    coins = coins - unit.getPrice();
                    unitNames.add(unit.getUnitName());
                } else {
                    System.out.println("There are not enough points");
                }
            }
        } while (coins > 0 && stop);
    }
    @Override
    void LoadGame() throws IOException {

    }
}
