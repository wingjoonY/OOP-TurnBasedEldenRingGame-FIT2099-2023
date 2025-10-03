package game.Utils;

import edu.monash.fit2099.demo.conwayslife.Player;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.NonPlayableActor.CastleEnemies.Dog;
import game.NonPlayableActor.CastleEnemies.GodrickSoldier;
import game.PlayableArchetypes.PlayableCharacter;
import game.NonPlayableActor.*;
import game.NonPlayableActor.GraveyardEnemies.HeavySkeletalSwordsman;
import game.NonPlayableActor.GraveyardEnemies.SkeletalBandit;
import game.NonPlayableActor.GustEnemies.GiantDog;
import game.NonPlayableActor.GustEnemies.LoneWolf;
import game.NonPlayableActor.OceanicEnemies.GiantCrab;
import game.NonPlayableActor.OceanicEnemies.GiantCrayfish;

/**
 * A EnemyFactory class that manages the action of spawning actors on ground
 * @author Keith Ong Guo Er
 * @version 1.0
 */
public class EnemyFactory {
    /**
     * The type of ground
     */
    private Ground ground;
    /**
     * Location on the game map
     */
    private Location location;
    /**
     * The player of Elden Ring
     */
    private PlayableCharacter playableCharacter;

    /**
     * A static instance of EnemyFactory
     */
    private static EnemyFactory instance;

    /**
     * Constructor for the EnemyFactory class
     */
    private EnemyFactory() {
    }

    /**
     * Gets and instance of EnemyFactory class
     * @return the instance of EnemyFactory class
     */
    public static EnemyFactory getInstance() {
        if (instance == null) {
            instance = new EnemyFactory();
        }
        return instance;
    }

    /**
     * Helps determine what type of enemies ground will spawn
     * @return Enemy depending on their ground
     */
    public NonPlayableActor spawn() {
        char groundChar = ground.getDisplayChar();
        int middle = (location.map().getXRange().max() + 1) / 2;
        if (groundChar == 'n') {
            if (RandomNumberGenerator.getRandomInt(100) <= 27) {
                if (location.x() <= middle) {
                    return new HeavySkeletalSwordsman(playableCharacter);
                } else {
                    return new SkeletalBandit(playableCharacter);
                }
            }
        } else if (groundChar == '&') {
            if (location.x() <= middle) {
                if (RandomNumberGenerator.getRandomInt(100) <= 33) {
                    return new LoneWolf(playableCharacter);
                }
            } else {
                if (RandomNumberGenerator.getRandomInt(100) <= 4) {
                    return new GiantDog(playableCharacter);
                }
            }
        } else if (groundChar == '~') {
            if (location.x() <= middle) {
                if (RandomNumberGenerator.getRandomInt(100) <= 2) {
                    return new GiantCrab(playableCharacter);
                }
            } else {
                if (RandomNumberGenerator.getRandomInt(100) <= 1) {
                    return new GiantCrayfish(playableCharacter);
                }
            }
        }else if (groundChar == '<'){
            if(RandomNumberGenerator.getRandomInt(100) <= 37){
                return new Dog(playableCharacter);
            }
        } else if (groundChar == 'B'){
            if(RandomNumberGenerator.getRandomInt(100) <= 45){
                return new GodrickSoldier(playableCharacter);
            }
        }
        return null;
    }

    public void setPlayableCharacter(PlayableCharacter playableCharacter) {
        this.playableCharacter = playableCharacter;
    }

    public void setGround(Ground ground, Location location) {
        this.ground = ground;
        this.location = location;
    }

}
