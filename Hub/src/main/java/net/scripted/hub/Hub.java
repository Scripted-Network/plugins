import net.scripted.core.ScriptedPlugin;

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
