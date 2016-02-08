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

public class SpellByte extends SpellObject implements ISpellVariable<SpellByte, SpellByte>, ICopyable<SpellByte> {

	private byte spellByte;
	
	private static final String NBT_BYTE = "byte";

	public SpellByte(World world) {
		super(world);
	}

	private SpellByte(SpellByte spellByte) {
		super(spellByte);
		this.spellByte = spellByte.spellByte;
	}

	@Override
	public SpellByte copy() {
		return new SpellByte(this);
	}

	public byte getByte() {
		return spellByte;
	}

	public void setByte(byte spellByte) {
		this.spellByte = spellByte;
	}

	@Override
	public SpellByte getVariable() {
		return this;
	}

	@Override
	public SpellByte getSpell() {
		return this;
	}
	
	@Override
    public NBTTagCompound serializeNBT() {
    	NBTTagCompound tag = super.serializeNBT();
    	tag.setByte(NBT_BYTE, spellByte);
		return tag;
	}
    
	@Override
    public void deserializeNBT(NBTTagCompound tag) {
    	super.deserializeNBT(tag);
    	spellByte = tag.getByte(NBT_BYTE);
	}
}
