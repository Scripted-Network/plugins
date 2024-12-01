package net.scripted.hub.menu;

import net.scripted.core.commons.ChatUtil;
import net.scripted.core.commons.ItemBuilder;
import net.scripted.core.commons.menu.Menu;
import net.scripted.core.commons.menu.button.MenuButton;
import net.scripted.database.redis.Region;
import net.scripted.database.redis.server.Server;
import net.scripted.database.redis.server.ServerGroup;
import net.scripted.database.redis.server.ServerRepository;
import net.scripted.database.redis.server.impl.SpigotServer;
import net.scripted.hub.Hub;
import net.scripted.hub.menu.handler.ServerSwitchButtonHandler;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A menu which will populate items with all servers of that group in that region
 */
public class LobbiesMenu extends Menu {


    private final String groupName;
    private final Region region;


    public LobbiesMenu(String menuName, String groupName, Region region) {
        super(menuName, 45);
        this.groupName = groupName;
        this.region = region;
        initialiseSlots();
    }

    private void initialiseSlots() {
        List<Integer> slots = getSlots("XXXXXXXXX",
                "X0X0X0X0X",
                "X0X0X0X0X",
                "X0X0X0X0X",
                "XXXXXXXXX"
        );

        int index = 0;

        Set<SpigotServer> serversInGroup = ServerRepository.INSTANCE.getServersInGroup(groupName, region)
                .stream()
                .filter(Server::isAcceptingPlayers)
                .collect(Collectors.toSet());

        for(SpigotServer server : serversInGroup){
            MenuButton serverButton = new MenuButton()
                    .withItem(
                            new ItemBuilder()
                                    .withItem(Hub.INSTANCE.getServer().getName().equals(server.getName()) ? Material.RED_CONCRETE : Material.GRAY_CONCRETE)
                                    .withName(ChatUtil.formatString("&c %s".formatted(server.getName())))
                                    .withTags(ItemFlag.HIDE_ATTRIBUTES)
                                    .create()
                    )
                    .addData("server", server.getName())
                    .withType(MenuButton.ButtonType.SERVER_SWITCH);
            addButton(slots.get(index++), serverButton);
        }
    }
}
