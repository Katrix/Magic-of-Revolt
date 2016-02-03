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

public class SpellByte extends SpellObject {

	private byte spellByte;

	public SpellByte(World world) {
		super(world);
	}

	private SpellByte(SpellByte spellByte) {
		super(spellByte);
		this.spellByte = spellByte.spellByte;
	}

	@Override
	public SpellByte copy() {
		return new SpellByte(this);
	}

	public byte getByte() {
		return spellByte;
	}

	public void setByte(byte spellByte) {
		this.spellByte = spellByte;
	}
}
