package br.com.cbgmdias.brauncycle.sound;

import br.com.cbgmdias.brauncycle.BrauncycleMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, BrauncycleMod.MOD_ID);

    public static final RegistryObject<SoundEvent> PURIFIED_DEER_AMBIENT = registerSound("purified_deer_ambient");
    public static final RegistryObject<SoundEvent> PURIFIED_DEER_HURT = registerSound("purified_deer_hurt");
    public static final RegistryObject<SoundEvent> PURIFIED_DEER_DEATH = registerSound("purified_deer_death");
    public static final RegistryObject<SoundEvent> CORRUPTED_DEER_AMBIENT = registerSound("corrupted_deer_ambient");
    public static final RegistryObject<SoundEvent> CORRUPTED_DEER_HURT = registerSound("corrupted_deer_hurt");
    public static final RegistryObject<SoundEvent> CORRUPTED_DEER_DEATH = registerSound("corrupted_deer_death");
    public static final RegistryObject<SoundEvent> CORRUPTED_DEER_ATTACK = registerSound("corrupted_deer_attack");

    private static RegistryObject<SoundEvent> registerSound(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(
                new ResourceLocation(BrauncycleMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
