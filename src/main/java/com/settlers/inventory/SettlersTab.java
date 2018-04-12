package com.settlers.inventory;

import com.settlers.utils.Constants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SettlersTab extends CreativeTabs {

    public static final CreativeTabs SETTLERS_BLOCKS = new SettlersTab()
    {
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem()
        {
            return new ItemStack(Item.getItemFromBlock(Blocks.COMMAND_BLOCK));
        }
    };

    public SettlersTab() {
        super(Constants.MODID);
        setBackgroundImageName("item_search.png");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(Items.CHEST_MINECART);
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }
}
