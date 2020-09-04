package com.nomit333.morethings.util;

import com.nomit333.morethings.MoreThings;
import com.nomit333.morethings.armor.ModArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandlerArmor {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreThings.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Copper

    public static final RegistryObject<ArmorItem> COPPER_HELMET = ITEMS.register("copper_helmet", () ->
            new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.HEAD, new Item.Properties().group(MoreThings.TAB)));
    public static final RegistryObject<ArmorItem> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate", () ->
            new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.CHEST, new Item.Properties().group(MoreThings.TAB)));
    public static final RegistryObject<ArmorItem> COPPER_LEGGINGS = ITEMS.register("copper_leggings", () ->
            new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.LEGS, new Item.Properties().group(MoreThings.TAB)));
    public static final RegistryObject<ArmorItem> COPPER_BOOTS = ITEMS.register("copper_boots", () ->
            new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.FEET, new Item.Properties().group(MoreThings.TAB)));

    //Steel
    public static final RegistryObject<ArmorItem> STEEL_HELMET = ITEMS.register("steel_helmet", () ->
            new ArmorItem(ModArmorMaterial.STEEL, EquipmentSlotType.HEAD, new Item.Properties().group(MoreThings.TAB)));
    public static final RegistryObject<ArmorItem> STEEL_CHESTPLATE = ITEMS.register("steel_chestplate", () ->
            new ArmorItem(ModArmorMaterial.STEEL, EquipmentSlotType.CHEST, new Item.Properties().group(MoreThings.TAB)));
    public static final RegistryObject<ArmorItem> STEEL_LEGGINGS = ITEMS.register("steel_leggings", () ->
            new ArmorItem(ModArmorMaterial.STEEL, EquipmentSlotType.LEGS, new Item.Properties().group(MoreThings.TAB)));
    public static final RegistryObject<ArmorItem> STEEL_BOOTS = ITEMS.register("steel_boots", () ->
            new ArmorItem(ModArmorMaterial.STEEL, EquipmentSlotType.FEET, new Item.Properties().group(MoreThings.TAB)));
}
