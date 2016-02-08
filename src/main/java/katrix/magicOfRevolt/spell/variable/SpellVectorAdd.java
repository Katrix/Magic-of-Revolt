/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.variable;

import katrix.magicOfRevolt.spell.ISpellVariable;
import katrix.magicOfRevolt.spell.Spell;
import katrix.magicOfRevolt.spell.object.SpellVector;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

public class SpellVectorAdd extends Spell implements ISpellVariable<SpellVectorAdd, SpellVector> {

	public SpellVectorAdd(World world) {
		super(world);
	}

	private Vec3 vec1;
	private Vec3 vec2;
	private static final int VEC1_INDEX = 0;
	private static final int VEC2_INDEX = 1;
	
	private static final String NBT_VEC1 = "vec1";
	private static final String NBT_VEC2 = "vec1";

	@Override
	public SpellVector getVariable() {
		return new SpellVector(world).setVector(vec1.add(vec2));
	}

	public void setVec1(ISpellVariable<?, SpellVector> vec1) {
		this.vec1 = vec1.getVariable().getVector();
		setInput(VEC1_INDEX, vec1.getSpell());
	}

	public void setVec2(ISpellVariable<?, SpellVector> vec2) {
		this.vec2 = vec2.getVariable().getVector();
		setInput(VEC2_INDEX, vec2.getSpell());
	}

	@Override
	public SpellVectorAdd getSpell() {
		return this;
	}
	
	@Override
    public NBTTagCompound serializeNBT() {
    	NBTTagCompound tag = super.serializeNBT();
    	NBTTagList list1 = new NBTTagList();
    	list1.appendTag(new NBTTagDouble(vec1.xCoord));
    	list1.appendTag(new NBTTagDouble(vec1.yCoord));
    	list1.appendTag(new NBTTagDouble(vec1.zCoord));
    	tag.setTag(NBT_VEC1, list1);
    	
    	NBTTagList list2 = new NBTTagList();
    	list2.appendTag(new NBTTagDouble(vec2.xCoord));
    	list2.appendTag(new NBTTagDouble(vec2.yCoord));
    	list2.appendTag(new NBTTagDouble(vec2.zCoord));
    	tag.setTag(NBT_VEC2, list2);
		return tag;
	}
    
	@Override
    public void deserializeNBT(NBTTagCompound tag) {
    	super.deserializeNBT(tag);
    	NBTTagList list1 = tag.getTagList(NBT_VEC1, Constants.NBT.TAG_DOUBLE);
    	vec1 = new Vec3(list1.getDoubleAt(0), list1.getDoubleAt(1), list1.getDoubleAt(2));
    	
    	NBTTagList list2 = tag.getTagList(NBT_VEC2, Constants.NBT.TAG_DOUBLE);
    	vec2 = new Vec3(list2.getDoubleAt(0), list2.getDoubleAt(1), list2.getDoubleAt(2));
	}
}
