/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.functional.acting;

import katrix.magicOfRevolt.spell.object.SpellBlockPos;
import katrix.magicOfRevolt.spell.object.SpellObject;
import katrix.magicOfRevolt.spell.object.primitive.SpellVoid;
import net.minecraft.util.BlockPos;

public class SpellExplosion extends SpellTarget<SpellBlockPos> {

	@Override
	public SpellObject execute() {
		BlockPos pos = target.getVariable().getPos();
		world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 2F, false);
		return SpellVoid.spell;
	}
}
