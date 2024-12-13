package net.scripted.sumo.phase;

import net.scripted.gamecore.phase.AbstractPhase;
import net.scripted.gamecore.phase.Phase;
import net.scripted.sumo.game.SumoGame;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class GameOverPhase extends AbstractPhase<SumoGame> {


    public GameOverPhase(SumoGame game) {
        super(game);
    }

    @Override
    protected void start() {
        for(Player player : game.getPlayerTracker().getBukkitPlayers()){
            player.setAllowFlight(true);
            player.setGameMode(GameMode.ADVENTURE);
        }
        Bukkit.getScheduler().runTaskLaterAsynchronously(game.getPlugin(), this::nextPhase, 100L);
    }

    @Override
    protected void end() {

    }

    @Override
    protected void cleanup() {

    }
}
