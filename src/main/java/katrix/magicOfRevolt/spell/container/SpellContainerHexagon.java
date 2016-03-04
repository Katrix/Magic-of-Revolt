/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.container;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ImmutableMap;

import katrix.magicOfRevolt.spell.Spell;
import katrix.magicOfRevolt.spell.SpellOutput;
import net.minecraft.nbt.NBTTagCompound;

public class SpellContainerHexagon implements ISpellContainer {

	public static final int DIAMETER = 5;
	HexagonSpellPiece[][] spellArray = new HexagonSpellPiece[DIAMETER][DIAMETER];

	public HexagonSpellPiece getHexAtPoint(int x, int y) {
		if (x > DIAMETER || y > DIAMETER)
			return null;

		return spellArray[x][y];
	}

	public Spell getSpellAtPoint(int x, int y) {
		HexagonSpellPiece hex = getHexAtPoint(x, y);

		if (hex == null)
			return null;
		else
			return hex.getSpell();
	}

	public void setSpellAtPoint(Spell spell, int x, int y) {
		if (x < DIAMETER && y < DIAMETER) {
			HexagonSpellPiece hex = new HexagonSpellPiece(spell);
			spellArray[x][y] = hex;
		}
	}

	public HexagonSpellPiece getHexAtSide(int x, int y, Side side) {
		return getHexAtPoint(x + side.getX(), y + side.getY());
	}

	public Spell getSpellAtSide(int x, int y, Side side) {
		return getHexAtSide(x, y, side).getSpell();
	}

	@Override
	public List<SpellOutput> compile() {
		List<SpellOutput> list = new ArrayList<>();

		for (int x = 0; x < spellArray.length; x++) {
			for (int y = 0; y < spellArray[x].length; y++) {
				HexagonSpellPiece hex = getHexAtPoint(x, y);
				Map<Side, Integer> connections = hex.getConnections();
				Set<Side> sides = connections.keySet();
				Spell spell = hex.getSpell();

				for (Side side : sides) {
					int index = connections.get(side);
					spell.setInput(getSpellAtSide(x, y, side), index);
				}

				if (spell instanceof SpellOutput) {
					list.add((SpellOutput)spell);
				}
			}
		}

		return list;
	}

	@Override
	public NBTTagCompound serializeNBT() {
		NBTTagCompound tag = new NBTTagCompound();
		return tag;
	}

	@Override
	public void deserializeNBT(NBTTagCompound tag) {
	}

	public class HexagonSpellPiece {

		private Spell spell;
		private Map<Side, Integer> connections = new HashMap<>();

		public HexagonSpellPiece(Spell spell) {
			this.spell = spell;
		}

		public Spell getSpell() {
			return spell;
		}

		public void setConnection(Side side, int index) {
			if (connections.containsKey(side)) {
				connections.remove(side);
			}
			connections.put(side, index);
		}

		public Map<Side, Integer> getConnections() {
			return ImmutableMap.copyOf(connections);
		}
	}

	public enum Side {
		//@formatter:off
		UP_RIGHT(1, -1),
		RIGHT(1, 0),
		DOWN_RIGHT(0, 1),
		DOWN_LEFT(-1, 1),
		LEFT(-1, 0),
		UP_LEFT(0, -1);
		//@formatter:on

		private int x;
		private int y;


		Side(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
	}
}
