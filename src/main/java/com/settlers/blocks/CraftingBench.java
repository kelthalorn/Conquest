package com.settlers.blocks;

import com.settlers.SettlersMod;
import com.settlers.tile.CraftingBenchTileEntity;
import com.settlers.utils.contants.Constants;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class CraftingBench extends BlockContainer implements ITileEntityProvider {

    protected CraftingBench() {
        super(Material.IRON);
        setUnlocalizedName(Constants.MOD_ID + "." + Constants.CRAFTINGBENCH_RESOURCENAME);
        setRegistryName("craftingBenchBlock");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new CraftingBenchTileEntity();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        if (worldIn.isRemote) {
            return true;
        }

        TileEntity te = worldIn.getTileEntity(pos);
        if (!(te instanceof CraftingBenchTileEntity)) {
            return false;
        }

        playerIn.openGui(SettlersMod.instance, Constants.CRAFTING_BENCH_GUI_ID, worldIn, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }
}
