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

	private SpellVector input1;
	private SpellVector input2;

	@Override
	public SpellObject execute() {
		World world = input1.getWorld();
		return new SpellMOP(world).setMOP(world.rayTraceBlocks(input1.getVector(), input2.getVector(), false, false, true));
	}

	public SpellVector getInput1() {
		return input1;
	}

	public void setInput1(SpellVector input1) {
		this.input1 = input1;
	}

	public SpellVector getInput2() {
		return input2;
	}

	public void setInput2(SpellVector input2) {
		this.input2 = input2;
	}
}
