/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 * 
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.object.primitive;

import katrix.magicOfRevolt.spell.object.SpellObject;
import net.minecraft.world.World;

public class SpellFloat extends SpellObject{
	
	private float spellFloat;

	public SpellFloat(World world) {
		super(world);
	}

	public float getFloat() {
		return spellFloat;
	}

	public void setFloat(float spellFloat) {
		this.spellFloat = spellFloat;
	}
}
