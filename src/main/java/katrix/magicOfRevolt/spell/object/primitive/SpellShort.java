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

public class SpellShort extends SpellObject {

	private short spellShort;
	
	public SpellShort() {}

	private SpellShort(SpellShort spellShort) {
		this.spellShort = spellShort.spellShort;
	}

	@Override
	public SpellShort copy() {
		return new SpellShort(this);
	}

	public short getShort() {
		return spellShort;
	}

	public void setShort(short spellShort) {
		this.spellShort = spellShort;
	}
}
