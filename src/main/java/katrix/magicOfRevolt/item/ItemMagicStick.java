/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.item;

import katrix.magicOfRevolt.block.RevoltBlock;
import katrix.magicOfRevolt.lib.LibItemName;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemMagicStick extends ItemRevoltBase {

	public ItemMagicStick() {
		super();
		setCreativeTab(CreativeTabs.tabTools);
		setUnlocalizedName(LibItemName.MAGIC_STICK);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
		BlockPos blockPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ()).offset(side);
		world.setBlockState(blockPos, RevoltBlock.magicCircle.getDefaultState());
		return super.onItemUse(stack, player, world, pos, side, hitX, hitY, hitZ);
	}
}
