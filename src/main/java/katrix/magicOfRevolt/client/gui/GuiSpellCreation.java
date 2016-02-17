/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.client.gui;

import katrix.magicOfRevolt.spell.container.SpellContainerHexagon;
import net.minecraft.client.gui.GuiScreen;

public class GuiSpellCreation extends GuiScreen {

	private SpellContainerHexagon parent;

	public GuiSpellCreation(SpellContainerHexagon parent) {
		setParent(parent);
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

	public SpellContainerHexagon getParent() {
		return parent;
	}

	public void setParent(SpellContainerHexagon parent) {
		this.parent = parent;
	}
}
