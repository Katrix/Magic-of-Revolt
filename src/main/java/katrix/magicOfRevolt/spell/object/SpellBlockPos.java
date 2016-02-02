/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 * 
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.object;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class SpellBlockPos extends SpellObject {
	
	private BlockPos pos;
	
	public SpellBlockPos(World world) {
		super(world);
	}

	public BlockPos getPos() {
		return pos;
	}

	public void setPos(BlockPos pos) {
		this.pos = pos;
	}
}
