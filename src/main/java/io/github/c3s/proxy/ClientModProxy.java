package io.github.c3s.proxy;

import io.github.c3s.C3SEventHandler;
import io.github.c3s.C3SMod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

public class ClientModProxy extends AbstractModProxy {

	@Override
	public Side getSide() {
		return Side.CLIENT;
	}

	@Override
	public void onPreInitialization(FMLPreInitializationEvent event) {
		C3SMod.logger.debug("Pre-initializing " + C3SMod.getName());
	}

	@Override
	public void onInitialization(FMLInitializationEvent event) {
		C3SMod.logger.debug("Initializing " + C3SMod.getName());
		MinecraftForge.EVENT_BUS.register(new C3SEventHandler());
	}

	@Override
	public void onPostInitialization(FMLPostInitializationEvent event) {
		C3SMod.logger.debug("Post-initializing " + C3SMod.getName());
	}

}
