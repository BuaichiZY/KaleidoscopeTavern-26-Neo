package com.github.ysbbbbbb.kaleidoscopetavern.datagen.misc;


import com.github.ysbbbbbb.kaleidoscopetavern.KaleidoscopeTavern;
import com.github.ysbbbbbb.kaleidoscopetavern.init.ModSounds;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

public class SoundDefinitionsGenerator extends SoundDefinitionsProvider {
    public SoundDefinitionsGenerator(PackOutput output) {
        super(output, KaleidoscopeTavern.MOD_ID);
    }

    @Override
    public void registerSounds() {
        SoundDefinition paddySound = definition().subtitle(subtitle("effect.vision"))
                .with(sound("effect/vision"));
        this.add(ModSounds.EFFECT_VISION.get(), paddySound);

        this.add(ModSounds.HOLDER_POP.get(), definition()
                .with(sound("block/holder_pop")));
        this.add(ModSounds.SHAKER_SHAKING.get(), definition()
                .with(sound("item/shaker/shaking_1"), sound("item/shaker/shaking_2"),
                        sound("item/shaker/shaking_3")));
        this.add(ModSounds.SHAKER_END.get(), definition()
                .with(sound("item/shaker/end")));
    }

    protected static SoundDefinition.Sound sound(final String name) {
        return sound(Identifier.fromNamespaceAndPath(KaleidoscopeTavern.MOD_ID, name));
    }

    protected static String subtitle(String subtitle) {
        return "subtitles.%s.%s".formatted(KaleidoscopeTavern.MOD_ID, subtitle);
    }
}
