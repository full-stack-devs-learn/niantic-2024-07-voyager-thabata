package com.niantic;

public class Sword extends Weapon
{
    private String name;
    private int damage;

    public Sword(String name, int damage)
    {
        super(name, damage);
        this.name = name;
        this.damage = damage;
    }

    @Override
    public int attack()
    {
        if (getPercentCharged() < 100)
        {
            setPercentCharged(getPercentCharged() + 10);
            if (getPercentCharged() > 100)
            {
                setPercentCharged(100);
            }
        }
        return getDamage();
    }

    @Override
    public int powerAttack()
    {
        if (getPercentCharged() < 50)
        {
            return getDamage();
        }
        else if (getPercentCharged() >= 50 && getPercentCharged() <= 90)
        {
            setPercentCharged(getPercentCharged() - 50);
            return getDamage() * 2;
        }
        else
        {
            setPercentCharged(0);
            return getDamage() * 4;
        }
    }

    @Override
    public int getRange() {
        return 1;
    }
}