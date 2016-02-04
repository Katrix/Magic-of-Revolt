/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.variable;

import katrix.magicOfRevolt.spell.ISpellVariable;
import katrix.magicOfRevolt.spell.Spell;
import katrix.magicOfRevolt.spell.object.SpellLiving;
import katrix.magicOfRevolt.spell.object.SpellVector;

public class SpellVectorFromLook extends Spell implements ISpellVariable<SpellVectorFromLook, SpellVector>{
	
	private ISpellVariable<?, SpellLiving> living;
	private static final int LIVING_INDEX = 0;

	@Override
	public SpellVector getVariable() {
		return new SpellVector().setVector(living.getVariable().getEntity().getLookVec());
	}
	
	public ISpellVariable<?, SpellLiving> getLiving() {
		return living;
	}
	
	public SpellVectorFromLook setLiving(ISpellVariable<?, SpellLiving> living) {
		this.living = living;
		addInput(LIVING_INDEX, living.getSpell());
		return this;
	}

	@Override
	public SpellVectorFromLook getSpell() {
		return this;
	}
}
