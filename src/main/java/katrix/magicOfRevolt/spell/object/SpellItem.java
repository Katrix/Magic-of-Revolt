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
import net.minecraft.item.Item;

public class SpellItem extends SpellObject implements ISpellVariable<SpellItem, SpellItem>, ICopyable<SpellItem> {

	private Item item;

	public SpellItem() {
	}

	public SpellItem(SpellItem item) {
		this.item = item.item;
	}

	@Override
	public SpellItem copy() {
		return new SpellItem(this);
	}

	public Item getItem() {
		return item;
	}

	public SpellItem setItem(Item item) {
		this.item = item;
		return this;
	}

	@Override
	public SpellItem getVariable() {
		return this;
	}

	@Override
	public SpellItem getSpell() {
		return this;
	}
}
