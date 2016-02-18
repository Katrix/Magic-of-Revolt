/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.handler;

import katrix.magicOfRevolt.client.gui.GuiHexagonSpellCreation;
import katrix.magicOfRevolt.lib.LibGuiID;
import katrix.magicOfRevolt.spell.container.SpellContainerHexagon;
import katrix.magicOfRevolt.tile.TileMagicCircle;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case LibGuiID.SPELLSLINGER_CREATION: {
				return new GuiHexagonSpellCreation((SpellContainerHexagon)((TileMagicCircle)world.getTileEntity(new BlockPos(x, y, z))).getContainer());
			}
			default:
				return null;
		}
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			default:
				return null;
		}
	}
}
