package br.com.cbgmdias.brauncycle.item;

import br.com.cbgmdias.brauncycle.BrauncycleMod;
import br.com.cbgmdias.brauncycle.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BrauncycleMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> BRAUNCYCLE_TAB = CREATIVE_MODE_TABS.register("brauncycle_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PLASTIC_BOTTLE.get()))
                    .title(Component.translatable("creativetab.brauncycle_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.PLASTIC_BOTTLE.get());
                        pOutput.accept(ModItems.METAL_CAN.get());
                        pOutput.accept(ModItems.NEWSPAPER.get());
                        pOutput.accept(ModItems.GLASS_BOTTLE.get());
                        pOutput.accept(ModItems.PLASTIC_BAG.get());
                        pOutput.accept(ModItems.CARDBOARD_SHEET.get());
                        pOutput.accept(ModItems.ALUMINUM_FOIL_SCRAP.get());
                        pOutput.accept(ModItems.CRUMPLED_BALL_OF_PAPER.get());

                        pOutput.accept(ModItems.CARDBOARD_HELMET.get());
                        pOutput.accept(ModItems.CARDBOARD_CHESTPLATE.get());
                        pOutput.accept(ModItems.CARDBOARD_LEGGINGS.get());
                        pOutput.accept(ModItems.CARDBOARD_BOOTS.get());
                        pOutput.accept(ModItems.PURIFIED_DEER_SPAWN_EGG.get());
                        pOutput.accept(ModItems.CORRUPTED_DEER_SPAWN_EGG.get());

                        pOutput.accept(ModBlocks.CRUSHED_METAL_CAN_BLOCK.get());
                        pOutput.accept(ModBlocks.RECYCLING_STATION.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
