/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.object.primitive;

import katrix.magicOfRevolt.spell.ICopyable;
import katrix.magicOfRevolt.spell.ISpellVariable;
import katrix.magicOfRevolt.spell.object.SpellObject;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class SpellDouble extends SpellObject implements ISpellVariable<SpellDouble, SpellDouble>, ICopyable<SpellDouble> {

	private double spellDouble;
	
	private static final String NBT_DOUBLE = "double";

	public SpellDouble(World world) {
		super(world);
	}

	private SpellDouble(SpellDouble spellDouble) {
		super(spellDouble);
		this.spellDouble = spellDouble.spellDouble;
	}

	@Override
	public SpellDouble copy() {
		return new SpellDouble(this);
	}

	public double getDouble() {
		return spellDouble;
	}

	public void setDouble(double spellDouble) {
		this.spellDouble = spellDouble;
	}

	@Override
	public SpellDouble getVariable() {
		return this;
	}

	@Override
	public SpellDouble getSpell() {
		return this;
	}
	
	@Override
    public NBTTagCompound serializeNBT() {
    	NBTTagCompound tag = super.serializeNBT();
    	tag.setDouble(NBT_DOUBLE, spellDouble);
		return tag;
	}
    
	@Override
    public void deserializeNBT(NBTTagCompound tag) {
    	super.deserializeNBT(tag);
    	spellDouble = tag.getDouble(NBT_DOUBLE);
	}
}
