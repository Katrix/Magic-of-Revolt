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
import katrix.magicOfRevolt.spell.SpellDummy;
import katrix.magicOfRevolt.spell.SpellException;
import katrix.magicOfRevolt.spell.object.SpellLiving;
import katrix.magicOfRevolt.spell.object.SpellVector;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class SpellVectorFromLook extends Spell implements ISpellVariable<SpellVectorFromLook, SpellVector> {
	
	public static final int LIVING_INDEX = 0;
	
	public SpellVectorFromLook(World world) {
		super(world);
		setInput(new SpellDummy(world), LIVING_INDEX);
	}

	@Override
	public SpellVector getVariable() throws SpellException {
		EntityLivingBase living = this.<SpellLiving>getVariable(LIVING_INDEX).getLiving();
		return new SpellVector(world).setVector(living.getLookVec());
	}

	@Override
	public SpellVectorFromLook getSpell() {
		return this;
	}
}
