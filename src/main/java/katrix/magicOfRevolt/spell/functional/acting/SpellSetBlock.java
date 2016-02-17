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
import katrix.magicOfRevolt.spell.object.SpellBlockPos;
import katrix.magicOfRevolt.spell.object.SpellIBlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class SpellSetBlock extends SpellTarget<SpellBlockPos> {

	private static final int STATE_INDEX = 1;
	
	public SpellSetBlock(World world) {
		super(world);
		setInput(new SpellDummy(world), STATE_INDEX);
	}

	@Override
	public void execute() {
		super.execute();
		BlockPos target = getTarget().getVariable().getPos();
		IBlockState state = this.<SpellIBlockState>getVariable(STATE_INDEX).getBlockState();
		if (target != null && state != null) {
			world.setBlockState(target, state);
		}
		else {
			fizzleParameters();
		}
	}
}
