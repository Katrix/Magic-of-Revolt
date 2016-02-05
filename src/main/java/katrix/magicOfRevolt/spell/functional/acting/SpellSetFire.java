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
import katrix.magicOfRevolt.spell.object.SpellLiving;
import katrix.magicOfRevolt.spell.object.SpellObject;
import katrix.magicOfRevolt.spell.object.primitive.SpellInt;
import katrix.magicOfRevolt.spell.object.primitive.SpellVoid;

public class SpellSetFire extends SpellTarget<SpellLiving> {

	private ISpellVariable<?, SpellInt> duration;
	private static final int DURATION_INDEX = 1;

	@Override
	public SpellObject execute() {
		int durInt = duration.getVariable().getInteger();
		if (target != null && durInt != 0) {
			target.getVariable().getEntity().setFire(durInt);
		}
		else {
			fizzleParameters();
		}
		return SpellVoid.spell;
	}

	public ISpellVariable<?, SpellInt> getDuration() {
		return duration;
	}

	public void setDuration(ISpellVariable<?, SpellInt> duration) {
		this.duration = duration;
		addInput(DURATION_INDEX, duration.getSpell());
	}
}
