package com.nomit333.morethings.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

public class CopperOre extends OreBlock {

    public CopperOre() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(1.5f, 2.0f)
                .sound(SoundType.STONE)
                .harvestLevel(1)
                .setRequiresTool()
                .harvestTool(ToolType.PICKAXE));
    }
}
