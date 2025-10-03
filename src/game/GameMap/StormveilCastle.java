package game.GameMap;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.Environments.*;
import game.Environments.SpawningGrounds.*;

import java.util.Arrays;
import java.util.List;

/**
 * StormveilCastle map
 * @author : Sam Zachary Chee Hao Yuan
 */
public class StormveilCastle {

    private static List<String> stormveilCastleMapString = Arrays.asList(
            "...........................................................................",
            "..................<...............<........................................",
            "...........................................................................",
            "##############################################...##########################",
            "............................#................#.......B..............B......",
            ".....B...............B......#................#.............................",
            "...............................<.........<.................................",
            ".....B...............B......#................#.......B..............B......",
            "............................#................#.............................",
            "#####################..#############...############.####..#########...#####",
            "...............#++++++++++++#................#++++++++++++#................",
            "...............#++++++++++++...<.........<...#++++++++++++#................",
            "...............#++++++++++++..................++++++++++++#................",
            "...............#++++++++++++#................#++++++++++++#................",
            "#####...##########.....#############...#############..#############...#####",
            ".._______........................B......B........................B.....B...",
            "_____..._..____....&&........<..............<..............................",
            ".........____......&&......................................................",
            "...._______..................<..............<....................<.....<...",
            "#####....##...###..#####...##########___###############......##.....####...",
            "+++++++++++++++++++++++++++#...................#+++++++++++++++++++++++++++",
            "+++++++++++++++++++++++++++....................#+++++++++++++++++++++++++++",
            "+++++++++++++++++++++++++++#....................+++++++++++++++++++++++++++",
            "+++++++++++++++++++++++++++#...................#+++++++++++++++++++++++++++");

    private static FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(),
            new GustOfWind(), new Barrack(), new Cage(), new Cliff());

    private static GameMap stormveilCastleMap = new GameMap(groundFactory, stormveilCastleMapString);

    /**
     * Process the map
     * @param world the game world
     */
    public static void processMap(World world){
        world.addGameMap(stormveilCastleMap);
        SiteOfLostGrace stormveilMainGate = new SiteOfLostGrace(stormveilCastleMap,38,19,"Stormveil Main Gate");
        stormveilCastleMap.at(38, 19).setGround(stormveilMainGate);
        stormveilCastleMap.at(7, 18).setGround(new GoldenFogDoor(Limgrave.getLimgraveMap(), 68, 19, "Limgrave"));
        stormveilCastleMap.at(60, 1).setGround(new GoldenFogDoor(BossRoom.getBossRoomMap(), 2, 4, "Boss Room"));
    }

    /**
     * Get the current map
     * @return a GameMap
     */
    public static GameMap getStormveilCastleMap(){
        return stormveilCastleMap;
    }
}
