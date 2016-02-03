/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.object;

import net.minecraft.block.Block;

public class SpellBlock extends SpellObject {

	private Block block;
	
	public SpellBlock() {}

	private SpellBlock(SpellBlock block) {
		this.block = block.block;
	}

	@Override
	public SpellBlock copy() {
		return new SpellBlock(this);
	}

	public Block getBlock() {
		return block;
	}

	public SpellBlock setBlock(Block block) {
		this.block = block;
		return this;
	}
}
