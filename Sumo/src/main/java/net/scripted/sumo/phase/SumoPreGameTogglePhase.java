package net.scripted.sumo.phase;

import net.scripted.gamecore.phase.AbstractPhase;
import net.scripted.sumo.game.SumoGame;

import static net.scripted.gamecore.toggle.ToggleType.DefaultToggles.*;

public class SumoPreGameTogglePhase extends AbstractPhase<SumoGame> {


    public SumoPreGameTogglePhase(SumoGame game) {
        super(game);
    }

    @Override
    protected void start() {
        game.getGameToggleManager().disable(PVP, HUNGER, FALL_DAMAGE,
                DAMAGE, PLACE_BLOCK, BREAK_BLOCK,
                BURN_BLOCK, CRAFT);

        game.getGameToggleManager().enable(MOVE, CHAT);

        nextPhase();
    }

    @Override
    protected void end() {

    }

    @Override
    protected void cleanup() {

    }
}
