package game.Interfaces;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;

public interface Exchangeable {

    public String exchange(Actor actor);

    Item exchangableItem();
}
