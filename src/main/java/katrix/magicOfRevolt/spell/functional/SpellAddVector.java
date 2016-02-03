/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.functional;

import katrix.magicOfRevolt.spell.object.SpellObject;
import katrix.magicOfRevolt.spell.object.SpellVector;

public class SpellAddVector extends SpellFunctional {

	private SpellVector vec1;
	private SpellVector vec2;
	private static final int VEC1_INDEX = 0;
	private static final int VEC2_INDEX = 1;

	@Override
	public SpellObject execute() {
		return vec1.copy().setVector(vec1.getVector().add(vec2.getVector()));
	}

	public SpellVector getVec1() {
		return vec1;
	}

	public void setVec1(SpellVector vec1) {
		this.vec1 = vec1;
		inputs.set(VEC1_INDEX, vec1);
	}

	public SpellVector getVec2() {
		return vec2;
	}

	public void setVec2(SpellVector vec2) {
		this.vec2 = vec2;
		inputs.set(VEC2_INDEX, vec2);
	}
}
