package net.scripted.sumo.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.scripted.core.commons.BukkitEvent;
import net.scripted.gamecore.game.Game;
import org.bukkit.entity.Player;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class SumoGameOverEvent extends BukkitEvent {

    private final Game game;
    private final UUID loser;



}
