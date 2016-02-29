/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.client.gui.button;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.PathIterator;

import org.lwjgl.opengl.GL11;

import katrix.magicOfRevolt.lib.LibMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;

public class GuiButtonNgon extends GuiButton {

	protected static final ResourceLocation buttonTextures = new ResourceLocation(LibMod.MODID.toLowerCase(), "textures/gui/hexagon.png");
	public final int cornerNum;
	protected Polygon ngon;

	public GuiButtonNgon(int buttonId, int x, int y, int radius, String buttonText) {
		this(buttonId, x, y, radius, radius, 6, buttonText);
	}

	public GuiButtonNgon(int buttonId, int x, int y, int radius, int corners, String buttonText) {
		this(buttonId, x, y, radius, radius, corners, buttonText);
	}

	public GuiButtonNgon(int buttonId, int x, int y, int sizeX, int sizeY, int corners, String buttonText) {
		super(buttonId, x, y, sizeX, sizeX, buttonText);
		cornerNum = corners;
		ngon = getNGon();
	}

	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY) {
		if (visible) {
			FontRenderer fontrenderer = mc.fontRendererObj;
			mc.getTextureManager().bindTexture(buttonTextures);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			hovered = mouseOver(mouseX, mouseY);
			getHoverState(hovered);
			GlStateManager.enableBlend();
			GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
			GlStateManager.blendFunc(770, 771);
			//drawNGon(0xFFFFFFFF);
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

	public void drawNGon(int color) {
		float a = (color >> 24 & 255) / 255.0F;
		float r = (color >> 16 & 255) / 255.0F;
		float g = (color >> 8 & 255) / 255.0F;
		float b = (color & 255) / 255.0F;

		GlStateManager.enableBlend();
		GlStateManager.disableTexture2D();
		GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
		GlStateManager.color(r, g, b, a);

		Tessellator tes = Tessellator.getInstance();
		WorldRenderer wr = tes.getWorldRenderer();

		wr.begin(GL11.GL_TRIANGLE_FAN, DefaultVertexFormats.POSITION_COLOR);
		for (PathIterator path = ngon.getPathIterator(null); !path.isDone(); path.next()) {
			float[] coords = new float[6];
			path.currentSegment(coords);
			int x = (int)coords[0];
			int y = (int)coords[1];
			wr.pos(x, y, zLevel).color(r, g, b, a).endVertex();
		}
		tes.draw();

		GlStateManager.enableTexture2D();
		GlStateManager.disableBlend();
	}

	public void drawTexturedNGon(int u, int v) {
		float fx = 1F / width;
		float fy = 1F / height;

		Tessellator tes = Tessellator.getInstance();
		WorldRenderer wr = tes.getWorldRenderer();

		wr.begin(GL11.GL_TRIANGLE_FAN, DefaultVertexFormats.POSITION_TEX);
		for (PathIterator path = ngon.getPathIterator(null); !path.isDone(); path.next()) {
			float[] coords = new float[6];
			path.currentSegment(coords);
			int x = (int)coords[0];
			int y = (int)coords[1];
			wr.pos(x, y, zLevel).tex((x - xPosition + u) * fx, (y - yPosition + v) * fy).endVertex();
		}
		tes.draw();
	}

	@Override
	public boolean mousePressed(Minecraft mc, int mouseX, int mouseY) {
		return enabled && visible && mouseOver(mouseX, mouseY);
	}

	public boolean mouseOver(int mouseX, int mouseY) {
		return ngon.contains(mouseX, mouseY);
	}

	protected int wrapSide(int i) {
		i = i % cornerNum;

		if (i < 0) {
			i += cornerNum;
		}

		return i;
	}

	public Point getCenter() {
		return new Point(xPosition + width / 2, yPosition + height / 2);
	}

	public Polygon getNGon() {
		Polygon ngon = new Polygon();
		Point center = getCenter();
		double orientationAngle = 0.0F;

		for (int i = 0; i < cornerNum; i++) {
			double angle = 2F * Math.PI * (i + orientationAngle) / cornerNum * -1;
			int offsetX = (int)(width / 2 * Math.cos(angle));
			int offsetY = (int)(height / 2 * Math.sin(angle));
			int cornerX = center.x + offsetX;
			int cornerY = center.y + offsetY;
			ngon.addPoint(cornerX, cornerY);
		}

		return ngon;
	}
}
