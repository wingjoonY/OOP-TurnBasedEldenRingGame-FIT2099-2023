package game.Interfaces;

import edu.monash.fit2099.engine.actors.Actor;

public interface Consumable {
    String consume(Actor actor);
    int getUseCount();
}
