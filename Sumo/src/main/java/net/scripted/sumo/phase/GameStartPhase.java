package net.scripted.sumo.phase;

import net.scripted.core.Module;
import net.scripted.core.account.Account;
import net.scripted.core.account.AccountManager;
import net.scripted.core.commons.ChatUtil;
import net.scripted.core.commons.location.LocationUtils;
import net.scripted.gamecore.event.GamePlayerLeaveEvent;
import net.scripted.gamecore.lifecycle.Lifecycle;
import net.scripted.gamecore.phase.AbstractPhase;
import net.scripted.sumo.event.SumoGameOverEvent;
import net.scripted.sumo.game.SumoGame;
import net.scripted.sumo.map.SumoMap;
import net.scripted.sumo.toggle.OutOfBoundsCheckToggle;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public class GameStartPhase extends AbstractPhase<SumoGame> {

    public GameStartPhase(SumoGame game) {
        super(game);
    }

    @Override
    protected void start() {


        //From this phase on if a player leaves the other player wins

        game.getEventBus().subscribe(GamePlayerLeaveEvent.class, event -> {
            if(!event.getGame().equals(game))return;
            //Game-over current player wins
            handleGameOver(event.getPlayer());
        });

        game.getEventBus().subscribe(SumoGameOverEvent.class, event -> {
            if(!event.getGame().equals(game))return;

            handleGameOver(event.getLoser());
        });

        //Teleport players to spawn locations

        List<Location> locations = game.getMapData().getLocations(SumoMap.SumoMapLocationType.SPAWN_LOCATION);

        for(Player player : game.getPlayerTracker().getBukkitPlayers()){
            Location randomLocation = LocationUtils.getRandomLocation(locations);
            locations.remove(randomLocation);

            player.teleport(randomLocation);
        }

        game.getGameToggleManager().addToggle(new OutOfBoundsCheckToggle(game));
    }

    private void handleGameOver(UUID loser) {

        List<UUID> players = game.getPlayerTracker().getPlayers();
        AccountManager manager = Module.getModule(AccountManager.class);
        for(UUID playerUUID : players){

            manager.getOrLoadAccount(playerUUID).
                    thenAccept(account -> {
                        if(account.getUuid().equals(loser)){
                            Player player = Bukkit.getPlayer(playerUUID);
                            if(player == null)return; //Player left

                            player.sendTitle(ChatUtil.formatString("&c You Lost"), null, 0, 60, 0);


                        }
                        else{
                            Player player = Bukkit.getPlayer(playerUUID);
                            if(player == null)return; //Player left

                            player.sendTitle(ChatUtil.formatString("&e You won"), null, 0, 60, 0);

                        }
                    });
        }
        nextPhase();

    }

    @Override
    protected void end() {

    }

    @Override
    protected void cleanup() {

    }
}
