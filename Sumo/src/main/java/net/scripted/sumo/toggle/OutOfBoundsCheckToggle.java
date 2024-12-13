package net.scripted.sumo.toggle;

import net.scripted.gamecore.game.Game;
import net.scripted.gamecore.toggle.AbstractGameToggle;
import net.scripted.gamecore.toggle.ToggleType;
import net.scripted.sumo.event.SumoGameOverEvent;
import net.scripted.sumo.game.SumoGame;
import net.scripted.sumo.map.SumoMap;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import java.util.List;

public class OutOfBoundsCheckToggle extends AbstractGameToggle {

    public OutOfBoundsCheckToggle(SumoGame game) {
        super(game);
    }

    @Override
    protected void setup() {
        SumoGame game = (SumoGame) this.game;
        game.getEventBus().subscribe(PlayerMoveEvent.class, event -> {
            game.getLogger().log("MOVE1");
            Player player = event.getPlayer();

            if(!isEnabled()){
                game.getLogger().log("Toggle not enabled!");
                return;
            }

            if(!isGameEntity(player)){
                game.getLogger().log("Player not in game!");
                return;
            }

            if(event.getTo() == null)return;

            if(event.getTo().toVector().equals(event.getFrom().toVector()))return;

            Location newLocation = event.getTo();
            game.getLogger().log("MOVE2");
            if(!game.getAreaSize().contains(new Vector(newLocation.getX(), newLocation.getY(), newLocation.getZ()))){
                SumoGameOverEvent gameOverEvent = new SumoGameOverEvent(game, player.getUniqueId());
                Bukkit.getPluginManager().callEvent(gameOverEvent);
            }

        });
    }

    @Override
    protected boolean enableByDefault() {
        return false;
    }

    @Override
    public ToggleType getToggleType() {
        return SumoToggleTypes.OUT_OF_BOUNDS;
    }
}
