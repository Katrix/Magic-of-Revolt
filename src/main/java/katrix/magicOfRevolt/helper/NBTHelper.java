/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.helper;

import java.util.List;
import java.util.UUID;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

public class NBTHelper {

	public static final String NBT_BLOCKPOS = "blockPos";
	public static final String NBT_VECTOR = "vector";
	public static final String NBT_FACING = "facing";
	public static final String NBT_RAY_TYPE_OF_HIT = "typeOfHit";
	public static final String NBT_UUID = "uuid";

	public static void setVector(NBTTagCompound tag, String tagName, Vec3d vector) {
		NBTTagList list = new NBTTagList();
		list.appendTag(new NBTTagDouble(vector.xCoord));
		list.appendTag(new NBTTagDouble(vector.yCoord));
		list.appendTag(new NBTTagDouble(vector.zCoord));
		tag.setTag(tagName, list);
	}

	public static Vec3d getVector(NBTTagCompound tag, String tagName) {
		NBTTagList list = tag.getTagList(tagName, Constants.NBT.TAG_DOUBLE);
		return new Vec3d(list.getDoubleAt(0), list.getDoubleAt(1), list.getDoubleAt(2));
	}

	public static void setBlockPos(NBTTagCompound tag, String tagName, BlockPos pos) {
		NBTTagList list = new NBTTagList();
		list.appendTag(new NBTTagDouble(pos.getX()));
		list.appendTag(new NBTTagDouble(pos.getY()));
		list.appendTag(new NBTTagDouble(pos.getZ()));
		tag.setTag(tagName, list);
	}

	public static BlockPos getBlockPos(NBTTagCompound tag, String tagName) {
		NBTTagList list = tag.getTagList(tagName, Constants.NBT.TAG_DOUBLE);
		return new BlockPos(list.getDoubleAt(0), list.getDoubleAt(1), list.getDoubleAt(2));
	}

	public static void setRay(NBTTagCompound tag, String tagName, RayTraceResult ray) {
		switch (ray.typeOfHit) {
			case BLOCK:
				tag.setInteger(NBT_RAY_TYPE_OF_HIT, 0);
				setBlockPos(tag, NBT_BLOCKPOS, ray.getBlockPos());
				tag.setInteger("sideHit", ray.sideHit.getIndex());
				setVector(tag, NBT_VECTOR, ray.hitVec);
				break;
			case ENTITY:
				setEntityByUUID(tag, NBT_UUID, ray.entityHit);
				setVector(tag, NBT_VECTOR, ray.hitVec);
				break;
			default:
				break;
		}
	}

	public static RayTraceResult getRay(NBTTagCompound tag, String tagName, World world) {
		switch (tag.getInteger(NBT_RAY_TYPE_OF_HIT)) {
			case 0:
				return new RayTraceResult(getVector(tag, NBT_VECTOR), EnumFacing.getFront(tag.getInteger(NBT_FACING)), getBlockPos(tag, NBT_BLOCKPOS));
			case 1:
				Entity entity = getEntityByUUID(tag, NBT_UUID, world);
				if (entity != null)
					return new RayTraceResult(entity, getVector(tag, NBT_VECTOR));
				else
					return null;
			default:
				break;
		}
		return null;
	}

	public static void setEntityByUUID(NBTTagCompound tag, String tagName, Entity entity) {
		tag.setString(tagName, entity.getUniqueID().toString());
	}

	public static Entity getEntityByUUID(NBTTagCompound tag, String tagName, World world) {
		List<Entity> entityList = world.loadedEntityList;
		UUID uuid = UUID.fromString(tag.getString(tagName));
		
		for (Entity entity : entityList) {
			if (entity.getUniqueID().equals(uuid))
				return entity;
		}
		
		return null;
	}
}
