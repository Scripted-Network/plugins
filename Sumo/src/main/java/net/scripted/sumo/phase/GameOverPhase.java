package net.scripted.sumo.phase;

import net.scripted.gamecore.phase.AbstractPhase;
import net.scripted.gamecore.phase.Phase;
import net.scripted.sumo.game.SumoGame;

public class GameOverPhase extends AbstractPhase<SumoGame> {


    public GameOverPhase(SumoGame game) {
        super(game);
    }

    @Override
    protected void start() {
        game.getGameToggleManager()
    }

    @Override
    protected void end() {

    }

    @Override
    protected void cleanup() {

    }
}
