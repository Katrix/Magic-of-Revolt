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

public class SpellContinousExecute extends Spell {
	
	public static final int CONDITION_INDEX = 0;

	public SpellContinousExecute(World world) {
		super(world);
		setInput(new SpellDummy(world), Side.UP_RIGHT, CONDITION_INDEX);
	}
	
	public boolean isExecuteComplete() {
		return getVariable(SpellBoolean.class, CONDITION_INDEX).getBoolean();
	}
}
