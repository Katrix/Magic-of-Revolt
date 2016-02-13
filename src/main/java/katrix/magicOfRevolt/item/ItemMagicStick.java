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
import katrix.magicOfRevolt.helper.LogHelper;
import katrix.magicOfRevolt.lib.LibItemName;
import katrix.magicOfRevolt.spell.Spell;
import katrix.magicOfRevolt.spell.SpellOutput;
import katrix.magicOfRevolt.spell.SpellRegistry;
import katrix.magicOfRevolt.spell.functional.acting.SpellExplosion;
import katrix.magicOfRevolt.spell.object.SpellBlockPos;
import katrix.magicOfRevolt.spell.object.primitive.SpellFloat;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
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
		
		/*
		SpellBlockPos spellPos = new SpellBlockPos(world);
		spellPos.setPos(pos);
		
		SpellFloat spellFloat = new SpellFloat(world);
		spellFloat.setFloat(3F);
		
		SpellExplosion explode = new SpellExplosion(world);
		explode.setStrength(spellFloat).setTarget(spellPos);
		
		SpellLiving living = new SpellLiving(world);
		living.setEntity(player);
		
		SpellVectorFromLook vector = new SpellVectorFromLook(world);
		vector.setLiving(living);
		
		SpellEntity entity = new SpellEntity(world);
		entity.setEntity(player);
		
		SpellAddMotion motion = new SpellAddMotion(world);
		motion.setMotion(vector).setTarget(entity);
		
		SpellOutput output = new SpellOutput(world);
		//output.setInputNo(0, motion);
		output.setInputNo(1, explode);
		
		NBTTagCompound tag = output.serializeNBT();
		Spell output1 = SpellRegistry.createSpellFromNBT(tag, world);
		
		if(!world.isRemote) {
			LogHelper.info(tag);
			LogHelper.info(output1.serializeNBT());
		}
		*/
		
		return super.onItemUse(stack, player, world, pos, side, hitX, hitY, hitZ);
	}
}
