package com.nomit333.morethings.blocks;

import com.nomit333.morethings.MoreThings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class BlockItemBase extends BlockItem {

    public BlockItemBase(Block block) {
        super(block, new Item.Properties().group(MoreThings.TAB));
    }
}
