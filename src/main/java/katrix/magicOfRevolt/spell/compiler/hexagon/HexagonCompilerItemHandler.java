/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.compiler.hexagon;

import katrix.magicOfRevolt.spell.Spell;
import katrix.magicOfRevolt.spell.compiler.ISpellContainer;
import katrix.magicOfRevolt.spell.object.SpellItemStack;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemHandlerHelper;

@SuppressWarnings("ConstantConditions") //Again, why is this a problem?
class HexagonCompilerItemHandler implements IItemHandlerModifiable {

	private ISpellContainer[][] spellArray;

	HexagonCompilerItemHandler(ISpellContainer[][] spellArray) {
		this.spellArray = spellArray;
	}

	@Override
	public int getSlots() {
		int amount = 0;
		for(int x = 0; x < spellArray.length; x++) {
			for(int y = 0; y < spellArray[x].length; y++) {
				if(getContainerAtPoint(x, y).getSpell() instanceof SpellItemStack) {
					amount++;
				}
			}
		}
		return amount;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		int counter = 0;
		for(int x = 0; x < spellArray.length; x++) {
			for(int y = 0; y < spellArray[x].length; y++) {
				Spell spell = getContainerAtPoint(x, y).getSpell();

				if(spell instanceof SpellItemStack) {
					if(slot == counter) {
						return ItemStack.copyItemStack(((SpellItemStack)spell).getStack());
					}
					else {
						counter++;
					}
				}
			}
		}
		wrongSlot(slot, counter);
		return null;
	}

	@Override
	public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
		if(stack == null || stack.stackSize == 0) return null;
		ItemStack spellStack = getStackInSlot(slot);
		int limit = stack.getMaxStackSize();

		if(spellStack != null) {
			if(!ItemHandlerHelper.canItemStacksStack(stack, spellStack)) return stack;

			limit -= spellStack.stackSize;
		}

		if(limit <= 0) return stack;

		boolean reachedLimit = stack.stackSize > limit;

		if(!simulate) {
			if(spellStack == null) {
				int counter = 0;
				for(int x = 0; x < spellArray.length; x++) {
					for(int y = 0; y < spellArray[x].length; y++) {
						Spell spell = getContainerAtPoint(x, y).getSpell();

						if(spell instanceof SpellItemStack) {
							if(slot == counter) {
								((SpellItemStack)spell).setStack(reachedLimit ? ItemHandlerHelper.copyStackWithSize(stack, limit) : stack);
							}
							else {
								counter++;
							}
						}
					}
				}
				wrongSlot(slot, counter);
			}
			else {
				spellStack.stackSize += reachedLimit ? limit : stack.stackSize;
			}
		}

		return reachedLimit ? ItemHandlerHelper.copyStackWithSize(stack, stack.stackSize - limit) : null;
	}

	@Override
	public ItemStack extractItem(int slot, int amount, boolean simulate) {
		if(amount == 0) return null;

		ItemStack stack = getStackInSlot(slot);

		if(stack == null) return null;

		int toExtract = Math.min(amount, stack.getMaxStackSize());

		if(stack.stackSize <= toExtract) {
			if(!simulate) {
				setStackInSlot(slot, null);
			}
			return stack;
		}
		else {
			if(!simulate) {
				setStackInSlot(slot, ItemHandlerHelper.copyStackWithSize(stack, stack.stackSize - toExtract));
			}

			return ItemHandlerHelper.copyStackWithSize(stack, toExtract);
		}
	}

	@Override
	public void setStackInSlot(int slot, ItemStack stack) {
		int counter = 0;
		for(int x = 0; x < spellArray.length; x++) {
			for(int y = 0; y < spellArray[x].length; y++) {
				Spell spell = getContainerAtPoint(x, y).getSpell();

				if(spell instanceof SpellItemStack) {
					if(slot == counter) {
						((SpellItemStack)spell).setStack(stack);
					}
					else {
						counter++;
					}
				}
			}
		}
		wrongSlot(slot, counter);
	}

	private ISpellContainer getContainerAtPoint(int x, int y) {
		if(x > spellArray.length || y > spellArray[x].length) return null;
		return spellArray[x][y];
	}

	private void wrongSlot(int slot, int counter) {
		throw new RuntimeException("Slot " + slot + " not in valid range - [0," + (counter - 1) + ")");
	}
}
