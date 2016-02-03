/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 * 
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.functional;

import katrix.magicOfRevolt.spell.object.SpellMOP;
import katrix.magicOfRevolt.spell.object.SpellObject;
import katrix.magicOfRevolt.spell.object.SpellVector;
import net.minecraft.world.World;

public class SpellRaytrace extends SpellFunctional {

	private SpellVector vec1;
	private SpellVector vec2;
	private static final int VEC1_INDEX = 0;
	private static final int VEC2_INDEX = 1;

	@Override
	public SpellObject execute() {
		return new SpellMOP().setMOP(world.rayTraceBlocks(vec1.getVector(), vec2.getVector(), false, false, true));
	}

	public SpellVector getInput1() {
		return vec1;
	}

	public void setInput1(SpellVector vec1) {
		this.vec1 = vec1;
		inputs.set(VEC1_INDEX, vec1);
	}

	public SpellVector getInput2() {
		return vec2;
	}

	public void setInput2(SpellVector vec2) {
		this.vec2 = vec2;
		inputs.set(VEC2_INDEX, vec2);
	}
}
