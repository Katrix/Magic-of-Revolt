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
import katrix.magicOfRevolt.spell.object.SpellVector;

public class SpellVectorAdd extends Spell implements ISpellVariable<SpellVectorAdd, SpellVector> {

	private ISpellVariable<?, SpellVector> vec1;
	private ISpellVariable<?, SpellVector> vec2;
	private static final int VEC1_INDEX = 0;
	private static final int VEC2_INDEX = 1;

	@Override
	public SpellVector getVariable() {
		SpellVector vec = vec1.getVariable();
		return vec.copy().setVector(vec.getVector().add(vec2.getVariable().getVector()));
	}

	public ISpellVariable<?, SpellVector> getVec1() {
		return vec1;
	}

	public void setVec1(ISpellVariable<?, SpellVector> vec1) {
		this.vec1 = vec1;
		setInput(VEC1_INDEX, vec1.getSpell());
	}

	public ISpellVariable<?, SpellVector> getVec2() {
		return vec2;
	}

	public void setVec2(ISpellVariable<?, SpellVector> vec2) {
		this.vec2 = vec2;
		setInput(VEC2_INDEX, vec2.getSpell());
	}

	@Override
	public SpellVectorAdd getSpell() {
		return this;
	}
}
