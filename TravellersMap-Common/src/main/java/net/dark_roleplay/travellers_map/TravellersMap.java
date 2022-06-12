package net.dark_roleplay.travellers_map;

import net.dark_roleplay.just_utilities.api.events.Events;
import net.dark_roleplay.just_utilities.api.events.IEventRegistrar;
import net.dark_roleplay.just_utilities.api.events.client.HudPostRenderEvent;
import net.dark_roleplay.travellers_map.ui.ThemeManager;
import net.dark_roleplay.travellers_map.ui.compass.HudCompass;
import net.minecraft.client.Minecraft;
import net.minecraft.server.packs.resources.ReloadableResourceManager;
import org.kohsuke.MetaInfServices;

@MetaInfServices(IEventRegistrar.class)
public class TravellersMap implements IEventRegistrar {

	private static final HudCompass COMPASS = new HudCompass();

	@Override
	public void registerEvents() {
		Events.HUD_POST_RENDER.subscribe(this::hudPostRenderListener);
		Events.CLIENT_INIT.subscribe(this::clientInitListener);
	}

	public void clientInitListener(Void vd){
		if(Minecraft.getInstance().getResourceManager() instanceof ReloadableResourceManager rel){
			rel.registerReloadListener(new ThemeManager());
		}
	}

	public void hudPostRenderListener(HudPostRenderEvent event){
		COMPASS.render(event.poseStack(), event.width(), event.height(), event.partialTicks());
	}
}
