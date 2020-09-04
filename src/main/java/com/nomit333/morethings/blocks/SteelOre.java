package com.nomit333.morethings.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

public class SteelOre extends OreBlock {

    public SteelOre() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(4.0f, 4.5f)
                .sound(SoundType.STONE)
                .harvestLevel(3)
                .setRequiresTool()
                .harvestTool(ToolType.PICKAXE));
    }
}
