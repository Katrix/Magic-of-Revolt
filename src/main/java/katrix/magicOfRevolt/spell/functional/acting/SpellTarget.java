/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.functional.acting;

import katrix.magicOfRevolt.spell.SpellDummy;
import katrix.magicOfRevolt.spell.SpellException;
import katrix.magicOfRevolt.spell.functional.SpellFunctional;
import katrix.magicOfRevolt.spell.object.SpellObject;
import net.minecraft.world.World;

public abstract class SpellTarget<T extends SpellObject> extends SpellFunctional {
	
	public static final int TARGET_INDEX = 0;
	
	public SpellTarget(World world) {
		super(world);
		setInput(new SpellDummy(world), TARGET_INDEX);
	}
	
	protected T getTarget() throws SpellException {
		return this.<T>getVariable(TARGET_INDEX);
	}
}
