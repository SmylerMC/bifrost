package io.github.c3s;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=C3SMod.MODID, useMetadata=true)
public class C3SMod {
	
    public static final String MODID = "c3s";
    private static String name;
    private static String version;

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	C3SMod.version = event.getModMetadata().version;
    	C3SMod.name = event.getModMetadata().name;
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    }
    
    public static String getVersion() {
    	return C3SMod.version;
    }
    
    public static String getName() {
    	return C3SMod.name;
    }
    
}
