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
import katrix.magicOfRevolt.spell.object.SpellLiving;
import katrix.magicOfRevolt.spell.object.primitive.SpellInt;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class SpellSetFire extends SpellTarget<SpellLiving> {
	
	private static final int DURATION_INDEX = 1;

	public SpellSetFire(World world) {
		super(world);
		setInput(new SpellDummy(world), Side.RIGHT, DURATION_INDEX);
	}

	@Override
	public void execute() {
		super.execute();
		EntityLivingBase target = getTarget().getVariable().getLiving();
		int duration = this.<SpellInt>getVariable(DURATION_INDEX).getInteger();
		if (target != null && duration != 0) {
			target.setFire(duration);
		}
		else {
			fizzleParameters();
		}
	}
}
