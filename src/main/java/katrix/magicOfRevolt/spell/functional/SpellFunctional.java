/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.functional;

import katrix.magicOfRevolt.spell.Spell;
import katrix.magicOfRevolt.spell.object.SpellObject;

public abstract class SpellFunctional extends Spell {

	@Override
	public Spell runSpell(Spell parent) {
		Spell retSpell = super.runSpell(parent);
		execute();
		return retSpell;
	}

	public abstract SpellObject execute();

}
