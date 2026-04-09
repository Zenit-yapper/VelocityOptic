package com.astreal.velocityoptic;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.AbstractSliderButton;
import net.minecraft.network.chat.Component;

public class VelocityOpticScreen extends Screen {
    public VelocityOpticScreen() {
        super(Component.literal("VelocityOptic Settings"));
    }

    @Override
    protected void init() {
        // The Slider for Strength
        this.addRenderableWidget(new AbstractSliderButton(this.width / 2 - 100, this.height / 2 - 20, 200, 20, 
            Component.literal("Blur Strength: " + (int)(VelocityOpticClient.blurStrength * 100) + "%"), 
            (double) VelocityOpticClient.blurStrength) {
            
            @Override
            protected void updateMessage() {
                this.setMessage(Component.literal("Blur Strength: " + (int)(this.value * 100) + "%"));
            }

            @Override
            protected void applyValue() {
                VelocityOpticClient.blurStrength = (float) this.value;
            }
        });

        // Close Button
        this.addRenderableWidget(Button.builder(Component.literal("Done"), button -> this.onClose())
                .bounds(this.width / 2 - 100, this.height / 2 + 20, 200, 20).build());
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        super.render(guiGraphics, mouseX, mouseY, delta);
        guiGraphics.drawCenteredString(this.font, this.title, this.width / 2, 20, 0xFFFFFF);
    }
}
