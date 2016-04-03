/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.block;

import katrix.magicOfRevolt.MagicOfRevolt;
import katrix.magicOfRevolt.lib.LibBlockName;
import katrix.magicOfRevolt.lib.LibGuiID;
import katrix.magicOfRevolt.spell.SpellOutput;
import katrix.magicOfRevolt.spell.functional.acting.SpellAddMotion;
import katrix.magicOfRevolt.spell.functional.acting.SpellExplosion;
import katrix.magicOfRevolt.spell.functional.acting.SpellTarget;
import katrix.magicOfRevolt.spell.object.SpellBlockPos;
import katrix.magicOfRevolt.spell.object.SpellEntity;
import katrix.magicOfRevolt.spell.object.SpellLiving;
import katrix.magicOfRevolt.spell.object.primitive.SpellFloat;
import katrix.magicOfRevolt.spell.variable.SpellVectorFromLook;
import katrix.magicOfRevolt.tile.TileMagicCircle;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockMagicCircle extends BlockRevoltBase implements ITileEntityProvider {

	public BlockMagicCircle() {
		super(Material.web);
		setUnlocalizedName(LibBlockName.MAGIC_CIRCLE);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		if(player.isSneaking()) {
			getTile(world, pos).activate();
		}
		else {
			SpellBlockPos spellPos = new SpellBlockPos(world);
			spellPos.setPos(pos);

			SpellFloat spellFloat = new SpellFloat(world);
			spellFloat.setFloat(3F);

			SpellExplosion explode = new SpellExplosion(world);
			explode.setInput(spellFloat, SpellExplosion.STRENGTH_INDEX).setInput(spellPos, SpellTarget.TARGET_INDEX);

			SpellLiving living = new SpellLiving(world);
			living.setLiving(player);

			SpellVectorFromLook vector = new SpellVectorFromLook(world);
			vector.setInput(living, SpellVectorFromLook.LIVING_INDEX);

			SpellEntity entity = new SpellEntity(world);
			entity.setEntity(player);

			SpellAddMotion motion = new SpellAddMotion(world);
			motion.setInput(vector, SpellAddMotion.VECTOR_INDEX).setInput(entity, SpellTarget.TARGET_INDEX);

			SpellOutput output = new SpellOutput(world);
			output.setInput(explode, 1).setInput(motion, 4);

			getTile(world, pos).setSpellAtPoint(output, 2, 3);
		}

		player.openGui(MagicOfRevolt.instance, LibGuiID.SPELLSLINGER_CREATION, world, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}

	public TileMagicCircle getTile(World world, BlockPos pos) {
		return (TileMagicCircle)world.getTileEntity(pos);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileMagicCircle();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getCollisionBoundingBox(IBlockState worldIn, World pos, BlockPos state) {
		return worldIn.getBoundingBox(pos, state).offset(state);
	}
}
