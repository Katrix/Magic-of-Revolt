/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt;

import katrix.magicOfRevolt.block.RevoltBlock;
import katrix.magicOfRevolt.handler.ConfigHandler;
import katrix.magicOfRevolt.item.RevoltItem;
import katrix.magicOfRevolt.lib.LibMod;
import katrix.magicOfRevolt.net.GuiHandler;
import katrix.magicOfRevolt.net.PacketHandler;
import katrix.magicOfRevolt.tile.RevoltTile;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = LibMod.MODID, name = LibMod.NAME, version = LibMod.VERSION)
public class MagicOfRevolt {

	@Instance(LibMod.MODID)
	public static MagicOfRevolt instance;

	@SidedProxy(clientSide = LibMod.CLIENT_PROXY, serverSide = LibMod.COMMON_PROXY)
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigHandler.setConfig(event.getSuggestedConfigurationFile());
		RevoltItem.preInit();
		RevoltBlock.preInit();
		RevoltTile.preInit();
		proxy.registerModels();
		proxy.registerSpells();
		PacketHandler.preInit();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {}
}
