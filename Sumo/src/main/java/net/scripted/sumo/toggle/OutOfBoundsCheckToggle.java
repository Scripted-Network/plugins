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

    private final SumoGame game;

    public OutOfBoundsCheckToggle(SumoGame game) {
        super(game);
        this.game = game;
    }

    @Override
    protected void setup() {
        game.getEventBus().subscribe(PlayerMoveEvent.class, event -> {

            Player player = event.getPlayer();
            if(!isEnabled() || !isGameEntity(player))return;

            if(event.getTo() == null)return;

            if(event.getTo().toVector().equals(event.getFrom().toVector()))return;

            Location newLocation = event.getTo();

            if(!game.getAreaSize().contains(new Vector(newLocation.getX(), newLocation.getY(), newLocation.getZ()))){
                SumoGameOverEvent gameOverEvent = new SumoGameOverEvent(game, player.getUniqueId());
                Bukkit.getPluginManager().callEvent(gameOverEvent);
            }

        });
    }

    @Override
    public ToggleType getToggleType() {
        return null;
    }
}
