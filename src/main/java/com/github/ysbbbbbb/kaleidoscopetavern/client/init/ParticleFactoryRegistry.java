package com.github.ysbbbbbb.kaleidoscopetavern.client.init;

import com.github.ysbbbbbb.kaleidoscopetavern.KaleidoscopeTavern;
import com.github.ysbbbbbb.kaleidoscopetavern.client.particle.TapDripParticle;
import com.github.ysbbbbbb.kaleidoscopetavern.client.particle.IncenseParticle;
import com.github.ysbbbbbb.kaleidoscopetavern.client.particle.IncenseSuspendedParticle;
import com.github.ysbbbbbb.kaleidoscopetavern.client.particle.ButterflyIncenseLargeParticle;
import com.github.ysbbbbbb.kaleidoscopetavern.client.particle.FireflyIncenseLargeParticle;
import com.github.ysbbbbbb.kaleidoscopetavern.init.ModParticles;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@EventBusSubscriber(modid = KaleidoscopeTavern.MOD_ID, value = Dist.CLIENT)
public class ParticleFactoryRegistry {
    @SubscribeEvent
    public static void onRegisterParticleFactory(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ModParticles.WATER_TAP_DRIP.get(), TapDripParticle.WaterTapDripParticle::new);
        event.registerSpriteSet(ModParticles.LAVA_TAP_DRIP.get(), TapDripParticle.LavaTapDripParticle::new);
        event.registerSpriteSet(ModParticles.SAKURA_INCENSE_PARTICLE.get(), IncenseParticle.Provider::new);
        event.registerSpriteSet(ModParticles.PINE_INCENSE_PARTICLE.get(), IncenseParticle.Provider::new);
        event.registerSpriteSet(ModParticles.GINKGO_INCENSE_PARTICLE.get(), IncenseParticle.Provider::new);
        event.registerSpriteSet(ModParticles.SPORE_INCENSE_PARTICLE.get(), IncenseParticle.Provider::new);
        event.registerSpriteSet(ModParticles.CATNIP_INCENSE_PARTICLE.get(), IncenseParticle.Provider::new);
        event.registerSpriteSet(ModParticles.SNOW_INCENSE_PARTICLE.get(), IncenseParticle.Provider::new);
        event.registerSpriteSet(ModParticles.BUTTERFLY_INCENSE_PARTICLE.get(), IncenseParticle.Provider::new);
        event.registerSpriteSet(ModParticles.FIREFLY_INCENSE_PARTICLE.get(), IncenseParticle.Provider::new);
        event.registerSpriteSet(ModParticles.PINE_INCENSE_LARGE_PARTICLE.get(), IncenseSuspendedParticle.Provider::new);
        event.registerSpriteSet(ModParticles.GINKGO_INCENSE_LARGE_PARTICLE.get(), IncenseSuspendedParticle.Provider::new);
        event.registerSpriteSet(ModParticles.CATNIP_INCENSE_LARGE_PARTICLE.get(), IncenseSuspendedParticle.Provider::new);
        event.registerSpriteSet(ModParticles.SNOW_INCENSE_LARGE_PARTICLE.get(), IncenseSuspendedParticle.Provider::new);
        event.registerSpriteSet(ModParticles.BUTTERFLY_INCENSE_LARGE_PARTICLE.get(), ButterflyIncenseLargeParticle.Provider::new);
        event.registerSpriteSet(ModParticles.FIREFLY_INCENSE_LARGE_PARTICLE.get(), FireflyIncenseLargeParticle.Provider::new);
    }
}
