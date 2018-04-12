package com.settlers.client.gui;

import com.settlers.inventory.ConstructorContainer;
import com.settlers.tilentity.ConstructorTileEntity;
import com.settlers.utils.Constants;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

public class ConstructorGui extends GuiContainer {
    public static final int WIDTH = 256;
    public static final int HEIGHT = 164;

    private static final ResourceLocation background = new ResourceLocation(Constants.MODID, "textures/gui/constructor_block.png");

    public ConstructorGui(ConstructorTileEntity tileEntity, ConstructorContainer container) {
        super(container);

        xSize = WIDTH;
        ySize = HEIGHT;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        super.renderHoveredToolTip(mouseX, mouseY);
    }
}
