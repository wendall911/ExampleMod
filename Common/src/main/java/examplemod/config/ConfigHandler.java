package examplemod.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;

import technology.roughness.whitenoise.config.WhiteNoiseConfigSpec;

public class ConfigHandler {

    public static final WhiteNoiseConfigSpec CLIENT_SPEC;
    public static final WhiteNoiseConfigSpec COMMON_SPEC;
    public static final Map<String, Boolean> conditionsMap = new HashMap<>();

    private static final Client CLIENT;
    private static final Common COMMON;
    private static boolean loaded = false;

    static {
        final Pair<Client, WhiteNoiseConfigSpec> specPairClient = new WhiteNoiseConfigSpec.Builder().configure(Client::new);
        final Pair<Common, WhiteNoiseConfigSpec> specPairCommon = new WhiteNoiseConfigSpec.Builder().configure(Common::new);

        CLIENT_SPEC = specPairClient.getRight();
        CLIENT = specPairClient.getLeft();
        COMMON_SPEC = specPairCommon.getRight();
        COMMON = specPairCommon.getLeft();
    }

    public static void init() {
		conditionsMap.clear();
		conditionsMap.put("disableExampleItem", Common.disableExampleItem());

        loaded = true;
    }

    public static class Client {

        public Client(WhiteNoiseConfigSpec.Builder builder) {
        }

    }

    public static class Common {

        public final WhiteNoiseConfigSpec.BooleanValue debugEnabled;
		private final WhiteNoiseConfigSpec.BooleanValue disableExampleItem;
		private final WhiteNoiseConfigSpec.IntValue exampleItemDurability;

        public Common(WhiteNoiseConfigSpec.Builder builder) {
            builder.push("General");

            debugEnabled = builder
                .worldRestart()
                .comment("Show debug info.")
                .define("debugEnabled", false);

            builder.push("Items");

            disableExampleItem = builder.comment("Disable example item.")
                .clientRestart()
                .define("disableExampleItem", false);
            exampleItemDurability = builder.comment("Example item durability.")
                .clientRestart()
                .defineInRange("exampleItemDurability", 15, 1, 100);
        }

        public static boolean debugEnabled() {
            return COMMON.debugEnabled.get();
        }

        public static boolean disableExampleItem() {
            if (loaded) {
                return COMMON.disableExampleItem.get();
            }

            return false;
        }

        public static int exampleItemDurability() {
            return COMMON.exampleItemDurability.get();
        }

    }

}

