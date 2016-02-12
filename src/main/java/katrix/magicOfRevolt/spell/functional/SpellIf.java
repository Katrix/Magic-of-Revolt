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
import katrix.magicOfRevolt.spell.SpellDummy;
import katrix.magicOfRevolt.spell.SpellRegistry;
import katrix.magicOfRevolt.spell.object.primitive.SpellBoolean;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class SpellIf extends SpellFunctional {
	
	private static final String SPELL1_NAME = "spell1";
	private static final String SPELL2_NAME = "spell2";
	private static final String CONDITION_NAME = "condition";
	
	public SpellIf(World world) {
		super(world);
		setInput(SPELL1_NAME, new SpellDummy(world), Side.UP_RIGHT);
		setInput(SPELL2_NAME, new SpellDummy(world), Side.DOWN_RIGHT);
		setInput(CONDITION_NAME, new SpellDummy(world), Side.RIGHT);
	}
	
	@Override
	public void execute() {
		super.execute();
		boolean condition = ((ISpellVariable<?, SpellBoolean>)getInput(CONDITION_NAME)).getVariable().getBoolean();
		Spell spell1 = getInput(SPELL1_NAME);
		Spell spell2 = getInput(SPELL2_NAME);
		if(condition) {
			spell1.execute();
		}
		else {
			spell2.execute();
		}
		executeDone = true;
	}
}
