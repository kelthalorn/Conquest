package com.settlers.proxy;

import com.minecolonies.coremod.event.ClientEventHandler;
import com.minecolonies.structures.event.RenderEventHandler;
import com.settlers.blocks.ModBlocks;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientProxy extends CommonProxy{

    @Override
    public boolean isClient()
    {
        return true;
    }

    @Override
    public void registerEvents()
    {
        super.registerEvents();

        MinecraftForge.EVENT_BUS.register(new RenderEventHandler());
        MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
    }

    @Override
    public void registerEntityRendering()
    {

    }

    @Override
    public void registerTileEntityRendering()
    {

    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ModBlocks.initModels();
        //ModItems.initModels();
    }
}
