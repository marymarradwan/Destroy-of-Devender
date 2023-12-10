
package project3;

import java.io.IOException;
import java.io.Serializable;

public class GUIPlayer extends Player implements Serializable {

    @Override
    void NewGame() {
        String name = "player"+(char)IdPlayer;
    }
    @Override
    void BuyUnit() {
        for (int i=0;i<10;i++)
            unitNames.add(UnitName.Prism_tank);
        //من الملف
    }

    @Override
    void LoadGame() throws IOException {

    }
}