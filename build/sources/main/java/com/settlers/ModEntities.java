package com.settlers;

import com.settlers.entity.EntityWeirdZombie;
import com.settlers.entity.RenderWeirdZombie;
import com.settlers.utils.Constants;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModEntities {

    public static void init() {
        // Every entity in our mod has an ID (local to this mod)
        int id = 1;
        EntityRegistry.registerModEntity(new ResourceLocation(Constants.MODID, "weirdzombie"), EntityWeirdZombie.class, "WeirdZombie", id++, SettlersMod.instance, 64, 3, true, 0x996600, 0x00ff00);

        // We want our mob to spawn in Plains and ice plains biomes. If you don't add this then it will not spawn automatically
        // but you can of course still make it spawn manually
        EntityRegistry.addSpawn(EntityWeirdZombie.class, 100, 3, 5, EnumCreatureType.MONSTER, Biomes.PLAINS, Biomes.ICE_PLAINS);

        // This is the loot table for our mob
        LootTableList.register(EntityWeirdZombie.LOOT);
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        RenderingRegistry.registerEntityRenderingHandler(EntityWeirdZombie.class, RenderWeirdZombie.FACTORY);
    }
}
