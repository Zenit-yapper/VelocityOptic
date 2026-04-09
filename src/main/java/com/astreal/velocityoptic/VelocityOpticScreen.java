package com.astreal.velocityoptic;

import net.minecraft.client.gui.Screen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.SliderWidget;
import net.minecraft.text.Text;

public class VelocityOpticScreen extends Screen {
    public VelocityOpticScreen() {
        super(Text.literal("VelocityOptic Settings"));
    }

    @Override
    protected void init() {
        // The Slider for Strength
        this.addDrawableChild(new SliderWidget(this.width / 2 - 100, this.height / 2 - 20, 200, 20, 
            Text.literal("Blur Strength: " + (int)(VelocityOpticClient.blurStrength * 100) + "%"), 
            (double) VelocityOpticClient.blurStrength) {
            
            @Override
            protected void updateMessage() {
                this.setMessage(Text.literal("Blur Strength: " + (int)(this.value * 100) + "%"));
            }

            @Override
            protected void applyValue() {
                VelocityOpticClient.blurStrength = (float) this.value;
            }
        });

        // Close Button
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Done"), button -> this.close())
                .dimensions(this.width / 2 - 100, this.height / 2 + 20, 200, 20).build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 20, 0xFFFFFF);
        super.render(context, mouseX, mouseY, delta);
    }
}

