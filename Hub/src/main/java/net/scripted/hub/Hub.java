package net.scripted.hub;

import net.scripted.core.PluginInfo;
import net.scripted.core.ScriptedPlugin;

import java.util.function.Consumer;

@PluginInfo(name = "Hub")
public class Hub extends ScriptedPlugin {


    @Override
    public void shutdownServerAsap(String s, Consumer<Void> consumer) {

    }

    @Override
    protected void enableModules() {

    }

    @Override
    protected void onPluginEnable() {
        getLogger().info("Hub enabled!");

    }

    @Override
    protected void onPluginDisable() {
        getLogger().info("Hub disabled");
    }
}
