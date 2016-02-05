/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell;

import katrix.magicOfRevolt.spell.object.primitive.SpellVoid;

public class SpellOutput extends Spell {

	private static final int AMOUNT = 6;

	public SpellOutput() {
		for (int i = 0; i < AMOUNT; i++) {
			setInput(i, SpellVoid.spell);
		}
	}

	public Spell getInputNo(int index) {
		if (index > AMOUNT)
			return getInputs().get(AMOUNT);
		
		return getInputs().get(index);
	}

	public SpellOutput setInputNo(int index, Spell input) {
		if (index > AMOUNT) {
			setInput(AMOUNT, input);
		}
		else {
			setInput(index, input);
		}
		return this;
	}
}
