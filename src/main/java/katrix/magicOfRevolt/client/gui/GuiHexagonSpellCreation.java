/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.client.gui;

import katrix.magicOfRevolt.client.gui.button.GuiButtonSpell;
import katrix.magicOfRevolt.container.ContainerHexagonSpellCreation;
import katrix.magicOfRevolt.helper.LogHelper;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GuiHexagonSpellCreation extends GuiContainer {

	private ContainerHexagonSpellCreation container;

	public GuiHexagonSpellCreation(EntityPlayer player, World world, BlockPos blockPos) {
		super(new ContainerHexagonSpellCreation(player, world, blockPos));
		container = (ContainerHexagonSpellCreation)inventorySlots;
		xSize = 256;
		ySize = 256;
	}

	@Override
	public void initGui() {
		super.initGui();
		buttonList.add(new GuiButton(1, 200, 200, "TEST"));
		initHexagons();
	}

	private void initHexagons() {
		int offsetX = 128;
		int offsetY = 120;
		int diameter = 5;

		int map_radius = 2;
		int i = 0;
		for(int q = -map_radius; q <= map_radius; q++) {
			int r1 = Math.max(-map_radius, -q - map_radius);
			int r2 = Math.min(map_radius, -q + map_radius);
			for(int r = r1; r <= r2; r++) {
				LogHelper.info("q: " + (q + map_radius) + " r1: " + r1 + " r2: " + r2 + " r: " + (r + map_radius));
				buttonList.add(new GuiButtonSpell(i++, offsetX + q * 32, offsetY + r * 32, 32, q + map_radius, r + map_radius, container));
			}
		}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {

	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
}
