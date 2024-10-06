package net.scripted.hub;

import net.scripted.core.PluginInfo;
import net.scripted.core.ScriptedPlugin;

@PluginInfo(name = "Hub")
public class Hub extends ScriptedPlugin {
    @Override
    protected void onPluginEnable() {
        getLogger().info("Hub enabled!");

    }

    @Override
    protected void onPluginDisable() {
        getLogger().info("Hub disabled");
    }
}
