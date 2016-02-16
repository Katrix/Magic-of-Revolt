/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.client.gui;

import katrix.magicOfRevolt.spell.SpellHexagon;
import net.minecraft.client.gui.GuiScreen;

public class GuiSpellCreation extends GuiScreen {

	private SpellHexagon parent;

	public GuiSpellCreation(SpellHexagon parent) {
		this.
		setParent(parent);
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

	public SpellHexagon getParent() {
		return parent;
	}

	public void setParent(SpellHexagon parent) {
		this.parent = parent;
	}
}
