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

public class SpellDo extends SpellFunctional {
	
	private SpellFunctional spell;
	private ISpellVariable<?, SpellBoolean> condition;
	private static final int SPELL_INDEX = 0;
	private static final int CONDITION_INDEX = 1;
	
	private int limit = 0;

	@Override
	public SpellObject execute() {
		do {
			spell.execute();
			limit++;
		} while (condition.getVariable().getBoolean() && limit < 1000);
		
		if(limit >= 1000) {
			fizzle("infiniteLoop");
		}
		return SpellVoid.spell;
	}
	
	public SpellFunctional getSpell() {
		return spell;
	}
	
	public SpellDo setSpell1(SpellFunctional spell) {
		this.spell = spell;
		setInput(SPELL_INDEX, spell);
		return this;
	}
	
	public ISpellVariable<?, SpellBoolean> getCondition() {
		return condition;
	}
	
	public SpellDo setCondition(ISpellVariable<?, SpellBoolean> condition) {
		this.condition = condition;
		setInput(CONDITION_INDEX, condition.getSpell());
		return this;
	}
}
