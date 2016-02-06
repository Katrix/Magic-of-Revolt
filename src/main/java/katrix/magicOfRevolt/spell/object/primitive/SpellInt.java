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

public class SpellInt extends SpellObject implements ISpellVariable<SpellInt, SpellInt>, ICopyable<SpellInt> {

	private int spellInt;
	
	private static final String NBT_INT = "int";

	public SpellInt() {
	}

	private SpellInt(SpellInt spellInt) {
		this.spellInt = spellInt.spellInt;
	}

	@Override
	public SpellInt copy() {
		return new SpellInt(this);
	}

	public int getInteger() {
		return spellInt;
	}

	public void setInteger(int spellInt) {
		this.spellInt = spellInt;
	}

	@Override
	public SpellInt getVariable() {
		return this;
	}

	@Override
	public SpellInt getSpell() {
		return this;
	}
	
	@Override
    public NBTTagCompound serializeNBT() {
    	NBTTagCompound tag = super.serializeNBT();
    	tag.setInteger(NBT_INT, spellInt);
		return tag;
	}
    
	@Override
    public void deserializeNBT(NBTTagCompound tag) {
    	super.deserializeNBT(tag);
    	spellInt = tag.getInteger(NBT_INT);
	}
}
