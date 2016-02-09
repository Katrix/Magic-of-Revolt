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
import katrix.magicOfRevolt.spell.object.SpellBlockPos;
import katrix.magicOfRevolt.spell.object.primitive.SpellFloat;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class SpellExplosion extends SpellTarget<SpellBlockPos> {
	
	public SpellExplosion(World world) {
		super(world);
	}

	protected float strength;
	private static final int STRENGTH_INDEX = 1;
	
	private static final String NBT_STRENGTH = "strength";

	@Override
	public void execute() {
		BlockPos pos = target.getPos();
		world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), strength, false);
		executed = true;
	}

	public SpellExplosion setStrength(ISpellVariable<?, SpellFloat> strength) {
		this.strength = strength.getVariable().getFloat();
		setInput(STRENGTH_INDEX, strength.getSpell());
		return this;
	}
	
	@Override
    public NBTTagCompound serializeNBT() {
    	NBTTagCompound tag = super.serializeNBT();
    	tag.setFloat(NBT_STRENGTH, strength);
		return tag;
	}
    
	@Override
    public void deserializeNBT(NBTTagCompound tag) {
    	super.deserializeNBT(tag);
    	strength = tag.getFloat(NBT_STRENGTH);
	}
}
