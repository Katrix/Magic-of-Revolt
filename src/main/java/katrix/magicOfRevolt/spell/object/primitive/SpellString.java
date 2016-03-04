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

//Yes, I know that a String is technically not a primitive, but I still put it here for convenience sake.
public class SpellString extends SpellObject implements ISpellVariable<SpellString, SpellString>, ICopyable<SpellString> {

	private static final String NBT_STRING = "string";
	
	private String string;

	public SpellString(World world) {
		super(world);
	}

	private SpellString(SpellString string) {
		super(string);
		this.string = string.string;
	}

	@Override
	public SpellString copy() {
		return new SpellString(this);
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	@Override
	public SpellString getVariable() {
		return this;
	}

	@Override
	public SpellString getSpell() {
		return this;
	}
	
	@Override
    public NBTTagCompound serializeNBT() {
    	NBTTagCompound tag = super.serializeNBT();
    	tag.setString(NBT_STRING, string);
		return tag;
	}
    
	@Override
    public void deserializeNBT(NBTTagCompound tag) {
    	super.deserializeNBT(tag);
    	string = tag.getString(NBT_STRING);
	}
}
