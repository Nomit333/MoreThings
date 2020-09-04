package com.nomit333.morethings.armor;

import com.nomit333.morethings.MoreThings;
import com.nomit333.morethings.util.RegistryHandler;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ModArmorMaterial implements IArmorMaterial {
    // IRON =15 Diamond =32 Gold=7 leather 5
    COPPER(MoreThings.MOD_ID + ":copper",10, new int[] { 1,2,4,2 }, 18,
            SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.5F, () -> {
            return Ingredient.fromItems(RegistryHandler.COPPER_INGOT.get());
    }, 0),
    STEEL(MoreThings.MOD_ID + ":steel",10, new int[] { 4,5,7,3 }, 12,
    SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 1.0F, () -> {
        return Ingredient.fromItems(RegistryHandler.STEEL_INGOT.get());
    }, 0.25F);

    private static final int[] MAX_DAMAGE_ARRAY = new int[] {11, 16, 15, 13};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int entchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final Supplier<Ingredient> repairMaterial;
    private final float knockbackRestistance;

    ModArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int entchantability,
                     SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterial, float knockbackRestistance) {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.entchantability = entchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.repairMaterial = repairMaterial;
        this.knockbackRestistance = knockbackRestistance;
    }


    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.entchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.get();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float func_230304_f_() {
        return this.knockbackRestistance;
    }
}
