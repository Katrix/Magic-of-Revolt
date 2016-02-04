package katrix.magicOfRevolt.spell;

import katrix.magicOfRevolt.spell.object.SpellObject;

public interface ISpellVariable<T extends Spell, V extends SpellObject>{
	
	public V getVariable();
	
	public T getSpell();
}
