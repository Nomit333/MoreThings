package com.nomit333.morethings.items;

import com.nomit333.morethings.MoreThings;
import net.minecraft.item.Item;

public class ItemBase extends Item {
    public ItemBase() {
        super(new Item.Properties().group(MoreThings.TAB));
    }
}