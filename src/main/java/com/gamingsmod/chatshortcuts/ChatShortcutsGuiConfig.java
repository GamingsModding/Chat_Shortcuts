package com.gamingsmod.chatshortcuts;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.List;
import java.util.Set;

public class ChatShortcutsGuiConfig implements IModGuiFactory
{
    @Override
    public void initialize(Minecraft minecraftInstance)
    {
        //NO-OP
    }

    @Override
    public Class<? extends GuiScreen> mainConfigGuiClass()
    {
        return GuiModConfig.class;
    }

    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories()
    {
        return null;
    }

    @Override
    public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element)
    {
        return null;
    }

    public static class GuiModConfig extends GuiConfig
    {

        public GuiModConfig(GuiScreen parentScreen)
        {
                super(parentScreen,
                        new ConfigElement(Config.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                        "ChatShortcuts",
                        false,
                        false,
                        GuiConfig.getAbridgedConfigPath(Config.configuration.toString()));
        }
    }
}
