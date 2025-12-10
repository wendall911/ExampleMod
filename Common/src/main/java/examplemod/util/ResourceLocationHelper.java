package examplemod.util;

import net.minecraft.resources.Identifier;

import examplemod.ExampleMod;

public class ResourceLocationHelper extends technology.roughness.whitenoise.util.ResourceLocationHelper {

    public static Identifier prefix(String path) {
        return loc(ExampleMod.MODID, path);
    }

}
