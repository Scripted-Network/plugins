package net.scripted.sumo.phase;

import net.scripted.gamecore.phase.AbstractPhase;
import net.scripted.sumo.game.SumoGame;

import static net.scripted.gamecore.toggle.ToggleType.DefaultToggles.PVP;

public class SumoPostGameTogglePhase extends AbstractPhase<SumoGame> {
    public SumoPostGameTogglePhase(SumoGame game) {
        super(game);
    }

    @Override
    protected void start() {
        game.getGameToggleManager().disable(PVP);
    }

    @Override
    protected void end() {

    }

    @Override
    protected void cleanup() {

    }
}
