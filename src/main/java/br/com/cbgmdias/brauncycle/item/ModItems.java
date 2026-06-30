package br.com.cbgmdias.brauncycle.item;

import br.com.cbgmdias.brauncycle.BrauncycleMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BrauncycleMod.MOD_ID);

    public static final RegistryObject<Item> PLASTIC_BOTTLE = ITEMS.register("plastic_bottle",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> METAL_CAN = ITEMS.register("metal_can",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GLASS_BOTTLE = ITEMS.register("glass_bottle",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NEWSPAPER = ITEMS.register("newspaper",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
