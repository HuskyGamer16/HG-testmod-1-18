package net.HuskyGamer16.testmod.block;

import net.HuskyGamer16.testmod.block.custom.ModAnvilBlock;
import net.HuskyGamer16.testmod.block.custom.SpeedyBlock;
import net.HuskyGamer16.testmod.item.ModItemGroup;
import net.HuskyGamer16.testmod.testmod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Modblocks {

    public static final Block MYTHRIL_BLOCK = registerBlock("mythril_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemGroup.MYTHRIL);
    public static final Block MYTHRIL_RAW_BLOCK = registerBlock("mythril_raw_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MYTHRIL);
    public static final Block MYTHRIL_ORE = registerBlock("mythril_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MYTHRIL);
    public static final Block MYTHRIL_ORE_DEEPSLATE = registerBlock("mythril_deepslate_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MYTHRIL);
    public static final Block MYTHRIL_ORE_NETHERRACK = registerBlock("mythril_nether_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MYTHRIL);
    public static final Block MYTHRIL_ORE_ENDSTONE = registerBlock("mythril_endstone_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MYTHRIL);
    public static final PillarBlock MYTHRIL_INFUSED_OAK_LOG = (PillarBlock) registerBlock("mythril_infused_oak_log",
            new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(4f).requiresTool()), ModItemGroup.MYTHRIL);
    public static final Block MYTHRIL_INFUSED_OAK_LEAVES = registerBlock("mythril_infused_oak_leaves",
            new Block(FabricBlockSettings.of(Material.LEAVES).strength(4f).requiresTool()), ModItemGroup.MYTHRIL);
    public static final Block SPEEDY = registerBlock("speedy_block",
            new SpeedyBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ItemGroup.MISC);
    /*public static final Block MYTHRIL_LANTERN = registerBlock("mythril_lantern",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4f)),ModItemGroup.MYTHRIL);
    public static final Block MYTHRIL_CHAIN = registerBlock("mythril_chain",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4f)), ModItemGroup.MYTHRIL);*/
    public static final Block MYTHRIL_ANVIL = registerBlock("mythril_anvil",
            new ModAnvilBlock(FabricBlockSettings.of(Material.METAL).strength(2f).requiresTool()), ModItemGroup.MYTHRIL);
    public static final Block CHIPPED_MYTHRIL_ANVIL = registerBlock("chipped_mythril_anvil",
            new ModAnvilBlock(FabricBlockSettings.of(Material.METAL).strength(2f).requiresTool()), ModItemGroup.MYTHRIL);
    public static final Block DAMAGED_MYTHRIL_ANVIL = registerBlock("damaged_mythril_anvil",
            new ModAnvilBlock(FabricBlockSettings.of(Material.METAL).strength(2f).requiresTool()), ModItemGroup.MYTHRIL);

    private static Item registerBlockItem(String name, Block block, ItemGroup group){
        return Registry.register(Registry.ITEM, new Identifier(testmod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }
    private static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockItem(name,block,group);
        return Registry.register(Registry.BLOCK, new Identifier(testmod.MOD_ID,name),block);
    }
    public static void registerModBlocks(){
        testmod.LOGGER.info("Registering mod blocks for " + testmod.MOD_ID);
    }
}
