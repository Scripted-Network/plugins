package net.scripted.hub;

import net.scripted.core.PluginInfo;
import net.scripted.core.ScriptedPlugin;

import net.scripted.core.commons.location.LocationType;
import net.scripted.core.commons.location.ScriptedLocation;
import net.scripted.core.commons.menu.MenuManager;
import net.scripted.core.commons.menu.button.MenuButton;
import net.scripted.core.map.ScriptedMap;
import net.scripted.entity.ScriptedEntity;


import net.scripted.hub.menu.LobbiesMenu;
import net.scripted.hub.menu.handler.ServerSwitchButtonHandler;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;

import java.util.Objects;
import java.util.function.Consumer;

@PluginInfo(name = "Hub")
public class Hub extends ScriptedPlugin implements Listener {




    @Override
    protected void onPluginLoad() {
        getLogger().info("Hub enabled!");
        getServer().getPluginManager().registerEvents(this,this);
        MenuButton.registerHandler(ServerSwitchButtonHandler.class, new ServerSwitchButtonHandler());
        MenuManager.registerMenu(new LobbiesMenu("Lobbies", getSpigotServer().getServerGroup(), getSpigotServer().getRegion()));
    }

    @Override
    protected void onPluginStart() {

    }

    @Override
    public void shutdownServerAsap(String s, Consumer<Void> consumer) {
        consumer.accept(null);
    }

    @Override
    protected void enableModules() {

    }


    @EventHandler
    public void onPlayerDamager(EntityDamageEvent e){
        if(e.getCause() == EntityDamageEvent.DamageCause.FALL){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerSpawn(PlayerSpawnLocationEvent e){
        Player player = e.getPlayer();
        World world = player.getWorld();

        ScriptedMap scriptedMap = getMapManager().getScriptedMap(world.getName() + ".json");

        if(scriptedMap == null){
            getLogger().info("Map for world %s is null".formatted(world.getName()));
            return;
        }

        Location location = scriptedMap.getLocation(ScriptedLocation.DefaultLocationTypes.MAIN_SPAWN);

        if(location == null){
            getLogger().warning("Main spawn doesnt exist");
            return;
        }

        e.setSpawnLocation(location);




    }



    @Override
    protected void onPluginDisable() {
        getLogger().info("Hub disabled");
    }


}
