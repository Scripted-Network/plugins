package game;

import net.scripted.core.ScriptedPlugin;
import net.scripted.gamecore.GameCore;
import net.scripted.gamecore.game.AbstractGame;

public class SumoGame extends AbstractGame {

    public SumoGame(ScriptedPlugin plugin) {
        super(plugin);

    }

    @Override
    protected void start() {

    }

    @Override
    protected void stop() {

    }

    @Override
    public String getGameName() {
        return "Sumo";
    }
}
