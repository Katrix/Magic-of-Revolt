/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.object.primitive;

import katrix.magicOfRevolt.spell.object.SpellObject;

public class SpellInt extends SpellObject {

	private int spellInt;

	public SpellInt() {
	}

	private SpellInt(SpellInt spellInt) {
		this.spellInt = spellInt.spellInt;
	}

	@Override
	public SpellInt copy() {
		return new SpellInt(this);
	}

	public int getInteger() {
		return spellInt;
	}

	public void setInteger(int spellInt) {
		this.spellInt = spellInt;
	}
}
