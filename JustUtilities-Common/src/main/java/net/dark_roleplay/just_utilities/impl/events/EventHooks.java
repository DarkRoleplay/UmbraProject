package net.dark_roleplay.just_utilities.impl.events;

import com.mojang.blaze3d.vertex.PoseStack;
import net.dark_roleplay.just_utilities.api.events.Events;
import net.dark_roleplay.just_utilities.api.events.IEventRegistrar;
import net.dark_roleplay.just_utilities.api.events.client.HudPostRenderEvent;
import net.dark_roleplay.just_utilities.impl.util.ServiceUtil;
import net.minecraft.client.Minecraft;

import java.util.List;

public class EventHooks {

	public static void bootstrapHook(){
		List<IEventRegistrar> registrars = ServiceUtil.getServices(IEventRegistrar.class);
		for(IEventRegistrar reg : registrars) reg.registerEvents();
		Events.MOD_INIT.postEvent(null);
	}

	public static void clientInitHook(){
		Events.CLIENT_INIT.postEvent(null);
	}

	public static void hudRenderHook(PoseStack poseStack, float partialTicks){
		HudPostRenderEvent event = new HudPostRenderEvent();
		event.setPoseStack(poseStack);
		event.setPartialTicks(partialTicks);
		event.setDimensions(Minecraft.getInstance().getWindow().getGuiScaledWidth(), Minecraft.getInstance().getWindow().getGuiScaledHeight());
		Events.HUD_POST_RENDER.postEvent(event);
	}
}
