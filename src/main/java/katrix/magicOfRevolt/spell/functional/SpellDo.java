/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 * 
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.functional;

import katrix.magicOfRevolt.spell.Spell;
import katrix.magicOfRevolt.spell.object.primitive.SpellBoolean;
import net.minecraft.world.World;

public class SpellDo extends SpellFunctional {
	
	private static final int SPELL_INDEX = 0;
	private static final int CONDITION_INDEX = 1;
	
	private int limit = 0;
	
	public SpellDo(World world) {
		super(world);
	}

	@Override
	public void execute() {
		super.execute();
		Spell spell = getInput(SPELL_INDEX);
		boolean condition = getVariable(SpellBoolean.class, CONDITION_INDEX).getBoolean();
		
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
