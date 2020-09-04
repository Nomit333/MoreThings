package com.nomit333.morethings.util;

import com.nomit333.morethings.MoreThings;
import com.nomit333.morethings.tools.ModItemTier;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandlerTools {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreThings.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Copper
    public static final RegistryObject<SwordItem> COPPER_SWORD = ITEMS.register("copper_sword", () ->
            new SwordItem(ModItemTier.COPPER, 3, -2.0F, new Item.Properties().group(MoreThings.TAB)));
    public static final RegistryObject<PickaxeItem> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () ->
            new PickaxeItem(ModItemTier.COPPER, 1, -1.5F, new Item.Properties().group(MoreThings.TAB)));
    public static final RegistryObject<AxeItem> COPPER_AXE = ITEMS.register("copper_axe", () ->
            new AxeItem(ModItemTier.COPPER, 5, -3.1F, new Item.Properties().group(MoreThings.TAB)));
    public static final RegistryObject<ShovelItem> COPPER_SHOVEL = ITEMS.register("copper_shovel", () ->
            new ShovelItem(ModItemTier.COPPER, 0, -1.0F, new Item.Properties().group(MoreThings.TAB)));
    public static final RegistryObject<HoeItem> COPPER_HOE = ITEMS.register("copper_hoe", () ->
            new HoeItem(ModItemTier.COPPER, -1,0.0F, new Item.Properties().group(MoreThings.TAB)));
    //Steel
    public static final RegistryObject<SwordItem> STEEL_SWORD = ITEMS.register("steel_sword", () ->
            new SwordItem(ModItemTier.STEEL, 7, -2.8F, new Item.Properties().group(MoreThings.TAB)));
    public static final RegistryObject<PickaxeItem> STEEL_PICKAXE = ITEMS.register("steel_pickaxe", () ->
            new PickaxeItem(ModItemTier.STEEL, 2, -2.0F, new Item.Properties().group(MoreThings.TAB)));
    public static final RegistryObject<AxeItem> STEEL_AXE = ITEMS.register("steel_axe", () ->
            new AxeItem(ModItemTier.STEEL, 9, -3.8F, new Item.Properties().group(MoreThings.TAB)));
    public static final RegistryObject<ShovelItem> STEEL_SHOVEL = ITEMS.register("steel_shovel", () ->
            new ShovelItem(ModItemTier.STEEL, 1, -1.5F, new Item.Properties().group(MoreThings.TAB)));
    public static final RegistryObject<HoeItem> STEEL_HOE = ITEMS.register("steel_hoe", () ->
            new HoeItem(ModItemTier.STEEL, -2,0.0F, new Item.Properties().group(MoreThings.TAB)));

}
