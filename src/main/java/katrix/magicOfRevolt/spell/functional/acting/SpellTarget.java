/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.functional.acting;

import katrix.magicOfRevolt.spell.ISpellVariable;
import katrix.magicOfRevolt.spell.functional.SpellFunctional;
import katrix.magicOfRevolt.spell.object.SpellObject;

public abstract class SpellTarget<T extends SpellObject> extends SpellFunctional {
	
	protected ISpellVariable<?, T> target;
	private static final int TARGET_INDEX = 0;
	
	public ISpellVariable<?, T> getTarget() {
		return target;
	}

	public SpellTarget<T> setTarget(ISpellVariable<?, T> target) {
		this.target = target;
		setInput(TARGET_INDEX, target.getSpell());
		return this;
	}
}
