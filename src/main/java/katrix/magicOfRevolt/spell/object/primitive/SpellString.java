/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 * 
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.object.primitive;

import katrix.magicOfRevolt.spell.object.SpellObject;
import net.minecraft.world.World;

//Yes, I know that a String is technically not a primitive, but I still put it here for convenience sake.
public class SpellString extends SpellObject{
	
	private String string;

	public SpellString(World world) {
		super(world);
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}
}
