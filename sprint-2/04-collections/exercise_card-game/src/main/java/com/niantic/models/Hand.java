package com.niantic.models;

import java.util.ArrayList;

public class Hand
{
    private ArrayList<Card> cards = new ArrayList<>();

    public ArrayList<Card> getCards()
    {
        return cards;
    }

    public int getPointValue()
    {
        int sum = cards.stream()
                .map(Card::getPointValue)
                .reduce(0, Integer::sum);
        return sum;
    }

    public void dealTo(Card card)
    {
        cards.add(card);
    }
}
