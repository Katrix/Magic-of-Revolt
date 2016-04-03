/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell;

import katrix.magicOfRevolt.spell.object.primitive.SpellBoolean;
import net.minecraft.world.World;

public class SpellContinuousExecute extends Spell {

	public static final int CONDITION_INDEX = 0;

	public SpellContinuousExecute(World world) {
		super(world);
		setInput(new SpellDummy(world), CONDITION_INDEX);
	}

	@Override
	public boolean isExecuteComplete() {
		try {
			return this.<SpellBoolean>getVariable(CONDITION_INDEX).getBoolean();
		}
		catch(SpellException e) {
			return true;
		}
	}
}
