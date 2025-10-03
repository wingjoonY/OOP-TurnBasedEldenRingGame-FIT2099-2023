package game.Utils;

import edu.monash.fit2099.engine.actions.ActionList;
import game.Actions.PlayerActions.TravelAction;
import game.Environments.SiteOfLostGrace;

import java.util.ArrayList;
import java.util.List;

public class SiteOfLostGraceManager {
    private static List<SiteOfLostGrace> siteOfLostGraceArray;

    private static SiteOfLostGraceManager instance = null;

    /**
     * Constructor
     */
    private SiteOfLostGraceManager(){
        siteOfLostGraceArray = new ArrayList<>();
    }

    public void registerSiteOfLostGrace (SiteOfLostGrace siteOfLostGrace){
        siteOfLostGraceArray.add(siteOfLostGrace);
    }

    /**
     * Gets and instance of SiteOfLostGraceManager class
     * @return the instance of SiteOfLostGraceManager class
     */
    public static SiteOfLostGraceManager getInstance() {
        if (instance == null) {
            instance = new SiteOfLostGraceManager();
        }
        return instance;
    }

    public ActionList teleport(String name){
        ActionList actions = new ActionList();
        for (SiteOfLostGrace siteOfLostGrace: siteOfLostGraceArray){
            if (siteOfLostGrace.isActivated() && siteOfLostGrace.getName() != name){
                actions.add(new TravelAction(siteOfLostGrace));
            }
        }
        return actions;
    }


}
