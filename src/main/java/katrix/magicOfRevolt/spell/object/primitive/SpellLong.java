/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.object.primitive;

import katrix.magicOfRevolt.spell.ICopyable;
import katrix.magicOfRevolt.spell.ISpellVariable;
import katrix.magicOfRevolt.spell.object.SpellObject;

public class SpellLong extends SpellObject implements ISpellVariable<SpellLong, SpellLong>, ICopyable<SpellLong> {

	private long spellLong;

	public SpellLong() {
	}

	private SpellLong(SpellLong spellLong) {
		this.spellLong = spellLong.spellLong;
	}

	@Override
	public SpellLong copy() {
		return new SpellLong(this);
	}

	public long getLong() {
		return spellLong;
	}

	public void setLong(long spellLong) {
		this.spellLong = spellLong;
	}

	@Override
	public SpellLong getVariable() {
		return this;
	}

	@Override
	public SpellLong getSpell() {
		return this;
	}
}
