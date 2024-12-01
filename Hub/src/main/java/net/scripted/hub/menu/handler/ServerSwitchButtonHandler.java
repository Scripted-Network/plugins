package net.scripted.hub.menu.handler;

import com.google.gson.JsonObject;
import net.scripted.core.commons.menu.button.ButtonHandler;
import net.scripted.core.commons.menu.button.MenuButton;

import java.util.Map;

public class ServerSwitchButtonHandler extends ButtonHandler {
    @Override
    public void handleLoad(MenuButton menuButton, Map<String, String> map) {

    }

    @Override
    protected void handleButtonLoad(MenuButton menuButton, JsonObject jsonObject) {
        String serverName = jsonObject.get("serverName").getAsString();
    }

    @Override
    protected JsonObject handleButtonSave(MenuButton menuButton, JsonObject jsonObject) {
        return null;
    }
}
