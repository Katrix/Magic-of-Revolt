/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.block;

import katrix.magicOfRevolt.MagicOfRevolt;
import katrix.magicOfRevolt.lib.LibBlockName;
import katrix.magicOfRevolt.lib.LibGuiID;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockMagicCircle extends BlockRevoltBase {

	public BlockMagicCircle() {
		super(Material.ground);
		setUnlocalizedName(LibBlockName.MAGIC_CIRCLE);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		player.openGui(MagicOfRevolt.instance, LibGuiID.SPELLSLINGER_CREATION, world, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}
}
