package game.NonPlayableActor.Traders;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Actions.TradeActions.PurchaseAction;
import game.Actions.TradeActions.SellAction;
import game.Enums.PlayerStatus;
import game.Interfaces.Purchasable;
import game.Interfaces.Sellable;
import game.Items.GoldenSeeds;
import game.Items.PoisonBoluses;
import game.Items.RemembranceOfTheGrafted;
import game.Weapons.IntrinsicWeapons.GraftedDragon;
import game.Weapons.WeaponItems.*;

import java.util.ArrayList;

public class MerchantKale extends Traders {
    protected ArrayList<Purchasable> purchasables = new ArrayList<>();
    protected ArrayList<Sellable> sellables = new ArrayList<>();

    /**
     * Constructor.
     */
    public MerchantKale() {
        super("Merchant Kale", 'K', 9999);
        this.addPurchasables(new Club());
        this.addPurchasables(new GreatKnife());
        this.addPurchasables(new Scimitar());
        this.addPurchasables(new Uchigatana());
        this.addPurchasables(new HeavyCrossbow());
        this.addPurchasables(new AstrologerStaff());
        this.addPurchasables(new GoldenSeeds());
        this.addPurchasables(new PoisonBoluses());
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
        this.addSellables(new GraftedDragon());
        this.addSellables(new AxeOfGodrick());
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();

        if(otherActor.hasCapability(PlayerStatus.TRADABLE)){
            for (Purchasable purchasable : purchasables){
                actions.add(new PurchaseAction(purchasable));
            }
            for (Sellable sellable : sellables ){
                actions.add(new SellAction(sellable));
            }
        }
        return actions;
    }


    public void addPurchasables (Purchasable purchasable){
        this.purchasables.add(purchasable);
    }

    public void addSellables (Sellable sellable){
        this.sellables.add(sellable);
    }
}