package io.github.c3s.proxy;

import io.github.c3s.C3SMod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

/**
 * The mod is client side, this will only be instantiated if we run on a physical server
 * NOTHING else than displaying a warning should be done from here
 *
 */
public class ServerModProxy extends AbstractModProxy {

	@Override
	public Side getSide() {
		return Side.SERVER;
	}

	@Override
	public void onPreInitialization(FMLPreInitializationEvent event) {
		C3SMod.logger.warn(C3SMod.getName() + "is being loaded on a dedicated server but is a client side mod!");
	}

	@Override
	public void onInitialization(FMLInitializationEvent event) {		
	}

	@Override
	public void onPostInitialization(FMLPostInitializationEvent event) {
	}

}
