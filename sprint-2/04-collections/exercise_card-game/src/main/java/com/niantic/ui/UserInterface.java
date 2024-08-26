package com.niantic.ui;

import com.niantic.models.Card;
import com.niantic.models.Player;

import java.util.ArrayList;

public class UserInterface
{
    public static void displayAllPlayersCards(ArrayList<Player> players)
    {
        System.out.println("All Players");
        System.out.println("-".repeat(30));
        for (Player player : players)
        {
            displayPlayerCards(player);
        }
    }

    public static void displayPlayerCards(Player player)
    {
        System.out.println(ColorCodes.PURPLE + player.getName() + ": " + ColorCodes.RESET + ColorCodes.RED + player.getHandValue() + ColorCodes.RESET);
        for (Card card : player.getHand().getCards())
        {
            System.out.println(ColorCodes.YELLOW + "┌───────┐");
            System.out.println("│ " + card.getFaceValue() + "     │");
            System.out.println("│   " + card.getSuit() + "   │");
            System.out.println("│     " + card.getFaceValue() + " │");
            System.out.println("└───────┘"+ ColorCodes.RESET);
        }
        System.out.println();
    }

    public static void displayWinner(Player winner)
    {
        System.out.println();
        System.out.println(ColorCodes.PURPLE + "*****************************************" + ColorCodes.RESET);
        System.out.println(ColorCodes.CYAN + "           WINNER: " + winner.getName() + ColorCodes.RESET);
        System.out.println(ColorCodes.PURPLE + "*****************************************" + ColorCodes.RESET);
    }
}
