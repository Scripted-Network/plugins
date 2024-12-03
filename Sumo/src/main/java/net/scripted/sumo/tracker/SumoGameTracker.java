package net.scripted.sumo.tracker;

import net.scripted.sumo.game.SumoGame;
import net.scripted.core.ScriptedPlugin;
import net.scripted.gamecore.map.GameMap;
import net.scripted.gamecore.tracker.GameInstanceTracker;

public class SumoGameTracker extends GameInstanceTracker<SumoGame> {


    public SumoGameTracker(ScriptedPlugin plugin, GameMap<SumoGame> gameMap) {
        super(plugin, gameMap);
    }

    @Override
    protected SumoGame getInstance() {
        return new SumoGame(plugin, getMaxPlayersPerGame(), getMaxPlayersPerGame());
    }

    @Override
    protected int getMaxGameInstances() {
        return 5;
    }

    @Override
    protected int getMinGameInstances() {
        return 2;
    }

    @Override
    protected int getMaxPlayersPerGame() {
        return 2;
    }


}
