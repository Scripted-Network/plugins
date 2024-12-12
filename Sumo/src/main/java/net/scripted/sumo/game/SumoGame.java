package net.scripted.sumo.game;

import lombok.Getter;
import net.scripted.core.ScriptedPlugin;
import net.scripted.core.commons.shape.Cuboid;
import net.scripted.gamecore.game.AbstractGame;
import net.scripted.gamecore.phase.impl.CountdownPhase;
import net.scripted.gamecore.phase.impl.WaitForPlayersPhase;
import net.scripted.sumo.map.SumoMap;
import net.scripted.sumo.phase.GameOverPhase;
import net.scripted.sumo.phase.GameStartPhase;
import org.bukkit.Location;

@Getter
public class SumoGame extends AbstractGame {

    private final Cuboid areaSize;

    public SumoGame(ScriptedPlugin plugin, int minPlayers, int maxPlayers) {
        super(plugin, minPlayers, maxPlayers);

        Location minBound = getMapData().getLocation(SumoMap.SumoMapLocationType.LOWER_ARENA_CORNER);
        Location maxBound = getMapData().getLocation(SumoMap.SumoMapLocationType.UPPER_ARENA_CORNER);


        areaSize = new Cuboid(minBound, maxBound);

        addPhase(new WaitForPlayersPhase(this));
        addPhase(new CountdownPhase(11, this));
        addPhase(new GameStartPhase(this));
        addPhase(new GameOverPhase(this)); //Flying and shit phase
        addPhase(new KickPlayersPhase(this)); //Kick everyone phase -> go back to hub
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
