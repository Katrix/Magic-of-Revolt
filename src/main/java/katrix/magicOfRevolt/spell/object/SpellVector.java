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
import net.minecraft.util.Vec3;

public class SpellVector extends SpellObject implements ISpellVariable<SpellVector, SpellVector>, ICopyable<SpellVector> {

	private Vec3 vector;

	public SpellVector() {
	}

	private SpellVector(SpellVector vector) {
		this.vector = vector.vector;
	}

	@Override
	public SpellVector copy() {
		return new SpellVector(this);
	}

	public Vec3 getVector() {
		return vector;
	}

	public SpellVector setVector(Vec3 vector) {
		this.vector = vector;
		return this;
	}

	@Override
	public SpellVector getVariable() {
		return this;
	}

	@Override
	public SpellVector getSpell() {
		return this;
	}
}
