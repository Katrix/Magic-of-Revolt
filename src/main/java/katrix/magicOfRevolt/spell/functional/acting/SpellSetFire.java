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
import katrix.magicOfRevolt.spell.object.SpellLiving;
import katrix.magicOfRevolt.spell.object.SpellObject;
import katrix.magicOfRevolt.spell.object.primitive.SpellInt;
import katrix.magicOfRevolt.spell.object.primitive.SpellVoid;
import net.minecraft.nbt.NBTTagCompound;

public class SpellSetFire extends SpellTarget<SpellLiving> {

	private int duration;
	private static final int DURATION_INDEX = 1;
	
	private static final String NBT_DURATION = "duration";

	@Override
	public SpellObject execute() {
		if (target != null && duration != 0) {
			target.getLiving().setFire(duration);
		}
		else {
			fizzleParameters();
		}
		return SpellVoid.spell;
	}

	public void setDuration(ISpellVariable<?, SpellInt> duration) {
		this.duration = duration.getVariable().getInteger();
		setInput(DURATION_INDEX, duration.getSpell());
	}
	
	@Override
    public NBTTagCompound serializeNBT() {
    	NBTTagCompound tag = super.serializeNBT();
    	tag.setInteger(NBT_DURATION, duration);
		return tag;
	}
    
	@Override
    public void deserializeNBT(NBTTagCompound tag) {
    	super.deserializeNBT(tag);
    	duration = tag.getInteger(NBT_DURATION);
	}
}
