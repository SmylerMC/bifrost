package io.github.c3s.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

public abstract class AbstractModProxy {
	
	public abstract Side getSide();
	
	public abstract void onPreInitialization(FMLPreInitializationEvent event);
	
	public abstract void onInitialization(FMLInitializationEvent event);
	
	public abstract void onPostInitialization(FMLPostInitializationEvent event);
	
	public boolean isServer() {
		return this.getSide().equals(Side.SERVER);
	}
	
	public boolean isClient() {
		return this.getSide().equals(Side.CLIENT);
	}

}
