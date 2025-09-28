package examplemod.util;

import net.minecraft.resources.ResourceLocation;

import examplemod.ExampleMod;

public class ResourceLocationHelper extends technology.roughness.whitenoise.util.ResourceLocationHelper {

    public static ResourceLocation prefix(String path) {
        return loc(ExampleMod.MODID, path);
    }

}
