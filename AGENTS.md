# AGENTS.md

## Language policy

- 默认使用简体中文回答。
- 除非我明确要求英文，否则不要切换英文叙述。
- 代码、命令、报错、API 名称保持原文，不要强行翻译。
- 提问澄清时也使用中文。

## Project shape

- Single-root NeoForge ModDevGradle 2.x Java mod; use `gradlew.bat` from the repo root on Windows.
- Gradle wrapper is pinned to Gradle 9.4.1, and `build.gradle` requires the Java 25 toolchain.
- Mod id/name/version and Minecraft/NeoForge versions live in `gradle.properties`; `neoforge.mods.toml` expands those
  values during `processResources`, so do not hardcode metadata there.
- Main mod entrypoint is `src/main/java/com/github/ysbbbbbb/kaleidoscopetavern/KaleidoscopeTavern.java`; registry owners
  are mostly `src/main/java/com/github/ysbbbbbb/kaleidoscopetavern/init/Mod*.java`.

## Commands

- Compile/package checks: `./gradlew.bat compileJava`, `./gradlew.bat test`, `./gradlew.bat check`,
  `./gradlew.bat build`.
- ModDev run configs: `./gradlew.bat runClient`, `runClient2`, `runServer`, `runGameTestServer`, `runData`.
- Focused tests use standard Gradle filtering: `./gradlew.bat test --tests <pattern>`; `src/test` currently has no repo
  tests.
- There is no separate lint/typecheck task in this checkout; Java compilation is the practical type/API check.

## Generated and runtime files

- `runData` validates generated assets/data in `build/generated/resources/`; the complete checked-in resource set remains
  in `src/generated/resources/`, which `sourceSets.main.resources` includes while excluding `.cache/**`.
- `run/client`, `run/client2`, and `run/server` are local game directories and are ignored by git.
- `META-INF/accesstransformer.cfg` is declared from `neoforge.mods.toml`; if moving it, update both ModDevGradle/TOML
  wiring.
- `kaleidoscope_tavern.mixins.json` is registered and contains client animation, model and compatibility mixins.

## Current verification state

- `compileJava`, `runData`, `runGameTestServer`, and a development-client startup pass against Minecraft 26.2 and NeoForge 26.2.0.68.
- Local Gradle 9.6.1 with Temurin Java 25.0.4 is the verified build toolchain; the project wrapper remains at Gradle 9.4.1.
- `downloadAssets` is explicitly configured to use Java 25 so ModDev run tasks do not provision an auxiliary JDK 21.

## Toolchain gotchas

- This is NeoForge ModDevGradle, not Fabric Loom or ForgeGradle; use `neoForge { runs { ... } }` conventions.
- Parchment mappings are not visibly enabled in `gradle.properties` or `build.gradle`; do not assume Parchment parameter
  names or Javadocs are available.
- The source uses `net.minecraft.resources.Identifier` instead of the older `ResourceLocation` naming, matching the
  current mapped API in this checkout.
