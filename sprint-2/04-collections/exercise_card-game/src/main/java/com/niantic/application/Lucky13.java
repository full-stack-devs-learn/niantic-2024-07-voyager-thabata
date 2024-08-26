package com.niantic.application;

import com.niantic.models.Card;
import com.niantic.models.Deck;
import com.niantic.models.Player;
import com.niantic.ui.ColorCodes;
import com.niantic.ui.UserInterface;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.
| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |
| |   _____      | || | _____  _____ | || |     ______   | || |  ___  ____   | || |  ____  ____  | || |     __       | || |    ______    | |
| |  |_   _|     | || ||_   _||_   _|| || |   .' ___  |  | || | |_  ||_  _|  | || | |_  _||_  _| | || |    /  |      | || |   / ____ `.  | |
| |    | |       | || |  | |    | |  | || |  / .'   \_|  | || |   | |_/ /    | || |   \ \  / /   | || |    `| |      | || |   `'  __) |  | |
| |    | |   _   | || |  | '    ' |  | || |  | |         | || |   |  __'.    | || |    \ \/ /    | || |     | |      | || |   _  |__ '.  | |
| |   _| |__/ |  | || |   \ `--' /   | || |  \ `.___.'\  | || |  _| |  \ \_  | || |    _|  |_    | || |    _| |_     | || |  | \____) |  | |
| |  |________|  | || |    `.__.'    | || |   `._____.'  | || | |____||____| | || |   |______|   | || |   |_____|    | || |   \______.'  | |
| |              | || |              | || |              | || |              | || |              | || |              | || |              | |
| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |
 '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'
 */

public class Lucky13
{
    Scanner input = new Scanner(System.in);

    public Deck deck = new Deck();
    public ArrayList<Player> players = new ArrayList<>();
    public Player winner = new Player("no winner");

    public void run()
    {
        startGame();

        boolean luckyWin = playHands();

        UserInterface.displayAllPlayersCards(players);

        if (!luckyWin)
        {
            findWinner();
        }

        UserInterface.displayWinner(winner);
    }

    public boolean playHands()
    {
        Queue<Player> queuedPlayers = new LinkedList<>(players);

        while (!queuedPlayers.isEmpty())
        {
            var player = queuedPlayers.poll();
            UserInterface.displayPlayerCards(player);

            System.out.println();
            System.out.print(ColorCodes.GREEN + "Feeling lucky? " + ColorCodes.RESET + "Hit or Stand? (H/S)");
            String response = input.nextLine()
                    .strip()
                    .toLowerCase();

            if (response.equalsIgnoreCase("h"))
            {
                Card card = deck.takeCard();
                player.dealTo(card);

                if (card.getFaceValue().equals("★"))
                {
                    winner = player;
                    return true;
                }

                if (player.getHandValue() <= 13)
                {
                    queuedPlayers.offer(player);
                }
            }
        }

        return false;
    }

    private void startGame()
    {
        addPlayers();
        dealCards();
    }

    private void findWinner()
    {
        for (Player player : players)
        {
            int points = player.getHandValue();

            if (points > winner.getHandValue() && points <= 13)
            {
                winner = player;
            }
        }
    }

    private void dealCards()
    {
        deck.shuffle();

        for (int i = 0; i < 1; i++)
        {
            for (Player player : players)
            {
                Card card = deck.takeCard();
                player.dealTo(card);
            }
        }
    }

    private void addPlayers()
    {
        players.add(new Player("Player 1"));
        players.add(new Player("Player 2"));
    }
}