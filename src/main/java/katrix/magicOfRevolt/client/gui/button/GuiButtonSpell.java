/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.client.gui.button;

import org.lwjgl.opengl.GL11;

import katrix.magicOfRevolt.container.ContainerHexagonSpellCreation;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;

public class GuiButtonSpell extends GuiButtonNgon {

	private final int hexX;
	private final int hexY;
	private ContainerHexagonSpellCreation container;

	public GuiButtonSpell(int buttonId, int x, int y, int radius, int hexX, int hexY, ContainerHexagonSpellCreation container) {
		super(buttonId, x, y, radius, "");
		this.container = container;
		this.hexX = hexX;
		this.hexY = hexY;
	}

	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY) {
		if(visible) {
			mc.getTextureManager().bindTexture(BUTTON_TEXTURE);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			hovered = mouseOver(mouseX, mouseY);
			int hoverState = getHoverState(hovered);
			GlStateManager.enableBlend();
			GlStateManager.tryBlendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
			GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			//mc.getTextureManager().bindTexture(getSpellTexture());
			drawNGon(0xFFFFFFFF);
			//drawTexturedNGon(0, 0);
			if(hoverState == 2) {
				drawNGon(0xFFFFFF08);
			}

			mouseDragged(mc, mouseX, mouseY);
		}
	}

	@Override
	public boolean mousePressed(Minecraft mc, int mouseX, int mouseY) {
		if(super.mousePressed(mc, mouseX, mouseY)) {
			container.selectHex(hexX, hexY);
			return true;
		}
		else return false;
	}
}
