/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.object;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class SpellEntity extends SpellObject {

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
}
