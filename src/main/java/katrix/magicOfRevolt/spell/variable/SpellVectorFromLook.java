/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.variable;

import katrix.magicOfRevolt.spell.ISpellVariable;
import katrix.magicOfRevolt.spell.Spell;
import katrix.magicOfRevolt.spell.object.SpellLiving;
import katrix.magicOfRevolt.spell.object.SpellVector;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;

public class SpellVectorFromLook extends Spell implements ISpellVariable<SpellVectorFromLook, SpellVector>{
	
	private EntityLivingBase living;
	private static final int LIVING_INDEX = 0;
	
	private static final String NBT_LIVING = "living";

	@Override
	public SpellVector getVariable() {
		return new SpellVector().setVector(living.getLookVec());
	}
	
	public SpellVectorFromLook setLiving(ISpellVariable<?, SpellLiving> living) {
		this.living = living.getVariable().getLiving();
		setInput(LIVING_INDEX, living.getSpell());
		return this;
	}

	@Override
	public SpellVectorFromLook getSpell() {
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
