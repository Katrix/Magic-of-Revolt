/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 * 
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.functional;

import katrix.magicOfRevolt.spell.object.SpellEntity;

public abstract class SpellEntityTarget extends SpellFunctional implements ISpellTarget<SpellEntity> {
	
	protected SpellEntity target;
	
	public SpellEntity getTarget() {
		return target;
	}
	
	public void setTarget(SpellEntity target) {
		this.target = target;
	}
}
