/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockRevoltBase extends Block {

	public BlockRevoltBase(Material materialIn) {
		super(materialIn);
	}

	@Override
	public Block setUnlocalizedName(String name) {
		setRegistryName(name);
		GameRegistry.registerBlock(this);
		return super.setUnlocalizedName(name);
	}
}
