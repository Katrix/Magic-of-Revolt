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
import katrix.magicOfRevolt.spell.object.SpellBlockPos;
import katrix.magicOfRevolt.spell.object.primitive.SpellFloat;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class SpellExplosion extends SpellTarget<SpellBlockPos> {
	
	public static final int STRENGTH_INDEX = 1;
	
	public SpellExplosion(World world) {
		super(world);
		setInput(new SpellDummy(world), STRENGTH_INDEX);
	}

	@Override
	public void execute() throws SpellException {
		super.execute();
		BlockPos pos = getTarget().getPos();
		float strength = this.<SpellFloat>getVariable(STRENGTH_INDEX).getFloat();
		if(!world.isRemote) {
			world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), strength, false);
		}
	}
}
