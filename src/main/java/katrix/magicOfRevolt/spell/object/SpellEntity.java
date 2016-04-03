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
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class SpellEntity extends SpellObject implements ISpellVariable<SpellEntity, SpellEntity>, ICopyable<SpellEntity> {

	private static final String NBT_ENTITY = "entity";

	private Entity entity;

	public SpellEntity(World world) {
		super(world);
	}

	private SpellEntity(SpellEntity entity) {
		super(entity);
		this.entity = entity.entity;
	}

	@Override
	public SpellEntity copy() {
		return new SpellEntity(this);
	}

	public Entity getEntity() {
		return entity;
	}

	public SpellEntity setEntity(Entity entity) {
		this.entity = entity;
		world = entity.worldObj;
		return this;
	}

	@Override
	public SpellEntity getVariable() {
		return this;
	}

	@Override
	public SpellEntity getSpell() {
		return this;
	}

	@Override
	public NBTTagCompound serializeNBT() {
		NBTTagCompound tag = super.serializeNBT();
		tag.setTag(NBT_ENTITY, entity.serializeNBT());
		return tag;
	}

	@Override
	public void deserializeNBT(NBTTagCompound tag) {
		super.deserializeNBT(tag);
		entity = EntityList.createEntityFromNBT(tag.getCompoundTag(NBT_ENTITY), null); //FIXME: Not good at all
	}
}
