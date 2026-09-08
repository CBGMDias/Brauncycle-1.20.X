package br.com.cbgmdias.brauncycle.entity;

import br.com.cbgmdias.brauncycle.BrauncycleMod;
import br.com.cbgmdias.brauncycle.entity.custom.AbstractDeerEntity;
import br.com.cbgmdias.brauncycle.entity.custom.CorruptedDeerEntity;
import br.com.cbgmdias.brauncycle.entity.custom.PurifiedDeerEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, BrauncycleMod.MOD_ID);

    // Covers the torso and head; the decorative antlers extend above the hitbox.
    public static final RegistryObject<EntityType<PurifiedDeerEntity>> PURIFIED_DEER =
            ENTITY_TYPES.register("purified_deer", () -> EntityType.Builder
                    .of(PurifiedDeerEntity::new, MobCategory.CREATURE)
                    .sized(0.9F, 2.0F).build(BrauncycleMod.MOD_ID + ":purified_deer"));

    public static final RegistryObject<EntityType<CorruptedDeerEntity>> CORRUPTED_DEER =
            ENTITY_TYPES.register("corrupted_deer", () -> EntityType.Builder
                    .of(CorruptedDeerEntity::new, MobCategory.CREATURE)
                    .sized(0.9F, 2.0F).build(BrauncycleMod.MOD_ID + ":corrupted_deer"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
        eventBus.addListener(ModEntities::registerAttributes);
    }

    private static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(PURIFIED_DEER.get(), AbstractDeerEntity.createAttributes().build());
        event.put(CORRUPTED_DEER.get(), CorruptedDeerEntity.createAttributes().build());
    }
}
