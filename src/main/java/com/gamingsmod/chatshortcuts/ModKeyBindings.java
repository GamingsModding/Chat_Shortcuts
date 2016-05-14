package com.gamingsmod.chatshortcuts;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class ModKeyBindings
{
    private static int[] key_codes = new int[] {Keyboard.KEY_G, Keyboard.KEY_H, Keyboard.KEY_J, Keyboard.KEY_K, Keyboard.KEY_L};

    private static KeyBinding keyBinding1;
    private static KeyBinding keyBinding2;
    private static KeyBinding keyBinding3;
    private static KeyBinding keyBinding4;
    private static KeyBinding keyBinding5;

    static void registerKeyBindings()
    {
        MinecraftForge.EVENT_BUS.register(new ModKeyBindings());
        ClientRegistry.registerKeyBinding(keyBinding1 = new KeyBinding("key.shortcut.1", key_codes[0], "key.category.chatShortcuts"));
        ClientRegistry.registerKeyBinding(keyBinding2 = new KeyBinding("key.shortcut.2", key_codes[1], "key.category.chatShortcuts"));
        ClientRegistry.registerKeyBinding(keyBinding3 = new KeyBinding("key.shortcut.3", key_codes[2], "key.category.chatShortcuts"));
        ClientRegistry.registerKeyBinding(keyBinding4 = new KeyBinding("key.shortcut.4", key_codes[3], "key.category.chatShortcuts"));
        ClientRegistry.registerKeyBinding(keyBinding5 = new KeyBinding("key.shortcut.5", key_codes[4], "key.category.chatShortcuts"));

    }

    @SubscribeEvent
    public void onKeyPress(InputEvent.KeyInputEvent e)
    {
        String message = null;
        if (keyBinding1.isKeyDown())
            message = Config.message1;
        else if (keyBinding2.isKeyDown())
            message = Config.message2;
        else if (keyBinding3.isKeyDown())
            message = Config.message3;
        else if (keyBinding4.isKeyDown())
            message = Config.message4;
        else if (keyBinding5.isKeyDown())
            message = Config.message5;

        if (message == null)
            return;

        if (message.equals("[placehold]"))
            return;

        Minecraft.getMinecraft().thePlayer.sendChatMessage(message);
    }
}
