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

public class SpellShort extends SpellObject implements ISpellVariable<SpellShort, SpellShort>, ICopyable<SpellShort> {

	private static final String NBT_SHORT = "short";

	private short spellShort;

	public SpellShort(World world) {
		super(world);
	}

	private SpellShort(SpellShort spellShort) {
		super(spellShort);
		this.spellShort = spellShort.spellShort;
	}

	@Override
	public SpellShort copy() {
		return new SpellShort(this);
	}

	public short getShort() {
		return spellShort;
	}

	public void setShort(short spellShort) {
		this.spellShort = spellShort;
	}

	@Override
	public SpellShort getVariable() {
		return this;
	}

	@Override
	public SpellShort getSpell() {
		return this;
	}

	@Override
	public NBTTagCompound serializeNBT() {
		NBTTagCompound tag = super.serializeNBT();
		tag.setShort(NBT_SHORT, spellShort);
		return tag;
	}

	@Override
	public void deserializeNBT(NBTTagCompound tag) {
		super.deserializeNBT(tag);
		spellShort = tag.getShort(NBT_SHORT);
	}
}
