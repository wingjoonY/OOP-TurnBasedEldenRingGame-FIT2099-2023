package game.GameMap;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.Environments.*;

import java.util.Arrays;
import java.util.List;

/**
 * BossRoom map
 * @author : Sam Zachary Chee Hao Yuan
 */
public class BossRoom {

    private static List<String> bossRoomMapString = Arrays.asList(
        "+++++++++++++++++++++++++",
        ".........................",
        "..=......................",
        ".........................",
        ".._......................",
        ".........................",
        ".........................",
        ".........................",
        "+++++++++++++++++++++++++");

    private static FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Cliff(), new Floor(), new SummonSign());

    private static GameMap bossRoomMap = new GameMap(groundFactory, bossRoomMapString);

    /**
     * Process the map
     * @param world the world
     */
    public static void processMap(World world){
        world.addGameMap(bossRoomMap);
    }

    /**
     * Get the current map
     * @return a GameMap
     */
    public static GameMap getBossRoomMap() {
        return bossRoomMap;
    }
}
