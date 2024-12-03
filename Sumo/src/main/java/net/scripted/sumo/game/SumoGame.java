package net.scripted.sumo.game;

import net.scripted.core.ScriptedPlugin;
import net.scripted.gamecore.game.AbstractGame;
import net.scripted.gamecore.phase.impl.CountdownPhase;
import net.scripted.gamecore.phase.impl.WaitForPlayersPhase;
import org.bukkit.entity.Player;

public class SumoGame extends AbstractGame {



    public SumoGame(ScriptedPlugin plugin, int minPlayers, int maxPlayers) {
        super(plugin, minPlayers, maxPlayers);
        addPhase(new WaitForPlayersPhase(this));
        addPhase(new CountdownPhase(11, this));
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
