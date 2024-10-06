package net.scripted.buildserver;

import net.scripted.core.ScriptedPlugin;
import org.bukkit.entity.Player;

public class BuildServer extends ScriptedPlugin {
    @Override
    protected void onPluginEnable() {

        getLogger().info("BuildServer Enabled");
    }

    @Override
    protected void onPluginDisable() {
        getLogger().info("BuildServer Disabled");
    }
}
