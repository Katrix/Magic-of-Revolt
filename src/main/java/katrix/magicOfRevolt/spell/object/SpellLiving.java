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
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class SpellLiving extends SpellObject {
	
	private EntityLivingBase living;
	
	public SpellLiving(World world) {
		super(world);
	}
	
	public Entity getEntity() {
		return living;
	}
	
	public void setEntity(EntityLivingBase living) {
		this.living = living;
		this.world = living.worldObj;
	}
}
