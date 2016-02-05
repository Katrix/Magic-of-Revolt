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
import katrix.magicOfRevolt.spell.object.SpellMOP;
import katrix.magicOfRevolt.spell.object.SpellVector;

public class SpellRaytrace extends Spell implements ISpellVariable<SpellRaytrace, SpellMOP> {

	private ISpellVariable<?, SpellVector> vec1;
	private ISpellVariable<?, SpellVector> vec2;
	private static final int VEC1_INDEX = 0;
	private static final int VEC2_INDEX = 1;

	@Override
	public SpellMOP getVariable() {
		return new SpellMOP().setMOP(world.rayTraceBlocks(vec1.getVariable().getVector(), vec2.getVariable().getVector(), false, false, true));
	}

	public ISpellVariable<?, SpellVector> getInput1() {
		return vec1;
	}

	public void setInput1(ISpellVariable<?, SpellVector> vec1) {
		this.vec1 = vec1;
		setInput(VEC1_INDEX, vec1.getSpell());
	}

	public ISpellVariable<?, SpellVector> getInput2() {
		return vec2;
	}

	public void setInput2(ISpellVariable<?, SpellVector> vec2) {
		this.vec2 = vec2;
		setInput(VEC2_INDEX, vec2.getSpell());
	}

	@Override
	public SpellRaytrace getSpell() {
		return this;
	}
}
