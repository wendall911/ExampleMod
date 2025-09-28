package examplemod.platform;

import examplemod.ExampleMod;
import examplemod.platform.services.IClientPlatform;
import examplemod.platform.services.IPlatform;

public class Services extends technology.roughness.whitenoise.platform.Services {

    public static final IClientPlatform CLIENT_PLATFORM = load(ExampleMod.LOGGER, IClientPlatform.class);
    public static final IPlatform PLATFORM = load(ExampleMod.LOGGER, IPlatform.class);

}
