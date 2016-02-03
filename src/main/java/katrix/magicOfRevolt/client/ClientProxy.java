/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.client;

import katrix.magicOfRevolt.CommonProxy;
import katrix.magicOfRevolt.block.RevoltBlock;
import katrix.magicOfRevolt.item.RevoltItem;
import net.minecraft.block.Block;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerModels() {
		registerItem(RevoltItem.revoltStick, 0);
		registerItemBlock(RevoltBlock.magicCircle, 0);
	}

	private void registerItem(Item item, int damage) {
		ModelLoader.setCustomModelResourceLocation(item, damage, new ModelResourceLocation(new ResourceLocation(item.getRegistryName()), "inventory"));
	}

	private void registerItemBlock(Block block, int damage) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), damage,
				new ModelResourceLocation(new ResourceLocation(block.getRegistryName()), "inventory"));
	}
}
