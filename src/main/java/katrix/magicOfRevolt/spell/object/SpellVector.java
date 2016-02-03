/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.object;

import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class SpellVector extends SpellObject {

	private Vec3 vector;

	public SpellVector(World world) {
		super(world);
	}

	private SpellVector(SpellVector vector) {
		super(vector);
		this.vector = vector.vector;
	}

	@Override
	public SpellVector copy() {
		return new SpellVector(this);
	}

	public Vec3 getVector() {
		return vector;
	}

	public SpellVector setVector(Vec3 vector) {
		this.vector = vector;
		return this;
	}
}
