/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.client.gui.button;

import katrix.magicOfRevolt.helper.LogHelper;
import katrix.magicOfRevolt.lib.LibMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiButtonHex extends GuiButton {

	protected static final ResourceLocation buttonTextures = new ResourceLocation(LibMod.MODID.toLowerCase(), "textures/spell/hexagon.png");

	public GuiButtonHex(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText) {
		super(buttonId, x, y, widthIn, heightIn, buttonText);
	}
	
	public GuiButtonHex(int buttonId, int x, int y, int radius, String buttonText) {
		super(buttonId, x, y, radius, radius, buttonText);
	}

	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY) {
		if (visible) {
			FontRenderer fontrenderer = mc.fontRendererObj;
			mc.getTextureManager().bindTexture(buttonTextures);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			hovered = mouseX >= xPosition && mouseY >= yPosition && mouseX < xPosition + width && mouseY < yPosition + height; //TODO
			int i = getHoverState(hovered);
			GlStateManager.enableBlend();
			GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
			GlStateManager.blendFunc(770, 771);
			this.drawTexturedModalRect(xPosition, yPosition, 0, 46 + i * 20, width / 2, height); //TODO
			this.drawTexturedModalRect(xPosition + width / 2, yPosition, 200 - width / 2, 46 + i * 20, width / 2, height); //TODO
			mouseDragged(mc, mouseX, mouseY);
			int j = 14737632;

			if (packedFGColour != 0) {
				j = packedFGColour;
			}
			else if (!enabled) {
				j = 10526880;
			}
			else if (hovered) {
				j = 16777120;
			}
			
			LogHelper.info(mouseOver(mouseX, mouseY));

			drawCenteredString(fontrenderer, displayString, xPosition + width / 2, yPosition + (height - 8) / 2, j); //TODO
			
			/*
			int[][] corners = getCorners();
			List<Integer> list = new ArrayList<>();
			for(int x = 0; x < corners.length; x++) {
				for(int y = 0; y < corners[x].length; y++) {
					LogHelper.info("Corner: " + x + " X or Y: " + y + " Coord: " + corners[x][y]);
				}
			}
			*/
		}
	}

	@Override
	public boolean mousePressed(Minecraft mc, int mouseX, int mouseY) {
		return enabled && visible && mouseX >= xPosition && mouseY >= yPosition && mouseX < xPosition + width && mouseY < yPosition + height;
	}

	public boolean mouseOver(int mouseX, int mouseY) {
		int[][] corners = getCorners();
		for(int x = 0; x < corners.length; x++) {
			for(int y = 0; y < corners[x].length; y++) {
				int cornerX = corners[x][0];
				int cornerY = corners[x][1];
				int oppositeCornerX = corners[wrapSide(x - 3)][0];
				int oppositeCornerY = corners[wrapSide(x - 3)][1];
				if(mouseX >= cornerX && mouseY >= cornerY && mouseX < oppositeCornerX && mouseY < oppositeCornerY) {
					return false;
				}
			}
		}
		return true;
	}
	
	private int wrapSide(int i) {
		int wrap = 6;
		i = i % wrap;
		return i;
	}
	
	public int[][] getCorners() {
		int[][] corners = new int[6][2];
		int centerX = xPosition + width / 2;
		int centerY = yPosition + height / 2;
		double orientationAngle = 0.5F;

		for (int i = 0; i < corners.length; i++) {
			double angle = 2F * Math.PI * (i + orientationAngle) / 6;
			double offsetX = width * Math.cos(angle);
			double offsetY = height * Math.sin(angle);
			int cornerX = (int)(centerX + offsetX);
			int cornerY = (int)(centerY + offsetY);
			corners[i][0] = cornerX;
			corners[i][1] = cornerY;
		}

		return corners;
	}
}
