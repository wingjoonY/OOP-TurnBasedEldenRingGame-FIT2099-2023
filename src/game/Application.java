package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.PlayableArchetypes.*;
import game.Environments.*;
import game.Environments.SpawningGrounds.Graveyard;
import game.Environments.SpawningGrounds.GustOfWind;
import game.Environments.SpawningGrounds.PuddleOfWater;
import game.NonPlayableActor.Traders.MerchantKale;
import game.Utils.ArchetypeMenuManager;
import game.Utils.EnemyFactory;
import game.Utils.FancyMessage;
import game.Utils.MapManager;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Application {

	public static void main(String[] args) {

		// BEHOLD, ELDEN RING
		for (String line : FancyMessage.ELDEN_RING.split("\n")) {
			new Display().println(line);
			try {
				Thread.sleep(200);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}

		World world = new World(new Display());
		MapManager.getInstance().start(world);
		world.run();
	}
}
