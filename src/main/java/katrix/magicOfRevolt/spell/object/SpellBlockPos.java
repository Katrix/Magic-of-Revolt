/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.object;

import net.minecraft.util.BlockPos;

public class SpellBlockPos extends SpellObject {

	private BlockPos pos;

	public SpellBlockPos() {
	}

	private SpellBlockPos(SpellBlockPos pos) {
		this.pos = pos.pos;
	}

	@Override
	public SpellBlockPos copy() {
		return new SpellBlockPos(this);
	}

	public BlockPos getPos() {
		return pos;
	}

	public SpellBlockPos setPos(BlockPos pos) {
		this.pos = pos;
		return this;
	}
}
