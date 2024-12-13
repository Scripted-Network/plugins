package net.scripted.sumo.admin.command;

import lombok.AllArgsConstructor;
import net.scripted.core.command.Command;
import net.scripted.core.command.CommandInfo;
import net.scripted.core.commons.shape.Cuboid;
import org.bukkit.Color;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@AllArgsConstructor
@CommandInfo(name = "render")
public class RenderCubeCommand extends Command {

    private final Cuboid cuboid;

    @Override
    public boolean execute(CommandSender commandSender, String[] strings) {

        if(!(commandSender instanceof Player player))return false;

        cuboid.renderOutline(player.getWorld(), Color.AQUA);

        return true;
    }
}
