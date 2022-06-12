package net.dark_roleplay.travellers_map.ui.compass;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;

public class HudCompass extends GuiComponent {

	public void render(PoseStack poseStack, int width, int height, float partialTicks) {
		drawString(poseStack, Minecraft.getInstance().font, "test", width/2, 50, 0xFFFFFF);
	}
}
