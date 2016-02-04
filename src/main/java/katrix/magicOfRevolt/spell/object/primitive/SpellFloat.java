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

public class SpellFloat extends SpellObject implements ISpellVariable<SpellFloat, SpellFloat>, ICopyable<SpellFloat> {

	private float spellFloat;

	public SpellFloat() {
	}

	private SpellFloat(SpellFloat spellFloat) {
		this.spellFloat = spellFloat.spellFloat;
	}

	@Override
	public SpellFloat copy() {
		return new SpellFloat(this);
	}

	public float getFloat() {
		return spellFloat;
	}

	public void setFloat(float spellFloat) {
		this.spellFloat = spellFloat;
	}

	@Override
	public SpellFloat getVariable() {
		return this;
	}

	@Override
	public SpellFloat getSpell() {
		return this;
	}
}
