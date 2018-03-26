package com.settlers.gui;

import com.settlers.container.CraftingBenchContainer;
import com.settlers.tile.CraftingBenchTileEntity;
import com.settlers.utils.contants.Constants;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

public class CraftingBenchGui extends GuiContainer {

    public static final int WIDTH = 180;
    public static final int HEIGHT = 152;

    private static final ResourceLocation background = new ResourceLocation(Constants.MOD_NAME, Constants.CRAFTING_BENCH_GUI_TEXTURES);

    public CraftingBenchGui(CraftingBenchTileEntity tileEntity, CraftingBenchContainer container) {

        super(container);

        xSize = WIDTH;
        ySize = HEIGHT;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
}
