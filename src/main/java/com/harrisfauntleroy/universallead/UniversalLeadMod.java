package com.harrisfauntleroy.universallead;

import com.mojang.logging.LogUtils;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

/**
 * Main mod class for the Universal Lead Mod
 *
 * @author Harris Fauntleroy
 * @since 1.0.0
 */
// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(UniversalLeadMod.MODID)
public class UniversalLeadMod {
    /** The unique identifier for this mod. */
    public static final String MODID = "universallead";

    /** Logger instance for this mod. */
    private static final Logger LOGGER = LogUtils.getLogger();

    public UniversalLeadMod(final IEventBus modEventBus, final ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond
        // directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class,
        // like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Universal Lead setup
        LOGGER.info("Universal Lead mod initialized");
    }

    /**
     * Called when the server is starting up.
     *
     * @param event the server starting event
     */
    @SubscribeEvent
    public void onServerStarting(final ServerStartingEvent event) {
        // Universal Lead server startup
        LOGGER.info("Universal Lead server started");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class
    // annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        /**
         * Called when the client is being set up.
         *
         * @param event the client setup event
         */
        @SubscribeEvent
        public static void onClientSetup(final FMLClientSetupEvent event) {
            // Universal Lead client setup
            LOGGER.info("Universal Lead client initialized");
        }
    }
}
