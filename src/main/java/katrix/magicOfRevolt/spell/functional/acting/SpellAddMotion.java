/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 * 
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.functional.acting;

import katrix.magicOfRevolt.spell.ISpellVariable;
import katrix.magicOfRevolt.spell.object.SpellEntity;
import katrix.magicOfRevolt.spell.object.SpellObject;
import katrix.magicOfRevolt.spell.object.SpellVector;
import katrix.magicOfRevolt.spell.object.primitive.SpellVoid;
import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;

public class SpellAddMotion extends SpellTarget<SpellEntity> {
	
	protected ISpellVariable<?, SpellVector> vector;
	private static final int VECTOR_INDEX = 1;

	@Override
	public SpellObject execute() {
		Entity entity = target.getVariable().getEntity();
		Vec3 vec = vector.getVariable().getVector();
		entity.addVelocity(vec.xCoord, vec.yCoord, vec.zCoord);
		return SpellVoid.spell;
	}
	
	public ISpellVariable<?, SpellVector> getMotion() {
		return vector;
	}

	public SpellAddMotion setMotion(ISpellVariable<?, SpellVector> vector) {
		this.vector = vector;
		addInput(VECTOR_INDEX, vector.getSpell());
		return this;
	}
}
