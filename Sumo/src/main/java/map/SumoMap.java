package map;

import game.SumoGame;
import net.scripted.core.ScriptedPlugin;
import net.scripted.core.map.MapManager;
import net.scripted.gamecore.map.AbstractGameMap;

import java.io.File;
import java.util.List;

public class SumoMap extends AbstractGameMap<SumoGame> {

    public SumoMap(File pathToSlimeWorlds, MapManager manager, ScriptedPlugin plugin) {
        super(pathToSlimeWorlds, manager, plugin);
    }

    @Override
    protected List<String> getMapNames() {
        return List.of("default");
    }
}
