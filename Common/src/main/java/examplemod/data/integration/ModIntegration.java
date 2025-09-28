package examplemod.data.integration;

import net.minecraft.resources.ResourceLocation;

import static technology.roughness.whitenoise.util.ResourceLocationHelper.loc;

public final class ModIntegration {

    public static final String HOMEOSTATIC_MODID = "homeostatic";

    public static ResourceLocation homeostaticLoc(String name) {
        return loc(HOMEOSTATIC_MODID, name);
    }

}

