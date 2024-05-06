package deckOfCards;

import javax.swing.JOptionPane;
import java.util.Random;


public class Main
{

    public static void main(String[] args)
    {
        String[] deckOfCards = theDeck();
        displayTheDeck(deckOfCards);
    }

    public static String[] theDeck()
    {
        String[] theDeck;

        theDeck = createDeck(52);

        theDeck = numberTheCards(theDeck);

        theDeck = addNumberValueToEachCard(theDeck);

        theDeck = addSuitsToCards(theDeck);

        theDeck = shuffleTheDeck(theDeck);

        return theDeck;
    }

    public static String[] createDeck(int numCards)
    {
        String[] deck = new String[numCards];

        return deck;
    }

    public static String[] numberTheCards(String[] theDeck)
    {
        for (int n = 0; n < theDeck.length; n++)
        {
            theDeck[n] = Integer.toString(n + 1);
        }

        return theDeck;
    }

    public static String[] addSuitsToCards(String[] theDeck)
    {
        String[] suits = {"clubs", "diamonds", "hearts", "spades"};
        int numCardsInASuit = 13;

        for (int n = 0; n < theDeck.length; n++)
        {
            theDeck[n] = theDeck[n] + " " + suits[n / numCardsInASuit];
        }
        return theDeck;
    }

    public static String[] addNumberValueToEachCard(String[] theDeck)
    {
        for (int n = 0; n < theDeck.length; n++)
        {
            int value = n % 13 + 1;
            if (value == 1) {
                theDeck[n] = "ace ";
            } else if (value == 11) {
                theDeck[n] = "jack ";
            } else if (value == 12) {
                theDeck[n] = "queen ";
            } else if (value == 13) {
                theDeck[n] = "king ";
            } else {
                theDeck[n] = value + " ";
            }

        }

        return theDeck;
    }

    public static void displayTheDeck(String[] deck)
    {
        String message = " ";

        for (int n=0;n<deck.length;n++)
        {
            if(n%13==0 && n>0)
            {
                message +="\n";
            }

            message += deck[n] + "    ";
        }

        JOptionPane.showMessageDialog(null, message.toString());
    }

    public static String[] shuffleTheDeck(String[] theDeck)
    {
        String[] theShuffledDeck = new String[theDeck.length];
        Random rand = new Random();

        for (int n = 0; n < theDeck.length; n++)
        {
            int p = rand.nextInt(theDeck.length);

            while (theDeck[p].equals("-1"))
            {
                p++;
                if (p == theDeck.length)
                {
                    p = 0;
                }
            }
            theShuffledDeck[n] = theDeck[p];
            theDeck[p] = "-1";
        }
        return theShuffledDeck;
    }

}
		  
		