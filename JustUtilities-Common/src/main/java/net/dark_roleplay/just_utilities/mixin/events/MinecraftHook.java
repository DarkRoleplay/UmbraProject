package net.dark_roleplay.just_utilities.mixin.events;

import com.mojang.blaze3d.vertex.PoseStack;
import net.dark_roleplay.just_utilities.impl.events.EventHooks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.main.GameConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftHook {

	@Inject(
			method = "<init>",
			at = @At(value = "TAIL")
	)
	private void render(GameConfig cfg, CallbackInfo callback) {
		EventHooks.clientInitHook();
	}
}
