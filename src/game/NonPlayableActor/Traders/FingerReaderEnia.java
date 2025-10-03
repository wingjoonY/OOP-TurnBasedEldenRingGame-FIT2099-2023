package game.NonPlayableActor.Traders;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Actions.TradeActions.ExchangeAction;
import game.Actions.TradeActions.SellAction;
import game.Enums.PlayerStatus;
import game.Interfaces.Exchangeable;
import game.Interfaces.Sellable;
import game.Items.GoldenSeeds;
import game.Items.PoisonBoluses;
import game.Items.RemembranceOfTheGrafted;
import game.Weapons.IntrinsicWeapons.GraftedDragon;
import game.Weapons.WeaponItems.*;

import java.util.ArrayList;

public class FingerReaderEnia extends Traders {

    protected ArrayList<Sellable> sellables = new ArrayList<>();

    protected ArrayList<Exchangeable> exchangeables = new ArrayList<>();

    /**
     * Constructor for FingerReaderEnia.
     */
    public FingerReaderEnia() {
        super("Finger Reader Enia", 'E', 9999);
        this.addSellables(new Club());
        this.addSellables(new GreatKnife());
        this.addSellables(new Grossmesser());
        this.addSellables(new Scimitar());
        this.addSellables(new Uchigatana());
        this.addSellables(new HeavyCrossbow());
        this.addSellables(new AstrologerStaff());
        this.addSellables(new GoldenSeeds());
        this.addSellables(new PoisonBoluses());
        this.addSellables(new RemembranceOfTheGrafted());
        this.addExchangables(new AxeOfGodrick());
        this.addExchangables(new GraftedDragon());

    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(PlayerStatus.TRADABLE)){
            for (Sellable sellable : sellables){
                actions.add(new SellAction(sellable));
            }
            for (Exchangeable exchangeable : exchangeables){
                actions.add(new ExchangeAction(exchangeable));
            }

        }
        return actions;
    }

    public void addSellables (Sellable sellable){
        this.sellables.add(sellable);
    }

    public void addExchangables (Exchangeable exchangeable){
        this.exchangeables.add(exchangeable);
    }

}
