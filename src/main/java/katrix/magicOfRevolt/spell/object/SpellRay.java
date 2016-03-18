/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.object;

import katrix.magicOfRevolt.spell.ICopyable;
import katrix.magicOfRevolt.spell.ISpellVariable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class SpellRay extends SpellObject implements ISpellVariable<SpellRay, SpellRay>, ICopyable<SpellRay> {

	private RayTraceResult ray;

	public SpellRay(World world) {
		super(world);
	}

	private SpellRay(SpellRay vector) {
		super(vector);
		ray = vector.ray;
	}

	@Override
	public SpellRay copy() {
		return new SpellRay(this);
	}

	public RayTraceResult getRay() {
		return ray;
	}

	public SpellRay setRay(RayTraceResult ray) {
		this.ray = ray;
		return this;
	}

	@Override
	public SpellRay getVariable() {
		return this;
	}

	@Override
	public SpellRay getSpell() {
		return this;
	}
}
