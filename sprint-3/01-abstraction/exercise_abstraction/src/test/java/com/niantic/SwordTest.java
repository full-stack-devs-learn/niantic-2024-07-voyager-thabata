package com.niantic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwordTest
{
    private Sword sword;

    @BeforeEach
    public void setUp()
    {
        sword = new Sword("TestSword", 10);
    }

    @Test
    public void attack_whenCalled_shouldReturnDefaultDamage()
    {
        int damage = sword.attack();
        assertEquals(10, damage);
    }

    @Test
    public void attack_whenCalled_shouldIncreasePercentChargedByTen()
    {
        assertEquals(0, sword.getPercentCharged());

        sword.attack();
        assertEquals(10, sword.getPercentCharged());

        sword.attack();
        assertEquals(20, sword.getPercentCharged());

        sword.attack();
        assertEquals(30, sword.getPercentCharged());
    }

    @Test
    public void attack_whenCalled_percentChargedShouldNotExceedOneHundred()
    {
        for (int i = 0; i < 13; i++)
        {
            sword.attack();
        }
        assertEquals(100, sword.getPercentCharged());
    }

    @Test
    public void powerAttack_whenPercentChargedLessThanFifty_shouldReturnDefaultDamage()
    {
        sword.attack();
        sword.attack();
        sword.attack();
        sword.attack();

        int damage = sword.powerAttack();
        assertEquals(10, damage);
        assertEquals(40, sword.getPercentCharged());
    }

    @Test
    public void powerAttack_whenPercentChargedBetweenFiftyAndNinety_shouldReturnDoubleDamage()
    {
        for (int i = 0; i < 8; i++)
        {
            sword.attack();
        }
        assertEquals(80, sword.getPercentCharged());

        int damage = sword.powerAttack();
        assertEquals(20, damage);
        assertEquals(30, sword.getPercentCharged());
    }

    @Test
    public void powerAttack_whenPercentChargedIsHundred_shouldReturnQuadrupleDamage()
    {
        for (int i = 0; i < 10; i++)
        {
            sword.attack();
        }
        assertEquals(100, sword.getPercentCharged());

        int damage = sword.powerAttack();
        assertEquals(40, damage);
        assertEquals(0, sword.getPercentCharged());
    }
}