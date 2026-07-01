package br.com.cbgmdias.brauncycle.item;

import br.com.cbgmdias.brauncycle.BrauncycleMod;
import br.com.cbgmdias.brauncycle.item.custom.FuelItem;
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
            () -> new FuelItem(new Item.Properties(), 400));
    public static final RegistryObject<Item> PLASTIC_BAG = ITEMS.register("plastic_bag",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CARDBOARD_SHEET = ITEMS.register("cardboard_sheet",
            () -> new FuelItem(new Item.Properties(), 400));
    public static final RegistryObject<Item> ALUMINUM_FOIL_SCRAP = ITEMS.register("aluminum_foil_scrap",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CRUMPLED_BALL_OF_PAPER = ITEMS.register("crumpled_ball_of_paper",
            () -> new FuelItem(new Item.Properties(), 400));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
