package net.scripted.sumo.phase;

import net.scripted.gamecore.phase.AbstractPhase;
import net.scripted.sumo.game.SumoGame;

import static net.scripted.gamecore.toggle.ToggleType.DefaultToggles.*;

public class SumoGameTogglePhase extends AbstractPhase<SumoGame> {

    public SumoGameTogglePhase(SumoGame game) {
        super(game);
    }

    @Override
    protected void start() {
        game.getGameToggleManager().enable(PVP);
        nextPhase();
    }

    @Override
    protected void end() {

    }

    @Override
    protected void cleanup() {

    }
}
