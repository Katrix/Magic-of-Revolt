/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 * 
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.tile;

import katrix.magicOfRevolt.lib.LibTileID;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RevoltTile {
	
	public static void preInit() {
		GameRegistry.registerTileEntity(TileMagicCircle.class, LibTileID.magicCircle);
	}
}
