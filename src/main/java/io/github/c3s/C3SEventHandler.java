package io.github.c3s;

import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class C3SEventHandler {

	@SubscribeEvent
	public void onClientChat(ClientChatEvent event) {
		String message = event.getMessage();
		if(message.startsWith("/switch")) {
			C3SMod.logger.info("Debug server switch!");
			event.setCanceled(true);
		}
	}
	
}
