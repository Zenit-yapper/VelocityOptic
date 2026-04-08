package com.astreal.velocityoptic;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VelocityOpticClient implements ClientModInitializer {
    public static final String MOD_ID = "velocityoptic";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        LOGGER.info("VelocityOptic Core Loaded - Target: Minecraft 1.21.11");
    }
}

