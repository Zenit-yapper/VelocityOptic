package com.astreal.velocityoptic;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import com.mojang.blaze3d.platform.InputConstants;
import org.lwjgl.glfw.GLFW;

public class VelocityOpticClient implements ClientModInitializer {
    public static float blurStrength = 0.4f; 
    private static KeyMapping guiKey;

    @Override
    public void onInitializeClient() {
        guiKey = KeyBindingHelper.registerKeyMapping(new KeyMapping(
                "key.velocityoptic.open_menu",
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_SHIFT, 
                "category.velocityoptic"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (guiKey.consumeClick()) {
                client.setScreen(new VelocityOpticScreen());
            }
        });
    }
}
