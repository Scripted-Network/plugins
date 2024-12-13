package net.scripted.sumo;

import net.scripted.core.PluginInfo;
import net.scripted.core.PluginType;
import net.scripted.core.commons.location.ScriptedLocation;
import net.scripted.sumo.game.SumoGame;
import net.scripted.sumo.map.SumoMap;
import net.scripted.gamecore.GameCore;
import net.scripted.sumo.tracker.SumoGameTracker;

import java.io.File;

@PluginInfo(name = "Sumo", type = PluginType.GAME)
public class Sumo extends GameCore<SumoGame> {

    @Override
    protected void onPluginStart() {

    }

    @Override
    protected void onPluginLoad() {
        for(SumoMap.SumoMapLocationType type : SumoMap.SumoMapLocationType.values()){
            ScriptedLocation.addLocationType(type);
        }
        gameMap = new SumoMap(new File(ROOT_FOLDER, "templates"), getMapManager(), this);
        gameInstanceTracker = new SumoGameTracker(this, gameMap);

    }

    @Override
    protected void onPluginDisable() {

    }
}
