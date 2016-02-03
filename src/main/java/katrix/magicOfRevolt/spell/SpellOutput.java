/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell;

import katrix.magicOfRevolt.spell.object.SpellObject;
import katrix.magicOfRevolt.spell.object.primitive.SpellVoid;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

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

	@Override
	public Spell runSpell(Spell parent) {
		for (Spell spell : getInputs()) {
			if (spell != null) {
				if (parent == null && spell != SpellVoid.spell && spell instanceof SpellObject) {
					IChatComponent message = new ChatComponentText(spell.runSpell(this).toString());
					addChatMessage(message);
				}
				else {
					spell.runSpell(this);
				}
			}
			else {
				fizzleParameters();
			}
		}
		return this;
	}

	public Spell getInput1() {
		return input1;
	}

	public void setInput1(Spell input) {
		input1 = input;
		inputs.set(INPUT1_INXED, input);
	}

	public Spell getInput2() {
		return input2;
	}

	public void setInput2(Spell input) {
		input2 = input;
		inputs.set(INPUT2_INXED, input);
	}

	public Spell getInput3() {
		return input3;
	}

	public void setInput3(Spell input) {
		input3 = input;
		inputs.set(INPUT3_INXED, input);
	}

	public Spell getInput4() {
		return input4;
	}

	public void setInput4(Spell input) {
		input4 = input;
		inputs.set(INPUT4_INXED, input);
	}

	public Spell getInput5() {
		return input5;
	}

	public void setInput5(Spell input) {
		input5 = input;
		inputs.set(INPUT5_INXED, input);
	}

	public Spell getInput6() {
		return input6;
	}

	public void setInput6(Spell input) {
		input6 = input;
		inputs.set(INPUT6_INXED, input);
	}
}
