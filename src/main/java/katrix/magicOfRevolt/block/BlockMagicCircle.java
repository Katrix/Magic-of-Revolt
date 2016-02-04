/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.block;

import java.util.ArrayList;
import java.util.List;

import katrix.magicOfRevolt.lib.LibBlockName;
import katrix.magicOfRevolt.spell.Spell;
import katrix.magicOfRevolt.spell.SpellOutput;
import katrix.magicOfRevolt.spell.functional.SpellFunctional;
import katrix.magicOfRevolt.spell.functional.SpellVectorFromLook;
import katrix.magicOfRevolt.spell.functional.acting.SpellAddMotion;
import katrix.magicOfRevolt.spell.functional.acting.SpellExplosion;
import katrix.magicOfRevolt.spell.object.SpellBlockPos;
import katrix.magicOfRevolt.spell.object.SpellEntity;
import katrix.magicOfRevolt.spell.object.SpellLiving;
import katrix.magicOfRevolt.spell.object.primitive.SpellFloat;
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
		List<Spell> list = new ArrayList<>();
		
		SpellBlockPos spellPos = new SpellBlockPos();
		spellPos.setPos(pos);
		
		SpellFloat spellFloat = new SpellFloat();
		spellFloat.setFloat(3F);
		
		SpellExplosion explode = new SpellExplosion();
		explode.setStrength(spellFloat).setTarget(spellPos);
		
		SpellLiving living = new SpellLiving();
		living.setEntity(player);
		
		SpellVectorFromLook vector = new SpellVectorFromLook();
		vector.setLiving(living);
		
		SpellEntity entity = new SpellEntity();
		entity.setEntity(player);
		
		SpellAddMotion motion = new SpellAddMotion();
		motion.setMotion(vector).setTarget(entity);
		
		SpellOutput output = new SpellOutput();
		output.setInput1(explode);
		output.setInput2(motion);
		
		list.add(output);
		list.add(explode);
		list.add(spellFloat);
		list.add(spellPos);
		list.add(motion);
		list.add(entity);
		list.add(vector);
		list.add(living);
		
		for(Spell spell : list) {
			spell.setWorld(world);
		}
		
		for(Spell spell : list) {
			if(spell instanceof SpellOutput) {
				SpellOutput out = (SpellOutput)spell;
				for(Spell input : out.getInputs()) {
					if(input instanceof SpellFunctional) {
						((SpellFunctional)input).execute();
					}
				}
			}
		}
		
		//player.openGui(MagicOfRevolt.instance, LibGuiID.SPELLSLINGER_CREATION, world, pos.getX(), pos.getY(), pos.getZ());
		return true;
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
