/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.item;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemRevoltBase extends Item {

	@Override
	public Item setUnlocalizedName(String name) {
		setRegistryName(name);
		GameRegistry.registerItem(this);
		return super.setUnlocalizedName(name);
	}
}
