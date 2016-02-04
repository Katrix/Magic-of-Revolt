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
import net.minecraft.entity.EntityLivingBase;

public class SpellLiving extends SpellObject implements ISpellVariable<SpellLiving, SpellLiving>, ICopyable<SpellLiving> {

	private EntityLivingBase living;

	public SpellLiving() {
	}

	private SpellLiving(SpellLiving living) {
		this.living = living.living;
	}

	@Override
	public SpellLiving copy() {
		return new SpellLiving(this);
	}

	public Entity getEntity() {
		return living;
	}

	public void setEntity(EntityLivingBase living) {
		this.living = living;
		world = living.worldObj;
	}

	@Override
	public SpellLiving getVariable() {
		return this;
	}

	@Override
	public SpellLiving getSpell() {
		return this;
	}
}
