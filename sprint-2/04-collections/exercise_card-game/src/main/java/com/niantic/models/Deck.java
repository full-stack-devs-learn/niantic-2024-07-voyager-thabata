package com.niantic.models;

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
    private final ArrayList<Card> cards;

    public Deck()
    {
        cards = new ArrayList<>();

        String[] faces = {"0","1","2","3","4","5","6","7","★"};
        String[] suits = {"♣","♦","♥","♠"};
        int[] quantities = {1, 1, 1, 1, 1, 1, 1, 1, 1};

        for(String suit : suits)
        {
            for(String face : faces)
            {
                for(int quantity : quantities)
                {
                    Card card = new Card(suit, face, quantity);
                    cards.add(card);
                }
            }
        }
    }

    public Card takeCard()
    {
        return cards.removeFirst();
    }

    public void shuffle()
    {
        Collections.shuffle(cards);
    }
}