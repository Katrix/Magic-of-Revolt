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
import katrix.magicOfRevolt.spell.SpellRegistry;
import katrix.magicOfRevolt.spell.object.SpellBlockPos;
import katrix.magicOfRevolt.spell.object.SpellIBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class SpellSetBlock extends SpellTarget<SpellBlockPos> {

	public SpellSetBlock(World world) {
		super(world);
	}

	protected SpellIBlockState state;
	private static final int STATE_INDEX = 1;
	
	private static final String NBT_STATE = "state";

	@Override
	public void execute() {
		if (target != null && state != null) {
			world.setBlockState(target.getPos(), state.getBlockState());
		}
		else {
			fizzleParameters();
		}

	}

	public void setState(ISpellVariable<?, SpellIBlockState> state) {
		this.state = state.getVariable();
		setInput(STATE_INDEX, state.getSpell());
	}
	
	@Override
    public NBTTagCompound serializeNBT() {
    	NBTTagCompound tag = super.serializeNBT();
    	tag.setTag(NBT_STATE, state.serializeNBT());
		return tag;
	}
    
	@Override
    public void deserializeNBT(NBTTagCompound tag) {
    	super.deserializeNBT(tag);
    	state = (SpellIBlockState)SpellRegistry.createSpellFromNBT(tag.getCompoundTag(NBT_STATE), world);
	}
}
