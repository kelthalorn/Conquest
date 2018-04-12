package com.settlers.items;

import com.settlers.utils.Constants;
import net.minecraft.item.Item;

public class FirstItem extends Item {

    public FirstItem() {
        setRegistryName("firstitem");        // The unique name (within your mod) that identifies this item
        setUnlocalizedName(Constants.MODID + ".firstitem");     // Used for localization (en_US.lang)
    }

}
