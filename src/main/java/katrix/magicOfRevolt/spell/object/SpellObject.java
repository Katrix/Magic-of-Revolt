/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.object;

import katrix.magicOfRevolt.spell.Spell;
import net.minecraft.world.World;

public abstract class SpellObject extends Spell {

	public SpellObject(World world) {
		super(world);
	}
	
	protected SpellObject(SpellObject object) {
		super(object);
	}
	
	@Override
	public void updateChild() {
		warmupDone = true; //Objects don't have children
	}
}
