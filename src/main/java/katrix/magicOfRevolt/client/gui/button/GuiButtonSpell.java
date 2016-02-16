/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.client.gui.button;

import katrix.magicOfRevolt.client.gui.GuiSpellCreation;
import katrix.magicOfRevolt.spell.Spell;
import net.minecraft.client.gui.GuiButton;

public class GuiButtonSpell extends GuiButton {
	
	@SuppressWarnings("unused")
	private GuiSpellCreation spellCreation;
	@SuppressWarnings("unused")
	private Spell spell;

	public GuiButtonSpell(GuiSpellCreation spellCreation, Spell spell, int x, int y) {
		super(0, x, y, 32, 32, "");
		this.spellCreation = spellCreation;
		this.spell = spell;
	}
}
