package com.niantic.models;

import java.util.HashMap;
import java.util.Map;

public class Card
{
    private String suit;
    private String faceValue;
    private int quantity;

    public Card(String suit, String faceValue, int quantity)
    {
        this.suit = suit;
        this.faceValue = faceValue;
        this.quantity =  quantity;
    }

    public String getSuit()
    {
        return suit;
    }

    public String getFaceValue()
    {
        return faceValue;
    }

    public int getPointValue()
    {
        return cardValues.get(faceValue);
    }

    private static final Map<String, Integer> cardValues = new HashMap<>()
    {{
        put("0", 0);
        put("1", 1);
        put("2", 2);
        put("3", 3);
        put("4", 4);
        put("5", 5);
        put("6", 6);
        put("7", 7);
        put("★", 13);
    }};
}