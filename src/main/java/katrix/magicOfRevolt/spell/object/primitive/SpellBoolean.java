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

public class SpellBoolean extends SpellObject implements ISpellVariable<SpellBoolean, SpellBoolean>, ICopyable<SpellBoolean> {

	private boolean spellBoolean;

	public SpellBoolean() {
	}

	private SpellBoolean(SpellBoolean spellBoolean) {
		this.spellBoolean = spellBoolean.spellBoolean;
	}

	@Override
	public SpellBoolean copy() {
		return new SpellBoolean(this);
	}

	public boolean getBoolean() {
		return spellBoolean;
	}

	public void setBoolean(boolean spellBoolean) {
		this.spellBoolean = spellBoolean;
	}

	@Override
	public SpellBoolean getVariable() {
		return this;
	}

	@Override
	public SpellBoolean getSpell() {
		return this;
	}
}
