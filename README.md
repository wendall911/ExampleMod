# MultiLoader Template

This project is dervied directly from the excellent
[MultiLoader-Template(https://github.com/jaredlll08/MultiLoader-Template)

This project provides a Gradle project template that can compile Minecraft mods
for multiple modloaders using a common project for the sources. This project
does not require any third party libraries or dependencies. But does implement
WhiteNoise library as an embedded jarJar as an example. If you have any
questions or want to discuss the project, please join our
[Discord](https://discord.gg/c4y8JVxFVj).

## Getting Started

### IntelliJ IDEA
This guide will show how to import the MultiLoader Template into IntelliJ IDEA.
The setup process is roughly equivalent to setting up the modloaders
independently and should be very familiar to anyone who has worked with their MDKs.

1. Copy the repository structure to a new directory for the project name.
  1. Not recommended to clone or fork this repository, as it is better to do an
    initial commit with a clean repository history in any new project.
1. Configure the project by setting the properties in the `gradle.properties`
    file. NOTE: mod_name should match the folder name of your project, or else
    IDEA may complain.

**NOTE**: The following could probably be trivially scripted, or you can use
refactoring in IDEA to do this.

1. Relocate the following files and folders to match your ${mod_id}
    1. In the Common directory:
        1. In Common/src/main/resources:
        1. Rename files and replace examplemod with your `${mod_id}`
    1. mv Common/src/main/java/examplemod Common/src/main/java/`${mod_id}`
    1. Rename ExampleMod.java to ${mod_name}.java
        1. Change the class to ${mod_name}
        1. Update MODID and MOD_NAME to reflect your ${mod_id} and ${mod_name}
        1. relocate packages from examplemod to ${mod_id} in all of the .java files in Common/src/main/java
    1. In Fabric directory:
        1. In Fabric/src/main/resources:
            1. Rename files and replace examplemod with your `${mod_id}`
        1. mv Fabric/src/main/java/examplemod Fabric/src/main/java/`${mod_id}`
        1. rename ExampleModFabric.java to `${mod_name}`Fabric.java
            1. Change the class to `${mod_name}`Fabric
        1. rename ExampleModFabricClient.java to `${mod_name}`FabricClient.java
            1. Change the package locations from examplemod to ${mod_id}
            1. Change the class to `${mod_name}`FabricClient
        1. In FabricConfigInitializer.java, change ExampleMod to `${mod_name}`
        1. Relocate packages from examplemod to `${mod_id}` in all of the .java files in Fabric/src/main/java
    1. In NeoForge directory:
        1. mv NeoForge/src/main/java/examplemod NeoForge/src/main/java/`${mod_id}`
        1. rename ExampleModNeoForge.java to `${mod_name}`NeoForge.java
            1. Note that for 1.20.1 template, this is actually using Forge, but for
               the purpose of cherry-picking backports, it is far simpler to have paths match.
        1. Change the class to `${mod_name}`NeoForge
        1. Relocate packages from examplemod to `${mod_id}` in all of the .java files in Fabric/src/main/java
1. Open the template's root folder as a new project in IDEA. This is the folder
    that contains this README.md file and the gradlew executable.
1. If your default JVM/JDK is not Java 21 you will encounter an error when
    opening the project. This error is fixed by going to `File > Settings >
    Build, Execution, Deployment > Build Tools > Gradle > Gradle JVM` and
    changing the value to a valid Java 21 JVM. You will also need to set the
    Project SDK to Java 21. This can be done by going to `File > Project
    Structure > Project SDK`. Once both have been set open the Gradle tab in
    IDEA and click the refresh button to reload the project.
1. Open your Run/Debug Configurations. Under the `Application` category there
    should now be options to run Fabric and NeoForge projects. Select one of the
    client options and try to run it.
    1. Assuming you were able to run the game in this step, your workspace should now be set up.

## Development Guide
When using this template the majority of your mod should be developed in the
`Common` project. The `Common` project is compiled against the vanilla game and
is used to hold code that is shared between the different loader-specific
versions of your mod. The `Common` project has no knowledge or access to
ModLoader specific code, apis, or concepts. Code that requires something from a
specific loader must be done through the project that is specific to that
loader, such as the `Fabric` or `NeoForge` projects.

Loader specific projects such as the `Fabric` and `NeoForge` project are used
to load the `Common` project into the game. These projects also define code
that is specific to that loader. Loader specific projects can access all the
code in the `Common` project. It is important to remember that the `Common`
project can not access code from loader specific projects.
