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
import katrix.magicOfRevolt.spell.Spell;
import katrix.magicOfRevolt.spell.object.primitive.SpellBoolean;
import net.minecraft.world.World;

public class SpellDo extends SpellFunctional {
	
	private static final String SPELL_NAME = "spell";
	private static final String CONDITION_NAME = "condition";
	
	private int limit = 0;
	
	public SpellDo(World world) {
		super(world);
	}

	@Override
	public void execute() {
		super.execute();
		Spell spell = getInput(SPELL_NAME);
		boolean condition = ((ISpellVariable<?, SpellBoolean>)getInput(CONDITION_NAME)).getVariable().getBoolean();
		
		do {
			spell.execute();
			limit++;
		} while (condition && limit < 1000);
		
		if(limit >= 1000) {
			fizzle("infiniteLoop");
		}
		warmupDone =true;
	}
}
