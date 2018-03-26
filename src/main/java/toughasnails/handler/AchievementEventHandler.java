/*******************************************************************************
 * Copyright 2016, the Biomes O' Plenty Team
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * 
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package toughasnails.handler;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import toughasnails.api.item.TANItems;

public class AchievementEventHandler 
{
    /*@SubscribeEvent
    public void onItemPickup(PlayerEvent.ItemPickupEvent event)
    {
        ItemStack stack = event.pickedUp.getEntityItem();
        Item item = stack.getItem();
        
        Block block = Block.getBlockFromItem(item);
        IBlockState state = Block.getBlockFromItem(item).getStateFromMeta(item.getMetadata(stack));
        EntityPlayer player = event.player;

        if (item != null && item == TANItems.freeze_rod)
        {
            player.addStat(TANAchievements.into_ice);
        }
    }
    
    @SubscribeEvent
    public void onItemUsed(LivingEntityUseItemEvent.Finish event)
    {
        ItemStack stack = event.getItem();
        Item item = stack.getItem();

        if (event.getEntity() instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer)event.getEntityLiving();

            //Life or Death
            if (item == TANItems.lifeblood_crystal)
            {
                player.addStat(TANAchievements.life_or_death);
            }
        }
    }
    
    @SubscribeEvent
    public void onItemCrafted(ItemCraftedEvent event)
    {
        Item item = event.crafting.getItem();
        EntityPlayer player = event.player;
        
        //Thirst Quencher Achievement
        if (item != null && item == TANItems.canteen)
        {
            player.addStat(TANAchievements.thirst_quencher);
        }
        
        //Thirst Ender Achievement
        if (item != null && item == TANItems.fruit_juice)
        {
            player.addStat(TANAchievements.thirst_ender);
        }
        
        //Hot or Cold Achievement
        if (item != null && item == TANItems.thermometer)
        {
            player.addStat(TANAchievements.hot_or_cold);
        }
        
        //That Time Of Year
        if (item != null && item == TANItems.season_clock)
        {
            player.addStat(TANAchievements.that_time_of_year);
        }
    }*/

    /*@SubscribeEvent
    public void onPlayerUpdate(LivingUpdateEvent event)
    {
        if (!event.getEntity().worldObj.isRemote && event.getEntity() instanceof EntityPlayer)
        {
            EntityPlayerMP player = (EntityPlayerMP)event.getEntity();

            if (player.ticksExisted % 20 * 5 == 0)
            {
                if (!player.getStatFile().hasAchievementUnlocked(TANAchievements.year_one))
                {
                    
                }
            }
        }
    }*/
}
