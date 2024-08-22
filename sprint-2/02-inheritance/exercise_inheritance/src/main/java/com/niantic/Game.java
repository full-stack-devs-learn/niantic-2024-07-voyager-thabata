package com.niantic;

import com.niantic.Knight;
import com.niantic.Character;

public class Game
{
    public static void main(String[] args)
    {
        Knight hero = new Knight("Taylor Swift", 50, 1, 100,2);
        Character villain = new Character("The Smallest Man Who Ever Lived", 50,1,100);

        villain.attack(hero);
        hero.attack(villain);
        villain.attack(hero);
        hero.attack(villain);

        hero.getArmor();
        hero.levelUp();
        hero.getArmor();

        hero.attack(villain);
    }
}