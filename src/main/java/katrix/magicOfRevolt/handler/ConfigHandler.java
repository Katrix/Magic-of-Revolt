/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.handler;

import java.io.File;

import katrix.magicOfRevolt.lib.LibMod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ConfigHandler {

	private static Configuration cfg;

	public static void setConfig(File configFile) {

		cfg = new Configuration(configFile);
		cfg.load();
		loadConfig();

		MinecraftForge.EVENT_BUS.register(new ChangeListener());
	}

	private static void loadConfig() {

		if(cfg.hasChanged()) {
			cfg.save();
		}
	}

	private static class ChangeListener {

		@SubscribeEvent
		public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
			if(eventArgs.modID.equals(LibMod.MODID)) {
				loadConfig();
			}
		}
	}
}
