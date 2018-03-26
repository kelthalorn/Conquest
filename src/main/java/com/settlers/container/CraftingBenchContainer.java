package com.settlers.container;

import com.settlers.tile.CraftingBenchTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.Nullable;

public class CraftingBenchContainer extends Container {

    private CraftingBenchTileEntity te;

    public CraftingBenchContainer(IInventory playerInventory, CraftingBenchTileEntity te) {

        this.te = te;
        addOwnSlots();
        addPlayerSlots(playerInventory);
    }

    private void addPlayerSlots(IInventory playerInventory) {

        for(int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                int x = 9 + col * 18;
                int y = row * 18 + 70;
                this.addSlotToContainer(new Slot(playerInventory, col + row * 9, x, y));
            }
        }

        for (int row = 0; row < 9; ++row) {
            int x = 9 + row * 18;
            int y = 58 + 70;
            this.addSlotToContainer(new Slot(playerInventory, row, x, y));
        }
    }

    private void addOwnSlots() {

        IItemHandler itemHandler = this.te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
        int x = 9;
        int y = 6;

        int indexSlot = 0;
        for (int i = 0; i < itemHandler.getSlots(); ++i) {

            addSlotToContainer(new SlotItemHandler(itemHandler, indexSlot, x, y));
            indexSlot++;
            x += 18;
        }
    }

    @Nullable
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index) {

        ItemStack itemStack = null;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();

            if (index < CraftingBenchTileEntity.SIZE) {
                if (!this.mergeItemStack(itemStack1, CraftingBenchTileEntity.SIZE, this.inventoryItemStacks.size(), true)) {
                    return null;
                }
            } else if (!this.mergeItemStack(itemStack1, 0, CraftingBenchTileEntity.SIZE, false)) {
                return null;
            }

            if (itemStack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }

        return itemStack;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return te.canInteractWith(player);
    }
}

