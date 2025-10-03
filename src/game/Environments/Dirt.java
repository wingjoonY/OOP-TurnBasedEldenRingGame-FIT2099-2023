package game.Environments;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Items.GoldenRunes;
import game.Utils.RandomNumberGenerator;

/**
 * A class that represents bare dirt.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class Dirt extends Ground {

	private boolean contain = false;

	public Dirt() {
		super('.');
	}

	@Override
	public void tick(Location location) {
		Item goldenRunes = new GoldenRunes(location);
		if (RandomNumberGenerator.getRandomInt(1000) < 2){
			location.addItem(goldenRunes);
			contain = true;
		} else if (contain) {
			if (RandomNumberGenerator.getRandomInt(100) < 70) {
				location.removeItem(goldenRunes);
				contain = false;
			}
		}
	}
}
