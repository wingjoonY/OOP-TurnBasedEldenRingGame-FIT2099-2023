package game.GameMap;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.Environments.*;
import game.Environments.SpawningGrounds.Graveyard;
import game.Environments.SpawningGrounds.GustOfWind;
import game.Environments.SpawningGrounds.PuddleOfWater;
import game.NonPlayableActor.CastleEnemies.Dog;
import game.NonPlayableActor.Traders.FingerReaderEnia;
import game.NonPlayableActor.Traders.MerchantKale;
import game.PlayableArchetypes.*;
import game.Utils.ArchetypeMenuManager;
import game.Utils.EnemyFactory;
import game.Utils.SiteOfLostGraceManager;

import java.util.Arrays;
import java.util.List;

/**
 * Limgrave map
 * @author : Sam Zachary Chee Hao Yuan
 */
public class Limgrave {

    private static List<String> limgraveMapString = Arrays.asList(
            "......................#.............#..........................+++.........",
            "......................#.............#.......................+++++..........",
            "......................#..___....____#.........................+++++........",
            "......................#...........__#............................++........",
            "......................#_____........#.............................+++......",
            "......................#............_#..............................+++.....",
            "......................######...######......................................",
            "...........................................................................",
            "...........................=...............................................",
            "........++++......................###___###................................",
            "........+++++++...................________#................................",
            "..........+++.....................#________................................",
            "............+++...................#_______#................................",
            ".............+....................###___###................................",
            "............++......................#___#..................................",
            "..............+...................=........................................",
            "..............++.................................................=.........",
            "..............................................++...........................",
            "..................++++......................+++...............######..##...",
            "#####___######....++...........................+++............#....____....",
            "_____________#.....++++..........................+..............__.....#...",
            "_____________#.....+....++........................++.........._.....__.#...",
            "_____________#.........+..+.....................+++...........###..__###...",
            "_____________#.............++..............................................");

    private static FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(),
                                                                            new Cliff(), new SummonSign());

    private static GameMap limgraveMap = new GameMap(groundFactory, limgraveMapString);

    /**
     * Process the map
     * @param world the world
     */
    public static void processMap(World world){
        world.addGameMap(limgraveMap);

        PlayableCharacter playableCharacter = null;
        int choice;
        do {
            choice = ArchetypeMenuManager.menuItem();
            switch (choice) {
                case 1:
                    playableCharacter = new Samurai();
                    break;
                case 2:
                    playableCharacter = new Bandit();
                    break;
                case 3:
                    playableCharacter = new Wretch();
                    break;
                case 4:
                    playableCharacter = new Astrologer();
                    break;
            }
        }while(choice > 4);

        assert playableCharacter != null;
        SiteOfLostGrace theFirstStep = new SiteOfLostGrace(limgraveMap,38, 11,"The First Step");
        playableCharacter.setRespawnPoint(limgraveMap.at(theFirstStep.getTeleportX(), theFirstStep.getTeleportY()));
        EnemyFactory.getInstance().setPlayableCharacter(playableCharacter);
        world.addPlayer(playableCharacter, limgraveMap.at(36, 10));
        limgraveMap.at(40, 12).addActor(new MerchantKale());
        limgraveMap.at(38, 11).setGround(theFirstStep);
        limgraveMap.at(25, 4).setGround(new GoldenFogDoor(RoundTableHold.getRoundTableHoldMap(), 9, 10
                , "Round Table Hold"));
        limgraveMap.at(68, 19).setGround(new GoldenFogDoor(StormveilCastle.getStormveilCastleMap(), 7, 18
                                                                , "Stormveil Castle"));

    }

    /**
     * Get the current map
     * @return a GameMap
     */
    public static GameMap getLimgraveMap() {
        return limgraveMap;
    }
}
