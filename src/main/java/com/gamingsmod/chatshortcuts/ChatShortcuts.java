package com.gamingsmod.chatshortcuts;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "chatshortcuts",
        name = "ChatShortcuts",
        version = "GRADLE:BUILD",
        clientSideOnly = true,
        guiFactory = "com.gamingsmod.chatshortcuts.ChatShortcutsGuiConfig")
public class ChatShortcuts
{
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
        Config.init(e.getSuggestedConfigurationFile());
        ModKeyBindings.registerKeyBindings();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e)
    {
        System.out.println("Init");
        MinecraftForge.EVENT_BUS.register(new Config());
    }
}
