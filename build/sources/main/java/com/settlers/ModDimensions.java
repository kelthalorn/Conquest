package com.settlers;

import com.settlers.Config;
import com.settlers.dimension.TestWorldProvider;
import com.settlers.utils.Constants;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class ModDimensions {

    public static DimensionType testDimensionType;

    public static void init() {
        registerDimensionTypes();
        registerDimensions();
    }

    private static void registerDimensionTypes() {
        testDimensionType = DimensionType.register(Constants.MODID, "_test", Config.dimensionId, TestWorldProvider.class, false);
    }

    private static void registerDimensions() {
        DimensionManager.registerDimension(Config.dimensionId, testDimensionType);
    }

}
