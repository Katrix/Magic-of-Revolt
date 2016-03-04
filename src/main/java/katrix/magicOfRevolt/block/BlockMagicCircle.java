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
import katrix.magicOfRevolt.tile.TileMagicCircle;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockMagicCircle extends BlockRevoltBase implements ITileEntityProvider {

	public BlockMagicCircle() {
		super(Material.web);
		setUnlocalizedName(LibBlockName.MAGIC_CIRCLE);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		/*
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
			
			SpellContainerHexagon hex = new SpellContainerHexagon();
			hex.setSpellAtPoint(output, 3, 5);
			
			getTile(world, pos).setSpellContainer(hex);
		}
		*/
		
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
    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
    {
        return null;
    }
}
