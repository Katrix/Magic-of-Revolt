/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.object;

import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;

public class SpellIBlockState extends SpellObject {

	private IBlockState state;

	public SpellIBlockState(World world) {
		super(world);
	}

	private SpellIBlockState(SpellIBlockState state) {
		super(state);
		this.state = state.state;
	}

	@Override
	public SpellIBlockState copy() {
		return new SpellIBlockState(this);
	}

	public IBlockState getBlockState() {
		return state;
	}

	public SpellIBlockState setBlockState(IBlockState state) {
		this.state = state;
		return this;
	}
}
