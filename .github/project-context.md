# ExampleMod — Project Context

## What This Is
A multi-loader mod template and personal starter for new wendall911 mods. Derived from
MultiLoader-Template (forked for faster maintenance). Contains instructions for creating
a new mod from scratch — see `README.md` for the full setup walkthrough.

This is not a deployable mod. It serves two purposes:
1. Starter scaffold for new mods
2. Playground for testing new Minecraft versions — updated first after WhiteNoise
   and Handbook are ready for a new version

## Project Structure
- `Common/` — shared mod logic, no modloader-specific APIs
- `NeoForge/` — NeoForge loader entry point (on 1.20.1 branch this is Forge)
- `Fabric/` — Fabric loader entry point

## Branch Convention
| Branch | Modloaders        |
|--------|-------------------|
| 1.20.1 | Forge + Fabric    |
| 1.21.1 | NeoForge + Fabric |
| 26.1   | NeoForge + Fabric |

## Dependencies
- WhiteNoise included as jarJar (NeoForge/Forge) and include (Fabric)
- Integration test mods: JEI, REI, ModMenu, Cloth Config

## Status
Fairly complete but needs consistency updates across maintained branches
(1.20.1, 1.21.1, 26.1). Agent-assisted update work is planned.
