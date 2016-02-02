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
	
	private IBlockState block;

	public SpellIBlockState(World world) {
		super(world);
	}

	public IBlockState getBlockState() {
		return block;
	}

	public void setBlockState(IBlockState state) {
		this.block = state;
	}
}
