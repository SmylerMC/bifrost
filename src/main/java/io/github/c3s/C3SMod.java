package io.github.c3s;

import org.apache.logging.log4j.Logger;

import io.github.c3s.proxy.AbstractModProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = C3SMod.MODID, useMetadata = true)
public class C3SMod {
	
    public static final String MODID = "c3s";
    
    private static String name;
    private static String version;

    public static Logger logger;
    
    /*
     * Proxy stuff
     * 
     * We will use a lot of client side only stuff, so we have to do as much things from there as possible
     * 
     * */
    private static final String CLIENT_PROXY_CLASS = "io.github.c3s.proxy.ClientModProxy";
	private static final String SERVER_PROXY_CLASS = "io.github.c3s.proxy.ServerModProxy";
    @SidedProxy(clientSide = C3SMod.CLIENT_PROXY_CLASS, serverSide = C3SMod.SERVER_PROXY_CLASS)
	public static AbstractModProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	C3SMod.version = event.getModMetadata().version;
    	C3SMod.name = event.getModMetadata().name;
        logger = event.getModLog();
        C3SMod.proxy.onPreInitialization(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    	C3SMod.proxy.onInitialization(event);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	C3SMod.proxy.onPostInitialization(event);
    }
    
    public static String getVersion() {
    	return C3SMod.version;
    }
    
    public static String getName() {
    	return C3SMod.name;
    }
    
}
