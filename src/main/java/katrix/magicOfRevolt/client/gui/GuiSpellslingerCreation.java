/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.client.gui;

import katrix.magicOfRevolt.tile.TileMagicCircle;
import net.minecraft.client.gui.GuiScreen;

public class GuiSpellslingerCreation extends GuiScreen {

	private TileMagicCircle circle;

	public GuiSpellslingerCreation(TileMagicCircle circle) {
		setCircle(circle);
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

	public TileMagicCircle getCircle() {
		return circle;
	}

	public void setCircle(TileMagicCircle circle) {
		this.circle = circle;
	}
}
