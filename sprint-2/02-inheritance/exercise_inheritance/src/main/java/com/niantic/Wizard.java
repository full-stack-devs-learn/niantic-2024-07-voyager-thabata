package com.niantic;

public class Wizard extends Character
{
    protected int mana;

    public Wizard(String name, int health, int level, int experience, int mana)
    {
        super(name, health, level, experience);
        this.mana = mana;
    }

    public int getMana()
    {
        System.out.println(this.getName() + "'s mana = " + mana + " points.");
        return mana;
    }

    public void castSpell(Character target)
    {
        if (isDefeated())
        {
            System.out.println(this.name + " has been defeated and can't cast spells.");
        }

        if (mana >= 10)
        {
            int spellDamage = attackDamage * 2;
            target.takeDamage(spellDamage);
            mana -= 10;
            System.out.println(this.name + " casts a spell on " + target.getName());
        }

        else
        {
            System.out.println(this.name + " doesn't have enough mana to cast a spell.");
        }
    }

    public void regenerateMana(int amount)
    {
        if (!isDefeated())
        {
            this.mana += amount;
            System.out.println(this.name + " regenerates mana.");
        }
    }

    @Override
    public void levelUp()
    {
        super.levelUp();
        if (!isDefeated()) regenerateMana(10);
        System.out.println(this.name + " has leveled up!");
    }

    @Override
    public String specialAbility()
    {
        return "Cast Spells";
    }
}