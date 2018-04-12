package com.settlers.proxy;

import com.settlers.inventory.ConstructorContainer;
import com.settlers.client.gui.ConstructorGui;
import com.settlers.tilentity.ConstructorTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiProxy implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof ConstructorTileEntity) {
            return new ConstructorContainer(player.inventory, (ConstructorTileEntity) te);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof ConstructorTileEntity) {
            ConstructorTileEntity containerTileEntity = (ConstructorTileEntity) te;
            return new ConstructorGui(containerTileEntity, new ConstructorContainer(player.inventory, containerTileEntity));
        }
        return null;
    }
}
