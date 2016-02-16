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
import katrix.magicOfRevolt.spell.object.SpellVector;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class SpellVectorAdd extends Spell implements ISpellVariable<SpellVectorAdd, SpellVector> {
	
	private static final int VEC1_INDEX = 0;
	private static final int VEC2_INDEX = 1;

	public SpellVectorAdd(World world) {
		super(world);
		setInput(new SpellDummy(world), Side.UP_RIGHT, VEC1_INDEX);
		setInput(new SpellDummy(world), Side.RIGHT, VEC2_INDEX);
	}

	@Override
	public SpellVector getVariable() {
		Vec3 vec1 = getVariable(SpellVector.class, VEC1_INDEX).getVector();
		Vec3 vec2 = getVariable(SpellVector.class, VEC2_INDEX).getVector();
		return new SpellVector(world).setVector(vec1.add(vec2));
	}

	@Override
	public SpellVectorAdd getSpell() {
		return this;
	}
}
