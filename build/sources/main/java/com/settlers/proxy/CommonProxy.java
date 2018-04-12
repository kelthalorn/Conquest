package com.settlers.proxy;

import com.settlers.Config;
import com.settlers.ModDimensions;
import com.settlers.ModEntities;
import com.settlers.SettlersMod;
import com.settlers.blocks.*;
import com.settlers.blocks.itempedestal.PedestalBlock;
import com.settlers.blocks.itempedestal.PedestalTileEntity;
import com.settlers.blocks.constructor.ConstructorBlock;
import com.settlers.tilentity.ConstructorTileEntity;
import com.settlers.network.PacketHandler;
import com.settlers.utils.Constants;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.io.File;

@Mod.EventBusSubscriber
public class CommonProxy {

    // Config instance
    public static Configuration config;

    public void preInit(FMLPreInitializationEvent e) {
        File directory = e.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), Constants.CONFIG_FILENAME));
        Config.readConfig();

        // Initialize our packet handler. Make sure the name is
        // 20 characters or less!
        PacketHandler.registerMessages("modtut");

        // Initialization of blocks and items typically goes here:
        ModEntities.init();
        ModDimensions.init();

    }

    public void init(FMLInitializationEvent e) {
        NetworkRegistry.INSTANCE.registerGuiHandler(SettlersMod.instance, new GuiProxy());
    }

    public void postInit(FMLPostInitializationEvent e) {
        if (config.hasChanged()) {
            config.save();
        }
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
//        event.getRegistry().register(new StateTexturedBlock());
//        event.getRegistry().register(new BlinkingBlock());
//        event.getRegistry().register(new SimpleTexturedBlock());
        event.getRegistry().register(new MultiTexturedBlock());
//        event.getRegistry().register(new BakedModelBlock());
        event.getRegistry().register(new ConstructorBlock());
//        event.getRegistry().register(new ModelBlock());
        event.getRegistry().register(new PedestalBlock());

//        GameRegistry.registerTileEntity(BlinkingTileEntity.class, Constants.MODID + "_blinkingblock");
        GameRegistry.registerTileEntity(ConstructorTileEntity.class, Constants.MODID + "_testcontainerblock");
        GameRegistry.registerTileEntity(PedestalTileEntity.class, Constants.MODID + "_pedestalblock");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

//        event.getRegistry().register(new ItemBlock(ModBlocks.stateTexturedBlock).setRegistryName(ModBlocks.stateTexturedBlock.getRegistryName()));
//        event.getRegistry().register(new ItemBlock(ModBlocks.blinkingBlock).setRegistryName(ModBlocks.blinkingBlock.getRegistryName()));
//        event.getRegistry().register(new ItemBlock(ModBlocks.simpleTexturedBlock).setRegistryName(ModBlocks.simpleTexturedBlock.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.multiTexturedBlock).setRegistryName(ModBlocks.multiTexturedBlock.getRegistryName()));
//        event.getRegistry().register(new ItemBlock(ModBlocks.bakedModelBlock).setRegistryName(ModBlocks.bakedModelBlock.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.constructorBlock).setRegistryName(ModBlocks.constructorBlock.getRegistryName()));
//        event.getRegistry().register(new ItemBlock(ModBlocks.modelBlock).setRegistryName(ModBlocks.modelBlock.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.pedestalBlock).setRegistryName(ModBlocks.pedestalBlock.getRegistryName()));
    }

}
