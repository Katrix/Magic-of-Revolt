/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.object.primitive;

import katrix.magicOfRevolt.spell.ISpellVariable;
import katrix.magicOfRevolt.spell.object.SpellObject;
import net.minecraft.nbt.NBTTagCompound;

//Not really a primitive. Used where you would normally use void or null. A real null is uses to specify that a input was never set.
public final class SpellVoid extends SpellObject implements ISpellVariable<SpellVoid, SpellVoid> {

	public static final SpellVoid spell = new SpellVoid();
	public static final String className = spell.getClass().getName();

	private SpellVoid() {
	}

	@Override
	public SpellVoid getVariable() {
		return spell;
	}

	@Override
	public SpellVoid getSpell() {
		return spell;
	}
	
	@Override
	public NBTTagCompound serializeNBT() {
		NBTTagCompound tag = new NBTTagCompound();
		tag.setString(NBT_CLASS, className);
		return tag;
	}

	@Override
	public void deserializeNBT(NBTTagCompound tag) {
	}
}
