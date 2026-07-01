package br.com.cbgmdias.brauncycle.block.entity;

import br.com.cbgmdias.brauncycle.BrauncycleMod;
import br.com.cbgmdias.brauncycle.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, BrauncycleMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<RecyclingStationBlockEntity>> RECYCLING_STATION_BE =
            BLOCK_ENTITIES.register("recycling_station_be", () ->
                    BlockEntityType.Builder.of(RecyclingStationBlockEntity::new,
                            ModBlocks.RECYCLING_STATION.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
