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
import katrix.magicOfRevolt.spell.object.primitive.SpellInt;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class SpellSetFire extends SpellTarget<SpellLiving> {

	public SpellSetFire(World world) {
		super(world);
	}

	private int duration;
	private static final int DURATION_INDEX = 1;
	
	private static final String NBT_DURATION = "duration";

	@Override
	public void execute() {
		if (target != null && duration != 0) {
			target.getLiving().setFire(duration);
		}
		else {
			fizzleParameters();
		}
		executed = true;
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
