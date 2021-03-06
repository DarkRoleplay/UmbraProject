package net.dark_roleplay.just_utilities.api.events;

import net.dark_roleplay.just_utilities.Constants;
import net.dark_roleplay.just_utilities.api.events.client.HudPostRenderEvent;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Events {

	/* --- Init Events --- */
	public static final Event<Void> MOD_INIT = Event.create(new ResourceLocation(Constants.MOD_ID, "mod_init"));

	/* --- Client Events --- */
	public static final Event<Void> CLIENT_INIT = Event.create(new ResourceLocation(Constants.MOD_ID, "client_init"));
	public static final Event<HudPostRenderEvent> HUD_POST_RENDER = Event.create(new ResourceLocation(Constants.MOD_ID, "hud_post_render"));

	/* --- Server Events --- */

	/* --- Common Events --- */

	public static class Event<E> {
		private ResourceLocation identifier;

		protected List<Consumer<E>> listeners = new ArrayList<>();

		private static <E> Event<E> create(ResourceLocation identifier){
			return new Event<E>(identifier);
		}

		private Event(ResourceLocation eventName){
			this.identifier = eventName;
		}

		public void subscribe(Consumer<E> listener){
			this.listeners.add(listener);
		}

		public void postEvent(E eventObject) {
			for(Consumer<E> listener : listeners)
				listener.accept(eventObject);
		}

		public ResourceLocation getIdentifier() {
			return identifier;
		}
	}
}
