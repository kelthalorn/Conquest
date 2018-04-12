package com.settlers.blocks;

import com.settlers.blocks.itempedestal.PedestalBlock;
import com.settlers.blocks.constructor.ConstructorBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

//    @GameRegistry.ObjectHolder("settlers:simpletexturedblock")
//    public static SimpleTexturedBlock simpleTexturedBlock;

    @GameRegistry.ObjectHolder("settlers:multitexturedblock")
    public static MultiTexturedBlock multiTexturedBlock;

//    @GameRegistry.ObjectHolder("settlers:modelblock")
//    public static ModelBlock modelBlock;
//
//    @GameRegistry.ObjectHolder("settlers:bakedmodelblock")
//    public static BakedModelBlock bakedModelBlock;
//
//    @GameRegistry.ObjectHolder("settlers:blinkingblock")
//    public static BlinkingBlock blinkingBlock;
//
    @GameRegistry.ObjectHolder("settlers:pedestalblock")
    public static PedestalBlock pedestalBlock;

    @GameRegistry.ObjectHolder("settlers:testcontainerblock")
    public static ConstructorBlock constructorBlock;

//    @GameRegistry.ObjectHolder("settlers:statetexturedblock")
//    public static StateTexturedBlock stateTexturedBlock;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
//        simpleTexturedBlock.initModel();
        multiTexturedBlock.initModel();
//        stateTexturedBlock.initModel();
//        modelBlock.initModel();
//        bakedModelBlock.initModel();
//        blinkingBlock.initModel();
        pedestalBlock.initModel();
        constructorBlock.initModel();
    }

    @SideOnly(Side.CLIENT)
    public static void initItemModels() {
        //bakedModelBlock.initItemModel();
    }
}
