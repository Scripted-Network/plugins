package net.scripted.sumo.phase;

import net.scripted.core.commons.ChatUtil;
import net.scripted.gamecore.phase.AbstractPhase;
import net.scripted.sumo.game.SumoGame;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class GameCountDownPhase extends AbstractPhase<SumoGame> {

    private int taskID;
    private int gameCount = 5;

    public GameCountDownPhase(SumoGame game) {
        super(game);
    }

    @Override
    protected void start() {

        BukkitTask task = Bukkit.getScheduler().runTaskTimerAsynchronously(game.getPlugin(), () ->{

            if(gameCount <= 0){
                nextPhase();
            }
            else{
                handleCount(gameCount);
                gameCount--;
            }

        }, 20, 20);

        this.taskID = task.getTaskId();
    }

    private void handleCount(int gameCount) {

        for(Player player : game.getPlayerTracker().getBukkitPlayers()){
            player.sendTitle(ChatUtil.formatString("&c %s".formatted(gameCount)), null, 0,20,0);
        }

    }

    @Override
    protected void end() {

    }

    @Override
    protected void cleanup() {

    }
}
