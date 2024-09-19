package com.niantic.models;

import java.util.HashMap;
import java.util.Map;

public class Card implements Comparable<Card> {
    private String suit;
    private String faceValue;

    public Card(String suit, String faceValue) {
        this.suit = suit;
        this.faceValue = faceValue;
    }

    public String getSuit() {
        return suit;
    }

    public String getFaceValue() {
        return faceValue;
    }

    public int getPointValue() {
        return cardValues.get(faceValue);
    }

    public String getColor() {
        switch (suit.toLowerCase()) {
            case "hearts":
            case "diamonds":
                return "Red";
            default:
                return "Black";
        }
    }

    // lookup map by card value
    private static final Map<String, Integer> cardValues = new HashMap<>() {{
        put("A", 11);
        put("K", 10);
        put("Q", 10);
        put("J", 10);
        put("10", 10);
        put("9", 9);
        put("8", 8);
        put("7", 7);
        put("6", 6);
        put("5", 5);
        put("4", 4);
        put("3", 3);
        put("2", 2);
    }};

    //putting J, Q, K  in order
    private static final Map<String, Integer> faceValueOrder = new HashMap<>()
    {{
        put("2", 2);
        put("3", 3);
        put("4", 4);
        put("5", 5);
        put("6", 6);
        put("7", 7);
        put("8", 8);
        put("9", 9);
        put("10", 10);
        put("J", 11);
        put("Q", 12);
        put("K", 13);
        put("A", 14);
    }};

    @Override
    public int compareTo(Card o)
    {
        Map<String, Integer> suitOrder = new HashMap<>();
        suitOrder.put("spades", 1);
        suitOrder.put("hearts", 2);
        suitOrder.put("diamonds", 3);
        suitOrder.put("clubs", 4);

        int suitComparison = Integer.compare(suitOrder.get(this.suit.toLowerCase()),
                suitOrder.get(o.getSuit().toLowerCase()));

        if (suitComparison != 0)
        {
            return suitComparison;
        }

        int faceValueComparison = Integer.compare(faceValueOrder.get(this.faceValue),
                faceValueOrder.get(o.getFaceValue()));

        return faceValueComparison;
    }
}