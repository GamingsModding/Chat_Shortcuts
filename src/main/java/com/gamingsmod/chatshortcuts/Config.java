package com.gamingsmod.chatshortcuts;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class Config
{
    public static Configuration configuration;

    public static String message1;
    public static String message2;
    public static String message3;
    public static String message4;
    public static String message5;

    public static void init(File file)
    {
        if (configuration == null) {
            configuration = new Configuration(file);
        }
        loadConfig();
    }

    public static void loadConfig()
    {
        message1 = configuration.get(Configuration.CATEGORY_GENERAL, "Shortcut 1", "gg").getString();
        message2 = configuration.get(Configuration.CATEGORY_GENERAL, "Shortcut 2", "hf").getString();
        message3 = configuration.get(Configuration.CATEGORY_GENERAL, "Shortcut 3", "wp").getString();
        message4 = configuration.get(Configuration.CATEGORY_GENERAL, "Shortcut 4", "[placehold]").getString();
        message5 = configuration.get(Configuration.CATEGORY_GENERAL, "Shortcut 5", "[placehold]").getString();

        if (configuration.hasChanged())
            configuration.save();
    }

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent e)
    {
        System.out.println(e.getModID());
        if(e.getModID().equalsIgnoreCase("chatshortcuts"))
            loadConfig();
    }
}
