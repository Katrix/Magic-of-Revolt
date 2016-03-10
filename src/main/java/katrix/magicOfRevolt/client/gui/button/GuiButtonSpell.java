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

import katrix.magicOfRevolt.client.spell.SpellHexTextureRegistry;
import katrix.magicOfRevolt.spell.Spell;
import katrix.magicOfRevolt.spell.container.SpellContainerHexagon;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiButtonSpell extends GuiButtonNgon {
	
	private final SpellContainerHexagon spellContainer;
	private final int hexX;
	private final int hexY;
	
	public GuiButtonSpell(int buttonId, int x, int y, int radius, String buttonText, int hexX, int hexY, SpellContainerHexagon spellContainer) {
		super(buttonId, x, y, radius, buttonText);
		this.spellContainer = spellContainer;
		this.hexX = hexX;
		this.hexY = hexY;
	}
	
	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY) {
		if (visible) {
			FontRenderer fontrenderer = mc.fontRendererObj;
			mc.getTextureManager().bindTexture(BUTTON_TEXTURE);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			hovered = mouseOver(mouseX, mouseY);
			@SuppressWarnings("unused")
			int hover = getHoverState(hovered);
			GlStateManager.enableBlend();
			GlStateManager.tryBlendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
			GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			//drawNGon(0xFFFFFFFF);
			drawTexturedNGon(0, 0);
			mc.getTextureManager().bindTexture(getSpellTexture());
			drawTexturedNGon(0, 0);
			

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

			drawCenteredString(fontrenderer, displayString, xPosition + width / 2, yPosition + (height - 8) / 2, j);
		}
	}
	
	@Override
	protected void mouseDragged(Minecraft mc, int mouseX, int mouseY) {
		super.mouseDragged(mc, mouseX, mouseY);
		setSpell(null); //TODO: Make gui to change spell
	}
	
	private void setSpell(Spell spell) {
		spellContainer.setSpellAtPoint(spell, hexX, hexY);
	}
	
	private Spell getSpell() {
		return spellContainer.getSpellAtPoint(hexX, hexY);
	}
	
	private ResourceLocation getSpellTexture() {
		Spell spell = getSpell();
		return SpellHexTextureRegistry.getTexture(spell.getClass());
	}
}
