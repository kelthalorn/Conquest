package com.settlers;

import com.settlers.commands.TeleportCommand;
import com.settlers.proxy.CommonProxy;
import com.settlers.utils.Constants;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Constants.MODID, name = Constants.MODNAME, version = Constants.MODVERSION,
        dependencies = "required-after:forge@[13.19.0.2129,)", useMetadata = true)
public class SettlersMod {

    @SidedProxy(clientSide = Constants.CLIENT_SIDE_PROXY, serverSide = Constants.SERVER_SIDE_PROXY)
    public static CommonProxy proxy;

    @Mod.Instance
    public static SettlersMod instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        event.registerServerCommand(new TeleportCommand());
    }
}
