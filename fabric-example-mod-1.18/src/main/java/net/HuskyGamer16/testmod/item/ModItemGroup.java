package net.HuskyGamer16.testmod.item;

import net.HuskyGamer16.testmod.testmod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;




public class ModItemGroup {
    public static final ItemGroup MYTHRIL = FabricItemGroupBuilder.build(new Identifier(testmod.MOD_ID,"mythril"),
            () -> new ItemStack(ModItems.MYTHRIL_INGOT));
}
