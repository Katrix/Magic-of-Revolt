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

	//TODO: Super ugly. Replace
	private Spell input1 = SpellVoid.spell;
	private Spell input2 = SpellVoid.spell;
	private Spell input3 = SpellVoid.spell;
	private Spell input4 = SpellVoid.spell;
	private Spell input5 = SpellVoid.spell;
	private Spell input6 = SpellVoid.spell;
	private static final int INPUT1_INXED = 0;
	private static final int INPUT2_INXED = 1;
	private static final int INPUT3_INXED = 2;
	private static final int INPUT4_INXED = 3;
	private static final int INPUT5_INXED = 4;
	private static final int INPUT6_INXED = 5;

	public Spell getInput1() {
		return input1;
	}

	public SpellOutput setInput1(Spell input) {
		input1 = input;
		addInput(INPUT1_INXED, input);
		return this;
	}

	public Spell getInput2() {
		return input2;
	}

	public SpellOutput setInput2(Spell input) {
		input2 = input;
		addInput(INPUT2_INXED, input);
		return this;
	}

	public Spell getInput3() {
		return input3;
	}

	public SpellOutput setInput3(Spell input) {
		input3 = input;
		addInput(INPUT3_INXED, input);
		return this;
	}

	public Spell getInput4() {
		return input4;
	}

	public SpellOutput setInput4(Spell input) {
		input4 = input;
		addInput(INPUT4_INXED, input);
		return this;
	}

	public Spell getInput5() {
		return input5;
	}

	public SpellOutput setInput5(Spell input) {
		input5 = input;
		addInput(INPUT5_INXED, input);
		return this;
	}

	public Spell getInput6() {
		return input6;
	}

	public SpellOutput setInput6(Spell input) {
		input6 = input;
		addInput(INPUT6_INXED, input);
		return this;
	}
}
