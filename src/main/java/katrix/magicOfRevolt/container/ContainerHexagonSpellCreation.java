/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.container;

import katrix.magicOfRevolt.spell.ISpellActivator;
import katrix.magicOfRevolt.spell.Spell;
import katrix.magicOfRevolt.spell.compiler.hexagon.HexagonSide;
import katrix.magicOfRevolt.spell.compiler.hexagon.HexagonSpellCompiler;
import katrix.magicOfRevolt.spell.compiler.hexagon.HexagonSpellContainer;
import katrix.magicOfRevolt.spell.object.SpellItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerHexagonSpellCreation extends Container {

	private ISpellActivator activator;
	private SlotItemHandler spellSlot;
	private HexagonSpellCompiler spellContainer;
	private HexagonSpellContainer selectedHex;

	public ContainerHexagonSpellCreation(EntityPlayer player, World world, BlockPos blockPos) {
		activator = (ISpellActivator)world.getTileEntity(blockPos);
		spellSlot = new SlotItemHandler(new ItemStackHandler(), 0, 50, 50);
		addSlotToContainer(spellSlot);
		spellContainer = (HexagonSpellCompiler)activator.getSpellCompiler().get();

		InventoryPlayer invPlayer = player.inventory;
		int offsetX = 89;
		int offsetY = 173;

		//Player inventory
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, offsetX + j * 18, offsetY + i * 18));
			}
		}

		//Player hotbar
		for(int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(invPlayer, i, offsetX + i * 18, offsetY + 58));
		}
	}

	@Override
	public void onCraftMatrixChanged(IInventory inventory) {
		Spell selectedSpell = selectedHex.getSpell();
		if(selectedSpell instanceof SpellItemStack) {
			((SpellItemStack)selectedSpell).setStack(spellSlot.getStack());
		}
		super.onCraftMatrixChanged(inventory);
	}

	public void selectHex(int x, int y) {
		selectedHex = spellContainer.getHexAtPoint(x, y);
		if(selectedHex.getSpell() instanceof SpellItemStack) {
			showSlot();
		}
		else {
			hideSlot();
		}
	}

	public void setSelectedSpell(Spell spell) {
		selectedHex.setSpell(spell);
		activator.sendUpdate(selectedHex);
	}

	public void addSelectedConnection(HexagonSide side, int state) {
		selectedHex.addConnection(side, state);
		activator.sendUpdate(selectedHex);
	}

	public void removeSelectedConnection(HexagonSide side) {
		selectedHex.removeConnection(side);
		activator.sendUpdate(selectedHex);
	}

	public Spell getSpellAt(int x, int y) {
		return spellContainer.getSpellAtPoint(x, y);
	}

	private void hideSlot() {
		spellSlot.xDisplayPosition = -100;
		spellSlot.yDisplayPosition = -100;
	}

	private void showSlot() {
		spellSlot.xDisplayPosition = 50;
		spellSlot.yDisplayPosition = 50;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true; //TODO: Something better here?
	}

	public HexagonSpellCompiler getSpellContainer() {
		return spellContainer;
	}

	public ISpellActivator getActivator() {
		return activator;
	}
}
