/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 * 
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell;

import katrix.magicOfRevolt.spell.container.ISpellContainer;
import net.minecraft.util.math.Vec3d;

public interface ISpellActivator {
	
	void activate();
	
	void disable();
	
	void setSpellContainer(ISpellContainer container);
	
	Vec3d getPosistion();

}
