/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.functional.acting;

import katrix.magicOfRevolt.spell.object.SpellIBlockState;
import katrix.magicOfRevolt.spell.object.SpellObject;
import katrix.magicOfRevolt.spell.object.primitive.SpellVoid;

public class SpellSetBlock extends SpellBlockPosTarget {

	protected SpellIBlockState state;

	@Override
	public SpellObject execute() {
		if (target != null && state != null) {
			target.getWorld().setBlockState(target.getPos(), state.getBlockState());
		}
		else {
			fizzleParameters();
		}

		return SpellVoid.spell;
	}

	public SpellIBlockState getState() {
		return state;
	}


	public void setState(SpellIBlockState state) {
		this.state = state;
	}
}
