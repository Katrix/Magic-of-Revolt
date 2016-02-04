/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.object;

import katrix.magicOfRevolt.spell.ICopyable;
import katrix.magicOfRevolt.spell.ISpellVariable;
import net.minecraft.util.MovingObjectPosition;

public class SpellMOP extends SpellObject implements ISpellVariable<SpellMOP, SpellMOP>, ICopyable<SpellMOP> {

	private MovingObjectPosition mop;

	public SpellMOP() {
	}

	private SpellMOP(SpellMOP vector) {
		mop = vector.mop;
	}

	@Override
	public SpellMOP copy() {
		return new SpellMOP(this);
	}

	public MovingObjectPosition getMOP() {
		return mop;
	}

	public SpellMOP setMOP(MovingObjectPosition mop) {
		this.mop = mop;
		return this;
	}

	@Override
	public SpellMOP getVariable() {
		return this;
	}

	@Override
	public SpellMOP getSpell() {
		return this;
	}
}
