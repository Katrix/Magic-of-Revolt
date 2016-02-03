/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.object;

import net.minecraft.item.Item;
import net.minecraft.world.World;

public class SpellItem extends SpellObject {

	private Item item;

	public SpellItem(World world) {
		super(world);
	}

	public SpellItem(SpellItem item) {
		super(item);
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
}
