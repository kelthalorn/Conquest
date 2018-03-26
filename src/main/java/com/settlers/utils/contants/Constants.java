package com.settlers.utils.contants;

/**
 * Some constants needed for the whole mod.
 */
public final class Constants
{
    public static final String MOD_ID                           = "settlers";
    public static final String MOD_NAME                         = "Settlers";
    public static final String VERSION                          = "@VERSION@";
    public static final String FORGE_VERSION                    = "required-after:Forge@[14.22.0.2459,)";
    public static final String MC_VERSION                       = "[1.12,1.13]";
    public static final String CLIENT_PROXY_LOCATION            = "com.conquest.proxy.ClientProxy";
    public static final String SERVER_PROXY_LOCATION            = "com.conquest.proxy.ServerProxy";
    public static final String CONFIG_GUI_LOCATION              = "com.conquest.client.gui.GuiFactory";
    public static final String PLAYER_PROPERTY_NAME             = MOD_ID + ".PlayerProperties";

    public static final String CRAFTINGBENCH_RESOURCENAME       = "craftingbenchblock";

    public static final int CRAFTING_BENCH_GUI_ID               = 1;
    public static final String CRAFTING_BENCH_GUI_TEXTURES      = "textures/gui/crafting_bench.png";

    /**
     * Private constructor to hide implicit public one.
     */
    private Constants()
    {
        /**
         * Intentionally left empty.
         */
    }
}
