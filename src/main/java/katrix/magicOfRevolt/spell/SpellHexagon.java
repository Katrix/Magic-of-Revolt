/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class SpellHexagon extends Spell {

	public static final int DIAMETER = 5;
	Spell[][] spellArray = new Spell[DIAMETER][DIAMETER];

	public SpellHexagon(World world) {
		super(world);
	}

	public Spell getSpellAtPoint(int x, int y) {
		if (x > DIAMETER || y > DIAMETER)
			return null;

		return spellArray[x][y];
	}

	public void setSpellAt(Spell spell, int x, int y) {
		if (x < DIAMETER && y < DIAMETER) {
			spellArray[x][y] = spell;
		}
	}

	@Override
	public void updateChild() {
		for(int i = 0; i < DIAMETER; i++) {
			for(int j = 0; j < DIAMETER; j++) {
				getSpellAtPoint(i, j).onUpdate();
			}
		}
	}

	@Override
	public boolean isWarmupComplete() {
		if (ticksUpdated > getWarmup()) {
			for(int i = 0; i < DIAMETER; i++) {
				for(int j = 0; j < DIAMETER; j++) {
					Spell spell = getSpellAtPoint(i, j);
					if(!spell.isWarmupComplete() || !spell.warmupDone) {
						return false;
					}
				}
			}
		}
		else
			return false;

		return true;
	}

	@Override
	public boolean isExecuteComplete() {
		for(int i = 0; i < DIAMETER; i++) {
			for(int j = 0; j < DIAMETER; j++) {
				Spell spell = getSpellAtPoint(i, j);
				if(!spell.isExecuteComplete() || !spell.executeDone) {
					return false;
				}
			}
		}
		
		return true;
	}

	@Override
	public int getTotalMindCost() {
		int total = getMindCost();
		
		for(int i = 0; i < DIAMETER; i++) {
			for(int j = 0; j < DIAMETER; j++) {
				total += getSpellAtPoint(i, j).getMindCost();
			}
		}
		
		return total;
	}

	@Override
	public int getTotalWarmup() {
		int total = getWarmup();
		
		for(int i = 0; i < DIAMETER; i++) {
			for(int j = 0; j < DIAMETER; j++) {
				total += getSpellAtPoint(i, j).getWarmup();
			}
		}
		
		return total;
	}

	@Override
	public NBTTagCompound serializeNBT() {
		NBTTagCompound tag = new NBTTagCompound();
		return tag;
	}

	@Override
	public void deserializeNBT(NBTTagCompound tag) {
	}
}
