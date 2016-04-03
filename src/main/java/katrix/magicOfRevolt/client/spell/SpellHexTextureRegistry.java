package katrix.magicOfRevolt.client.spell;

import java.util.HashMap;
import java.util.Map;

import katrix.magicOfRevolt.spell.Spell;
import net.minecraft.util.ResourceLocation;

public class SpellHexTextureRegistry {

	private static final Map<Class<? extends Spell>, ResourceLocation> REGISTRY = new HashMap<>();

	public static void registerSpellHexTexture(Class<? extends Spell> clazz, ResourceLocation texture) {
		REGISTRY.put(clazz, texture);
	}

	public static int size() {
		return REGISTRY.size();
	}

	public static ResourceLocation getTexture(Class<? extends Spell> clazz) {
		return REGISTRY.get(clazz);
	}
}
