import game.SumoGame;
import map.SumoMap;
import net.scripted.gamecore.GameCore;
import tracker.SumoGameTracker;

import java.io.File;

public class Sumo extends GameCore<SumoGame> {

    @Override
    protected void onPluginLoad() {
        gameMap = new SumoMap(new File(ROOT_FOLDER, "templates"), getMapManager(), this);
        gameInstanceTracker = new SumoGameTracker(this, gameMap);

    }
}
