package com.nomit333.morethings.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class SteelBlock extends Block {

    public SteelBlock() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(15.0f, 10.0f)
                .sound(SoundType.METAL)
                .harvestLevel(2)
                .setRequiresTool()
                .harvestTool(ToolType.PICKAXE));
    }
}
