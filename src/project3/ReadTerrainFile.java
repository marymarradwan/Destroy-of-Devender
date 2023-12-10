package project3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadTerrainFile {
    public Terrain AcceptRead(TerrainType terrainType) throws IOException {
        new CreateTerrainFile().AcceptWrite();
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("Terrain.txt"));
        Terrain terrain = new Terrain();
        try {
            while (true) {
                terrain = (Terrain) in.readObject();
                if (terrain == null || terrain.getType() == terrainType) break;
            }
        } catch (ClassNotFoundException o) {
        } finally {
            in.close();
        }
        return terrain;
    }
}
