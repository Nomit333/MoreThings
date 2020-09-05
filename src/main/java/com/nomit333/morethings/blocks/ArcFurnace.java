package com.nomit333.morethings.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class ArcFurnace extends Block {

    public ArcFurnace() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(2.5f, 3.5f)
                .sound(SoundType.METAL)
                .harvestLevel(1)
                .setRequiresTool()
                .harvestTool(ToolType.PICKAXE));

    }
}

