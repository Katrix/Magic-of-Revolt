/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.compiler.hexagon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import katrix.magicOfRevolt.spell.Spell;
import katrix.magicOfRevolt.spell.SpellDummy;
import katrix.magicOfRevolt.spell.SpellOutput;
import katrix.magicOfRevolt.spell.compiler.ISpellCompiler;
import katrix.magicOfRevolt.spell.compiler.ISpellContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Tuple;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.items.CapabilityItemHandler;

public class HexagonSpellCompiler implements ISpellCompiler {

	private static final int DIAMETER = 5;
	private static final String NBT_HEXES = "hexes";
	private HexagonSpellContainer[][] spellArray = new HexagonSpellContainer[DIAMETER][DIAMETER];
	private Map<Integer, Tuple<Integer, Integer>> idMap = new HashMap<>();
	private World world;
	private HexagonCompilerItemHandler itemHandler;

	public HexagonSpellCompiler(World world) {
		this.world = world;
		int counter = 0;
		for(int x = 0; x < spellArray.length; x++) {
			for(int y = 0; y < spellArray[x].length; y++) {
				spellArray[x][y] = new HexagonSpellContainer(new SpellDummy(world), counter);
			}
		}
		itemHandler = new HexagonCompilerItemHandler(spellArray);
	}

	public HexagonSpellContainer getHexAtPoint(int x, int y) {
		if(x > DIAMETER || y > DIAMETER) return null;

		return spellArray[x][y];
	}

	public void setHexAtPoint(HexagonSpellContainer hex, int x, int y) {
		if(x <= DIAMETER && y <= DIAMETER) {
			spellArray[x][y] = hex;
		}
		idMap.put(hex.getId(), new Tuple<>(x, y));
	}

	public Spell getSpellAtPoint(int x, int y) {
		HexagonSpellContainer hex = getHexAtPoint(x, y);

		if(hex == null) return null;
		return hex.getSpell();
	}

	public void setSpellAtPoint(Spell spell, int x, int y) {
		getHexAtPoint(x, y).setSpell(spell);
	}

	@Override
	public ISpellContainer getContainerForId(int id) {
		Tuple<Integer, Integer> tuple = idMap.get(id);
		return getHexAtPoint(tuple.getFirst(), tuple.getSecond());
	}

	@Override
	public void setContainerForId(int id, ISpellContainer container) {
		Tuple<Integer, Integer> tuple = idMap.get(id);
		setHexAtPoint(new HexagonSpellContainer(container.getSpell(), container.getId()), tuple.getFirst(), tuple.getSecond());
	}

	public HexagonSpellContainer getHexAtSide(int x, int y, HexagonSide side) {
		return getHexAtPoint(x + side.getX(), y + side.getY());
	}

	public Spell getSpellAtSide(int x, int y, HexagonSide side) {
		return getHexAtSide(x, y, side).getSpell();
	}

	@Override
	public List<SpellOutput> compile() {
		List<SpellOutput> list = new ArrayList<>();

		for(int x = 0; x < spellArray.length; x++) {
			for(int y = 0; y < spellArray[x].length; y++) {
				HexagonSpellContainer hex = getHexAtPoint(x, y);
				//Map<HexagonSide, Integer> connections = hex.getConnections();
				Spell spell = hex.getSpell();

				//for(Map.Entry<HexagonSide, Integer> entry: connections.entrySet()) {
				//	spell.setInput(getSpellAtSide(x, y, entry.getKey()), entry.getValue());
				//}

				if(spell instanceof SpellOutput) {
					list.add((SpellOutput)spell);
				}
			}
		}

		return list;
	}

	@Override
	public NBTTagCompound serializeNBT() {
		NBTTagCompound tag = new NBTTagCompound();
		NBTTagList listX = new NBTTagList();
		for(int x = 0; x < spellArray.length; x++) {
			NBTTagList listY = new NBTTagList();
			for(int y = 0; y < spellArray[x].length; y++) {
				HexagonSpellContainer hex = getHexAtPoint(x, y);
				listY.appendTag(hex.serializeNBT());
			}
			listX.appendTag(listY);
		}
		tag.setTag(NBT_HEXES, listX);
		return tag;
	}

	@Override
	public void deserializeNBT(NBTTagCompound tag) {
		int idCounter = 0;
		NBTTagList listX = tag.getTagList(NBT_HEXES, Constants.NBT.TAG_LIST);
		for(int x = 0; x < listX.tagCount(); x++) {
			NBTBase optListY = listX.get(x);
			if(optListY instanceof NBTTagList) {
				NBTTagList listY = (NBTTagList)optListY;
				for(int y = 0; y < listY.tagCount(); y++) {
					setHexAtPoint(new HexagonSpellContainer(listY.getCompoundTagAt(y), world, idCounter++), x, y);
				}
			}
		}
	}

	@Override
	public int getSlots() {
		return itemHandler.getSlots();
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return itemHandler.getStackInSlot(slot);
	}

	@Override
	public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
		return itemHandler.insertItem(slot, stack, simulate);
	}

	@Override
	public ItemStack extractItem(int slot, int amount, boolean simulate) {
		return itemHandler.extractItem(slot, amount, simulate);
	}

	@Override
	public void setStackInSlot(int slot, ItemStack stack) {
		itemHandler.setStackInSlot(slot, stack);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;
	}

	@SuppressWarnings("unchecked") //TODO: Correct?
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) { return (T)itemHandler; }
		return null;
	}

	public void forEach(Consumer<HexagonSpellContainer> action) {
		for(int x = 0; x < spellArray.length; x++) {
			for(int y = 0; y < spellArray[x].length; y++) {
				action.accept(getHexAtPoint(x, y));
			}
		}
	}
}
