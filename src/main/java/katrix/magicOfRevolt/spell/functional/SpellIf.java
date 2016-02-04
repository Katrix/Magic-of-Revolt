/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 * 
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.functional;

import katrix.magicOfRevolt.spell.ISpellVariable;
import katrix.magicOfRevolt.spell.object.SpellObject;
import katrix.magicOfRevolt.spell.object.primitive.SpellBoolean;
import katrix.magicOfRevolt.spell.object.primitive.SpellVoid;

public class SpellIf extends SpellFunctional {
	
	private SpellFunctional spell1;
	private SpellFunctional spell2;
	private ISpellVariable<?, SpellBoolean> condition;
	private static final int SPELL1_INDEX = 0;
	private static final int SPELL2_INDEX = 1;
	private static final int CONDITION_INDEX = 2;

	@Override
	public SpellObject execute() {
		if(condition.getVariable().getBoolean()) {
			spell1.execute();
		}
		else if(spell2 != null) {
			spell2.execute();
		}
		return SpellVoid.spell;
	}
	
	public SpellFunctional getSpell1() {
		return spell1;
	}

	
	public SpellIf setSpell1(SpellFunctional spell) {
		this.spell1 = spell;
		addInput(SPELL1_INDEX, spell);
		return this;
	}

	
	public SpellFunctional getSpell2() {
		return spell2;
	}

	
	public SpellIf setSpell2(SpellFunctional spell) {
		this.spell2 = spell;
		addInput(SPELL2_INDEX, spell);
		return this;
	}
	
	public ISpellVariable<?, SpellBoolean> getCondition() {
		return condition;
	}

	
	public SpellIf setCondition(ISpellVariable<?, SpellBoolean> condition) {
		this.condition = condition;
		addInput(CONDITION_INDEX, condition.getSpell());
		return this;
	}
}
