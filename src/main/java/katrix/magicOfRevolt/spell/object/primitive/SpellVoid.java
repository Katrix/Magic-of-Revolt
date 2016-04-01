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
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

//Not really a primitive. Used where you would normally use void or null. A real null is uses to specify that a input was never set.
public final class SpellVoid extends SpellObject implements ISpellVariable<SpellVoid, SpellVoid> {

	public static final SpellVoid VOID = new SpellVoid(FMLCommonHandler.instance().getMinecraftServerInstance().getEntityWorld()); //FIXME: Need to find static way to access entity world
	public static final String SPELL_NAME = "magicOfRevolt:void";

	private SpellVoid(World world) {
		super(world);
	}

	@Override
	public SpellVoid getVariable() {
		return VOID;
	}

	@Override
	public SpellVoid getSpell() {
		return VOID;
	}
	
	@Override
	public boolean isWarmupComplete() {
		return true;
	}
	
	@Override
	public NBTTagCompound serializeNBT() {
		return new NBTTagCompound();
	}

	@Override
	public void deserializeNBT(NBTTagCompound tag) {
	}
}
