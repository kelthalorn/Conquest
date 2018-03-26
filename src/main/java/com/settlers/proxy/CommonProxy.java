package com.settlers.proxy;

import com.settlers.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber
public class CommonProxy implements IProxy {

    /**
     * Called when registering blocks,
     * we have to register all our modblocks here.
     *
     * @param event the registery event for blocks.
     */
    @SubscribeEvent
    public static void registerBlocks(@NotNull final RegistryEvent.Register<Block> event)
    {
        ModBlocks.init(event.getRegistry());
    }

    /**
     * Called when registering items,
     * we have to register all our mod items here.
     *
     * @param event the registery event for items.
     */
    @SubscribeEvent
    public static void registerItems(@NotNull final RegistryEvent.Register<Item> event)
    {
        //ModItems.init(event.getRegistry());
        ModBlocks.registerItemBlock(event.getRegistry());
    }

    @Override
    public boolean isClient() {
        return false;
    }

    @Override
    public void registerTileEntities() {

        ModBlocks.registerTileEntities();
    }

    @Override
    public void registerEvents() {

    }

    @Override
    public void registerEntities() {

    }

    @Override
    public void registerEntityRendering() {

    }

    @Override
    public void registerTileEntityRendering() {

    }

    @Override
    public void registerRenderer() {

    }

}
