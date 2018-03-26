package com.settlers.proxy;

import com.minecolonies.coremod.client.gui.WindowBuildTool;
import com.minecolonies.coremod.colony.CitizenDataView;
import net.minecraft.client.util.RecipeBookClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.RecipeBook;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;

/**
 * Basic proxy interface.
 */
public interface IProxy
{
    /**
     * Returns whether or not the proxy is client sided or server sided.
     *
     * @return true when client, false when server.
     */
    boolean isClient();

    /**
     * Method to register Tile Entities in.
     */
    void registerTileEntities();

    /**
     * Method to register events in.
     */
    void registerEvents();

    /**
     * Method to register Entities in.
     */
    void registerEntities();

    /**
     * Method to register entity rendering in.
     */
    void registerEntityRendering();

    /**
     * Method to register tile entity rendering in.
     */
    void registerTileEntityRendering();

    /**
     * Registers all block and item renderer.
     */
    void registerRenderer();

}
