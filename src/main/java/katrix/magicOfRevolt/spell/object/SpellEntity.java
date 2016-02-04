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

public class SpellEntity extends SpellObject implements ISpellVariable<SpellEntity, SpellEntity>, ICopyable<SpellEntity> {

	private Entity entity;

	public SpellEntity() {
	}

	private SpellEntity(SpellEntity entity) {
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
}
