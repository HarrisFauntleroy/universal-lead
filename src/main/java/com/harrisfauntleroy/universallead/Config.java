package com.harrisfauntleroy.universallead;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

/**
 * Configuration class for the Universal Lead Mod.
 *
 * @see ModConfigSpec
 * @author Harris Fauntleroy
 * @since 1.0.0
 */
@EventBusSubscriber(modid = UniversalLeadMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public final class Config {

    /** Private constructor to prevent instantiation of utility class. */
    private Config() {
        // Utility class
    }

    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.BooleanValue DEBUG_MODE =
            BUILDER.comment("Whether to enable debug logging for room culling")
                    .define("debugMode", false);

    static final ModConfigSpec SPEC = BUILDER.build();

    /** Debug mode configuration flag. */
    private static boolean debugMode;

    /**
     * Gets the current debug mode setting.
     *
     * @return true if debug mode is enabled
     */
    public static boolean isDebugMode() {
        return debugMode;
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        debugMode = DEBUG_MODE.get();
    }
}
