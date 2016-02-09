/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 * 
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.client.fx;

import katrix.magicOfRevolt.spell.Spell;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

public abstract class FXSpell extends EntityFX {
	
	public Spell spell;

	protected FXSpell(World worldIn, double posXIn, double posYIn, double posZIn, Spell spell) {
		super(worldIn, posXIn, posYIn, posZIn);
		this.spell = spell;
	}
}
