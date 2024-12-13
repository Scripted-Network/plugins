package net.scripted.sumo.game;

import lombok.Getter;
import net.scripted.core.ScriptedPlugin;
import net.scripted.core.commons.shape.Cuboid;
import net.scripted.gamecore.game.AbstractGame;
import net.scripted.gamecore.phase.impl.CountdownPhase;
import net.scripted.gamecore.phase.impl.KickPlayerPhase;
import net.scripted.gamecore.phase.impl.WaitForPlayersPhase;
import net.scripted.sumo.admin.command.RenderCubeCommand;
import net.scripted.sumo.map.SumoMap;
import net.scripted.sumo.phase.*;
import net.scripted.sumo.toggle.OutOfBoundsCheckToggle;
import org.bukkit.Location;

@Getter
public class SumoGame extends AbstractGame {

    private Cuboid areaSize;

    public SumoGame(ScriptedPlugin plugin, int minPlayers, int maxPlayers) {
        super(plugin, minPlayers, maxPlayers);

    }

    @Override
    protected void start() {
        Location minBound = getMapData().getLocation(SumoMap.SumoMapLocationType.LOWER_ARENA_CORNER);
        Location maxBound = getMapData().getLocation(SumoMap.SumoMapLocationType.UPPER_ARENA_CORNER);

        getGameToggleManager().addToggle(new OutOfBoundsCheckToggle(this));

        areaSize = new Cuboid(minBound, maxBound);

        RenderCubeCommand renderCubeCommand = new RenderCubeCommand(areaSize);
        getPlugin().getCommandHandler().addCommand(renderCubeCommand);

        addPhase(new SumoPreGameTogglePhase(this));
        addPhase(new WaitForPlayersPhase(this));
        addPhase(new CountdownPhase(11, this));

        addPhase(new SumoGameTogglePhase(this));
        addPhase(new GameStartPhase(this));

        addPhase(new SumoPostGameTogglePhase(this));
        addPhase(new GameOverPhase(this)); //Flying and shit phase
        addPhase(new KickPlayerPhase(this)); //Kick everyone phase -> go back to hub
    }


    @Override
    protected void stop() {

    }

    @Override
    public String getGameName() {
        return "Sumo";
    }


}
