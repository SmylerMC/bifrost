package io.github.c3s.servers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraftforge.fml.client.FMLClientHandler;

/**
 * Ok, it's not really a network, but you get the idea
 * 
 * Some of this is probably temporary
 *
 */
public class ServerNetwork {

	//We will need this quite a lot, so might as well keep a reference
	private Minecraft minecraft;
	
	public ServerNetwork(Minecraft minecraft) {
		this.minecraft = minecraft;
	}
	
	public void switchToServer(ServerData server) {
		if(this.minecraft.world != null) {
			this.minecraft.world.sendQuittingDisconnectingPacket(); //Remove this if you want things to get funny
			//TODO Display an other gui screen instead of the main screen
			this.minecraft.addScheduledTask(() -> {
				FMLClientHandler.instance().connectToServer(null, server);
			});
		} else {
			//TODO Display or log an error
		}
	}
}
