package net.HuskyGamer16.testmod.item;

import net.HuskyGamer16.testmod.item.custom.DowsingRodItem;
import net.HuskyGamer16.testmod.testmod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item MYTHRIL_INGOT = registerItem("mythril_ingot", new Item( new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    public static final Item MYTHRIL_nugget = registerItem("mythril_nugget", new Item( new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    public static final Item MYTHRIL_RAW = registerItem("mythril_raw", new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    public static final Item MYTHRIL_STAFF = registerItem("mythril_staff", new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    public static final Item MYTHRIL_STAFF_HEAD = registerItem("mythril_staff_head", new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    public static final Item DOWSING_ROD = registerItem("dowsing_rod",new DowsingRodItem(new FabricItemSettings().group(ModItemGroup.MYTHRIL).maxDamage(112)));
    public static final Item MYTHRIL_BOOTS = registerItem("mythril_boots", new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL).maxDamage(365)));
    public static final Item MYTHRIL_LEGGINGS = registerItem("mythril_leggings", new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL).maxDamage(400)));
    public static final Item MYTHRIL_CHESTPLATE = registerItem("mythril_chestplate", new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL).maxDamage(460)));
    public static final Item MYTHRIL_HELMET = registerItem("mythril_helmet", new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL).maxDamage(315)));
    public static final Item MYTHRIL_ANVIL = registerItem("mythril_anvil",new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    
    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(testmod.MOD_ID, name), item);
    }
    public static void registerModItems(){
        testmod.LOGGER.info("Registering mod items for "+ testmod.MOD_ID);
    }

}
