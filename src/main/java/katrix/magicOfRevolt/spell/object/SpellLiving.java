/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.object;

import katrix.magicOfRevolt.spell.ICopyable;
import katrix.magicOfRevolt.spell.ISpellVariable;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class SpellLiving extends SpellObject implements ISpellVariable<SpellLiving, SpellLiving>, ICopyable<SpellLiving> {

	private EntityLivingBase living;
	
	private static final String NBT_LIVING = "living";

	public SpellLiving(World world) {
		super(world);
	}

	private SpellLiving(SpellLiving living) {
		super(living);
		this.living = living.living;
	}

	@Override
	public SpellLiving copy() {
		return new SpellLiving(this);
	}

	public EntityLivingBase getLiving() {
		return living;
	}

	public void setLiving(EntityLivingBase living) {
		this.living = living;
		world = living.worldObj;
	}

	@Override
	public SpellLiving getVariable() {
		return this;
	}

	@Override
	public SpellLiving getSpell() {
		return this;
	}
	
	@Override
    public NBTTagCompound serializeNBT() {
    	NBTTagCompound tag = super.serializeNBT();
    	tag.setTag(NBT_LIVING, living.serializeNBT());
		return tag;
	}
    
	@Override
    public void deserializeNBT(NBTTagCompound tag) {
    	super.deserializeNBT(tag);
    	living = (EntityLivingBase)EntityList.createEntityFromNBT(tag.getCompoundTag(NBT_LIVING), null); //FIXME: Not good at all
	}
}
