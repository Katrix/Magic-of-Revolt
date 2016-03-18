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
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

public class SpellVector extends SpellObject implements ISpellVariable<SpellVector, SpellVector>, ICopyable<SpellVector> {

	private static final String NBT_VECTOR = "vector";
	
	private Vec3d vector;

	public SpellVector(World world) {
		super(world);
	}

	private SpellVector(SpellVector vector) {
		super(vector);
		this.vector = vector.vector;
	}

	@Override
	public SpellVector copy() {
		return new SpellVector(this);
	}

	public Vec3d getVector() {
		return vector;
	}

	public SpellVector setVector(Vec3d vector) {
		this.vector = vector;
		return this;
	}

	@Override
	public SpellVector getVariable() {
		return this;
	}

	@Override
	public SpellVector getSpell() {
		return this;
	}
	
	@Override
    public NBTTagCompound serializeNBT() {
    	NBTTagCompound tag = super.serializeNBT();
    	NBTTagList list = new NBTTagList();
    	list.appendTag(new NBTTagDouble(vector.xCoord));
    	list.appendTag(new NBTTagDouble(vector.yCoord));
    	list.appendTag(new NBTTagDouble(vector.zCoord));
    	tag.setTag(NBT_VECTOR, list);
		return tag;
	}
    
	@Override
    public void deserializeNBT(NBTTagCompound tag) {
    	super.deserializeNBT(tag);
    	NBTTagList list = tag.getTagList(NBT_VECTOR, Constants.NBT.TAG_DOUBLE);
    	vector = new Vec3d(list.getDoubleAt(0), list.getDoubleAt(1), list.getDoubleAt(2));
	}
}
