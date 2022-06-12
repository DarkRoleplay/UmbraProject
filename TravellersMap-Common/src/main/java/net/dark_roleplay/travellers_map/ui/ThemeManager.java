package net.dark_roleplay.travellers_map.ui;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;

import java.util.Map;

public class ThemeManager extends SimpleJsonResourceReloadListener {
	public static ThemeManager instance;

	public static ThemeManager getInstance() {
		return instance;
	}

	private static final Gson GSON = (new GsonBuilder()).create();

	public ThemeManager() {
		super(GSON, "ui_themes");
		instance = this;
	}

	@Override
	protected void apply(Map<ResourceLocation, JsonElement> var1, ResourceManager var2, ProfilerFiller var3) {

	}
}
