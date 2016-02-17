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

public class SpellVectorMultiply extends Spell implements ISpellVariable<SpellVectorMultiply, SpellVector> {
	
	private static final int VEC1_INDEX = 0;
	private static final int VEC2_INDEX = 1;

	public SpellVectorMultiply(World world) {
		super(world);
		setInput(new SpellDummy(world), VEC1_INDEX);
		setInput(new SpellDummy(world), VEC2_INDEX);
	}

	@Override
	public SpellVector getVariable() {
		Vec3 vec1 = this.<SpellVector>getVariable(VEC1_INDEX).getVector();
		Vec3 vec2 = this.<SpellVector>getVariable(VEC2_INDEX).getVector();
		return new SpellVector(world).setVector(new Vec3(vec1.xCoord * vec2.xCoord, vec1.yCoord * vec2.yCoord, vec1.zCoord * vec2.zCoord));
	}

	@Override
	public SpellVectorMultiply getSpell() {
		return this;
	}
}
