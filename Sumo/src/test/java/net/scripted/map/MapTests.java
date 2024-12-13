package net.scripted.map;

import lombok.SneakyThrows;
import net.scripted.core.ScriptedPlugin;
import net.scripted.core.commons.location.ScriptedLocation;
import net.scripted.core.map.MapManager;
import net.scripted.core.map.ScriptedMap;
import net.scripted.core.npc.NPC;
import net.scripted.core.npc.NPCManager;
import net.scripted.sumo.map.SumoMap;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Server;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class MapTests {

    @SneakyThrows
    @Test
    public void testMap(){

        ScriptedPlugin plugin = mock(ScriptedPlugin.class);

        Server server = mock(Server.class);
        Path tempDir = Files.createTempDirectory("map-tests");
        File mapDirectory = tempDir.toFile();

        System.out.printf("Created file at %s%n", mapDirectory.getAbsolutePath());

        try (MockedStatic<Bukkit> mockedBukkit = mockStatic(Bukkit.class)) {
            mockedBukkit.when(Bukkit::getServer).thenReturn(server);
            mockedBukkit.when(Bukkit::getLogger).thenReturn(Logger.getLogger("s"));

            when(server.getWorld(anyString())).thenReturn(null);

            MapManager mapManager = new MapManager(mapDirectory)
                    .registerManager(ScriptedLocation.class, ScriptedLocation.getSerializer());

            ScriptedMap map = new ScriptedMap("default", "Sumo map for scritped!", "Luxoruu", System.currentTimeMillis(), System.currentTimeMillis());

            map.addData(ScriptedMap.MapStorageDataType.LOCATION, new ScriptedLocation(new Location(null, 65, -1, 56, 0, 0), SumoMap.SumoMapLocationType.SPAWN_LOCATION));
            map.addData(ScriptedMap.MapStorageDataType.LOCATION, new ScriptedLocation(new Location(null, 65, -1, 74, 0, 180), SumoMap.SumoMapLocationType.SPAWN_LOCATION));
            map.addData(ScriptedMap.MapStorageDataType.LOCATION, new ScriptedLocation(new Location(null, 53, -4, 75), SumoMap.SumoMapLocationType.LOWER_ARENA_CORNER));
            map.addData(ScriptedMap.MapStorageDataType.LOCATION, new ScriptedLocation(new Location(null, 78, 7, 54), SumoMap.SumoMapLocationType.UPPER_ARENA_CORNER));

            mapManager.saveMapToFile(map, map.getName());
        }


    }

}
