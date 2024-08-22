package com.niantic;

public class Knight extends Character
{
    protected int armor;

    public Knight(String name, int health, int level, int experience, int armor) {
        super(name, health, level, experience);
        this.armor = armor;
    }

    public int getArmor()
    {
        System.out.println(this.getName() + "'s armor = " + armor + " points.");
        return armor;
    }
    private void armor(int i) {
    }

    @Override
    public void takeDamage(int damage)
    {
        if (damage <= armor)
        {
            System.out.println(this.name + "'s armor deflected the attack! 0 damage taken.");
        }
        else
        {
            int remainingDamage = damage - armor;
            this.health -= remainingDamage;

            if (isDefeated())
            {
                System.out.println(this.name + " has been defeated!");
            }
            else
            {
                System.out.println(this.name + "'s armor deflected some damage. " + this.name + " takes " + remainingDamage + " damage.");
            }
        }
    }

    @Override
    public void levelUp()
    {
        super.levelUp();
        if (!isDefeated()) armor(5);
        System.out.println(this.name + " has leveled up!");
    }

    @Override
    public String specialAbility()
    {
        return "Armor Shield";
    }
}
