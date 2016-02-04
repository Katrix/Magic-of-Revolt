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
import net.minecraft.item.ItemStack;

public class SpellItemStack extends SpellObject implements ISpellVariable<SpellItemStack, SpellItemStack>, ICopyable<SpellItemStack> {

	private ItemStack stack;

	public SpellItemStack() {
	}

	private SpellItemStack(SpellItemStack stack) {
		this.stack = stack.stack;
	}

	@Override
	public SpellItemStack copy() {
		return new SpellItemStack(this);
	}

	public ItemStack getStack() {
		return stack;
	}

	public void setStack(ItemStack stack) {
		this.stack = stack;
	}

	@Override
	public SpellItemStack getVariable() {
		return this;
	}

	@Override
	public SpellItemStack getSpell() {
		return this;
	}
}
