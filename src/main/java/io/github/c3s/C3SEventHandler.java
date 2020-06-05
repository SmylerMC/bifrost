package io.github.c3s;

import net.minecraft.client.multiplayer.ServerData;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class C3SEventHandler {

	@SubscribeEvent
	public void onClientChat(ClientChatEvent event) {
		String message = event.getMessage();
		if(message.startsWith("/switch")) {
			String[] args = message.split(" ");
			if(args.length > 1) {
				C3SMod.logger.info("Debug server switch!");
				C3SMod.network.switchToServer(new ServerData("Test", args[1], false));
				event.setCanceled(true);
			} else {
				C3SMod.logger.error("Wrong /switch syntax");
			}
		}
	}
	
}
