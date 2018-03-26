package com.settlers.blocks;

import com.settlers.tile.CraftingBenchTileEntity;
import com.settlers.utils.contants.Constants;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {

    /*
     * Creating objects for all blocks in the mod.
     * References can be made to here.
     */
    @GameRegistry.ObjectHolder(Constants.MOD_ID + ":" + Constants.CRAFTINGBENCH_RESOURCENAME)
    public static CraftingBench craftingBench;

    /**
     * Private constructor to hide the implicit public one.
     */
    private ModBlocks()
    {
    }

    /**
     * Initates all the blocks. At the correct time.
     */
    public static void init(final IForgeRegistry<Block> registry) {
        craftingBench = new CraftingBench();

        registerBlocks(registry);
    }

    private static void registerBlocks(IForgeRegistry<Block> registry) {
        registry.register(craftingBench);
    }

    public static void registerItemBlock(final IForgeRegistry<Item> registry) {

        registry.register(new ItemBlock(ModBlocks.craftingBench).setRegistryName(ModBlocks.craftingBench.getRegistryName()));
    }

    public static void registerTileEntities() {

        GameRegistry.registerTileEntity(CraftingBenchTileEntity.class, Constants.MOD_ID + "_" + Constants.CRAFTINGBENCH_RESOURCENAME);
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {

        craftingBench.initModel();
    }
}
