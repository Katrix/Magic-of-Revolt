/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.functional.acting;

import katrix.magicOfRevolt.spell.ISpellVariable;
import katrix.magicOfRevolt.spell.object.SpellBlockPos;
import katrix.magicOfRevolt.spell.object.SpellIBlockState;
import katrix.magicOfRevolt.spell.object.SpellObject;
import katrix.magicOfRevolt.spell.object.primitive.SpellVoid;

public class SpellSetBlock extends SpellTarget<SpellBlockPos> {

	protected ISpellVariable<?, SpellIBlockState> state;
	private static final int STATE_INDEX = 1;

	@Override
	public SpellObject execute() {
		if (target != null && state != null) {
			world.setBlockState(target.getVariable().getPos(), state.getVariable().getBlockState());
		}
		else {
			fizzleParameters();
		}

		return SpellVoid.spell;
	}

	public ISpellVariable<?, SpellIBlockState> getState() {
		return state;
	}

	public void setState(ISpellVariable<?, SpellIBlockState> state) {
		this.state = state;
		inputs.set(STATE_INDEX, state.getSpell());
	}
}
