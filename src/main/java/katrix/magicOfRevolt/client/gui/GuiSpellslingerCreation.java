/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 * 
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.client.gui;

import katrix.magicOfRevolt.block.BlockMagicCircle;
import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class GuiSpellslingerCreation extends GuiScreen {
	
	private World world;
	private BlockPos pos;
	
	public GuiSpellslingerCreation(BlockPos pos) {
		this.pos = pos;
	}
	
	@SuppressWarnings("unused")
	private BlockMagicCircle getCircle() {
		Block block = world.getBlockState(pos).getBlock();
		if(block instanceof BlockMagicCircle) {
			return (BlockMagicCircle)block;
		}
		return null;
	}
	
    public boolean doesGuiPauseGame()
    {
        return false;
    }
}
