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
import katrix.magicOfRevolt.spell.object.SpellEntity;
import katrix.magicOfRevolt.spell.object.SpellVector;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

public class SpellAddMotion extends SpellTarget<SpellEntity> {
	
	public SpellAddMotion(World world) {
		super(world);
	}

	protected Vec3 vector;
	private static final int VECTOR_INDEX = 1;
	
	private static final String NBT_MOTION = "motion";

	@Override
	public void execute() {
		Entity entity = target.getEntity();
		entity.addVelocity(vector.xCoord, vector.yCoord, vector.zCoord);
		executed = true;
	}

	public SpellAddMotion setMotion(ISpellVariable<?, SpellVector> vector) {
		this.vector = vector.getVariable().getVector();
		setInput(VECTOR_INDEX, vector.getSpell());
		return this;
	}
	
	@Override
    public NBTTagCompound serializeNBT() {
    	NBTTagCompound tag = super.serializeNBT();
    	NBTTagList list = new NBTTagList();
    	list.appendTag(new NBTTagDouble(vector.xCoord));
    	list.appendTag(new NBTTagDouble(vector.yCoord));
    	list.appendTag(new NBTTagDouble(vector.zCoord));
    	tag.setTag(NBT_MOTION, list);
		return tag;
	}
    
	@Override
    public void deserializeNBT(NBTTagCompound tag) {
    	super.deserializeNBT(tag);
    	NBTTagList list = tag.getTagList(NBT_MOTION, Constants.NBT.TAG_DOUBLE);
    	vector = new Vec3(list.getDoubleAt(0), list.getDoubleAt(1), list.getDoubleAt(2));
	}
}
