package com.nomit333.morethings.tools;

import com.nomit333.morethings.util.RegistryHandler;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModItemTier implements IItemTier {

    COPPER(2, 200, 9.0F, 1.0F, 15, () -> {
            return Ingredient.fromItems(RegistryHandler.COPPER_INGOT.get());
    }),
    STEEL(2,1200,10.0F,4.0F,9, () ->{
        return Ingredient.fromItems(RegistryHandler.STEEL_INGOT.get());
    });


    private final int harvestlevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackdamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;

    ModItemTier(int harvestlevel, int maxUses, float efficiency, float attackdamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestlevel = harvestlevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackdamage = attackdamage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public float getEfficiency() {
        return efficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackdamage;
    }

    @Override
    public int getHarvestLevel() {
        return harvestlevel;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return repairMaterial.get();
    }
}
