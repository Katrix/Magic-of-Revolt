/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell;

import org.apache.logging.log4j.Level;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ListMultimap;

import katrix.magicOfRevolt.helper.LogHelper;
import katrix.magicOfRevolt.spell.object.primitive.SpellVoid;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.ModContainer;

public class SpellRegistry {

	private static final SpellRegistry INSTANCE = new SpellRegistry();

	private ListMultimap<ModContainer, SpellRegistration> spellRegistrations = ArrayListMultimap.create();
	private BiMap<Class<? extends Spell>, SpellRegistration> spellClassRegistrations = HashBiMap.create();
	private BiMap<Class<? extends Spell>, String> classStringMap = HashBiMap.create();

	private SpellRegistry() {
	}

	public static SpellRegistry instance() {
		return INSTANCE;
	}

	public static void register(Class<? extends Spell> clazz, String name, Object mod) {
		instance().doRegistration(clazz, name, mod);
	}

	private void doRegistration(Class<? extends Spell> clazz, String name, Object mod) {
		ModContainer container = FMLCommonHandler.instance().findContainerFor(mod);
		SpellRegistration entry = new SpellRegistration(clazz, container, name);

		try {
			spellClassRegistrations.put(clazz, entry);
			
			if (!classStringMap.containsKey(clazz)) {
				String spellModName = String.format("%s:%s", container.getModId(), name);
				classStringMap.put(clazz, spellModName);
				FMLLog.finer("Automatically registered mod %s spell %s as %s", container.getModId(), name, spellModName);
			}
			else {
				FMLLog.fine("Skipping automatic mod %s spell registration for already registered class %s", container.getModId(), clazz.getName());
			}
		}
		catch (IllegalArgumentException e) {
			FMLLog.log(Level.WARN, e, "The mod %s tried to register the spell (name,class) (%s,%s) one or both of which are already registered",
					container.getModId(), name, clazz.getName());
			return;
		}
		
		spellRegistrations.put(container, entry);
	}

	public static Spell createSpellByName(String spellName, World world) {
		if (spellName.equals(SpellVoid.SPELL_NAME))
			return SpellVoid.VOID;

		Spell spell = null;
		try {
			Class<? extends Spell> clazz = instance().classStringMap.inverse().get(spellName);

			if (clazz != null) {
				spell = clazz.getConstructor(World.class).newInstance(world);
			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}

		return spell;
	}

	public static Spell createSpellFromNBT(NBTTagCompound tag, World world) {
		String spellId = tag.getString(Spell.NBT_ID);
		if (spellId.equals(SpellVoid.SPELL_NAME))
			return SpellVoid.VOID;
		
		Spell spell = null;
		Class<? extends Spell> clazz = null;
		try {
			clazz = instance().classStringMap.inverse().get(spellId);

			if (clazz != null) {
				spell = clazz.getConstructor(World.class).newInstance(world);
			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}

		if (spell != null) {
			try {
				spell.deserializeNBT(tag);
			}
			catch (Exception e) {
				FMLLog.log(Level.ERROR, e,
						"An Entity %s(%s) has thrown an exception during loading, its state cannot be restored. Report this to the mod author",
						spellId, clazz.getName());
				spell = null;
			}
		}
		else {
			LogHelper.warn("Skipping Spell with id " + spellId);
		}

		return spell;
	}
	
	public static String getStringFromClass(Class<? extends Spell> clazz) {
		return instance().classStringMap.get(clazz);
	}
	
	public static Class<? extends Spell> getClassFromString(String name) {
		return instance().classStringMap.inverse().get(name);
	}

	public class SpellRegistration {

		private Class<? extends Spell> clazz;
		private ModContainer container;
		private String name;

		public SpellRegistration(Class<? extends Spell> clazz, ModContainer container, String name) {
			this.clazz = clazz;
			this.container = container;
			this.name = name;
		}

		public Class<? extends Spell> getSpellClass() {
			return clazz;
		}

		public ModContainer getContainer() {
			return container;
		}

		public String getSpellName() {
			return name;
		}
	}
}
