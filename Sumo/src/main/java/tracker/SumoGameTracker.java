package tracker;

import game.SumoGame;
import net.scripted.core.ScriptedPlugin;
import net.scripted.gamecore.GameCore;
import net.scripted.gamecore.map.GameMap;
import net.scripted.gamecore.tracker.GameInstanceTracker;

public class SumoGameTracker extends GameInstanceTracker<SumoGame> {


    public SumoGameTracker(ScriptedPlugin plugin, GameMap<SumoGame> gameMap) {
        super(plugin, gameMap, 2, 5, 2);
    }

    @Override
    protected SumoGame getInstance() {
        return new SumoGame(plugin);
    }


}
