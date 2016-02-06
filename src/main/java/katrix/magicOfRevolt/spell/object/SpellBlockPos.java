/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.object;

import katrix.magicOfRevolt.spell.ICopyable;
import katrix.magicOfRevolt.spell.ISpellVariable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.BlockPos;
import net.minecraftforge.common.util.Constants;

public class SpellBlockPos extends SpellObject implements ISpellVariable<SpellBlockPos, SpellBlockPos>, ICopyable<SpellBlockPos> {

	private BlockPos pos;
	
	private static final String NBT_POS = "pos";

	public SpellBlockPos() {
	}

	private SpellBlockPos(SpellBlockPos pos) {
		this.pos = pos.pos;
	}

	@Override
	public SpellBlockPos copy() {
		return new SpellBlockPos(this);
	}

	public BlockPos getPos() {
		return pos;
	}

	public SpellBlockPos setPos(BlockPos pos) {
		this.pos = pos;
		return this;
	}

	@Override
	public SpellBlockPos getVariable() {
		return this;
	}

	@Override
	public SpellBlockPos getSpell() {
		return this;
	}
	
	@Override
    public NBTTagCompound serializeNBT() {
    	NBTTagCompound tag = super.serializeNBT();
    	NBTTagList list = new NBTTagList();
    	list.appendTag(new NBTTagDouble(pos.getX()));
    	list.appendTag(new NBTTagDouble(pos.getY()));
    	list.appendTag(new NBTTagDouble(pos.getZ()));
    	tag.setTag(NBT_POS, list);
		return tag;
	}
    
	@Override
    public void deserializeNBT(NBTTagCompound tag) {
    	super.deserializeNBT(tag);
    	NBTTagList list = tag.getTagList(NBT_POS, Constants.NBT.TAG_DOUBLE);
    	pos = new BlockPos(list.getDoubleAt(0), list.getDoubleAt(1), list.getDoubleAt(2));
	}
}
