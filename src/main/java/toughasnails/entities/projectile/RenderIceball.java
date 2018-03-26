package toughasnails.entities.projectile;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import toughasnails.api.item.TANItems;

@SideOnly(Side.CLIENT)
public class RenderIceball extends Render<EntityIceball>
{
    private final RenderItem renderItem;

    public RenderIceball(RenderManager renderManagerIn)
    {
        super(renderManagerIn);
        this.renderItem = Minecraft.getMinecraft().getRenderItem();
    }

    @Override
    public void doRender(EntityIceball entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(0.5F, 0.5F, 0.5F);
        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        this.renderItem.renderItem(this.getItemStack(entity), ItemCameraTransforms.TransformType.GROUND);
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
    
    public ItemStack getItemStack(EntityIceball entity)
    {
        return new ItemStack(TANItems.ice_charge, 1, 0);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityIceball entity)
    {
        return TextureMap.LOCATION_BLOCKS_TEXTURE;
    }
}