/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.functional.acting;

import katrix.magicOfRevolt.spell.ISpellVariable;
import katrix.magicOfRevolt.spell.SpellRegistry;
import katrix.magicOfRevolt.spell.functional.SpellFunctional;
import katrix.magicOfRevolt.spell.object.SpellObject;
import net.minecraft.nbt.NBTTagCompound;

public abstract class SpellTarget<T extends SpellObject> extends SpellFunctional {
	
	protected T target;
	private static final int TARGET_INDEX = 0;
	
	private static final String NBT_TARGET = "target";
	
	public T getTarget() {
		return target;
	}

	public SpellTarget<T> setTarget(ISpellVariable<?, T> target) {
		this.target = target.getVariable();
		setInput(TARGET_INDEX, target.getSpell());
		return this;
	}
	
	@Override
    public NBTTagCompound serializeNBT() {
    	NBTTagCompound tag = super.serializeNBT();
    	tag.setTag(NBT_TARGET, target.serializeNBT());
		return tag;
	}
    
	@Override
    public void deserializeNBT(NBTTagCompound tag) {
    	super.deserializeNBT(tag);
    	target = (T)SpellRegistry.createSpellFromNBT(tag.getCompoundTag(NBT_TARGET));
	}
}
