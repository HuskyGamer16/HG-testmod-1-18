package net.HuskyGamer16.testmod.util;


import net.HuskyGamer16.testmod.item.ModItems;
import net.HuskyGamer16.testmod.testmod;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class ModRegistries {
    public static void registerModStuffs(){
        registerFuels();
    }

    private static void registerFuels(){
        testmod.LOGGER.info("Registering Fuels for "+ testmod.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.SOLID_LAVA, 800);
    }
}
