import java.util.ArrayList;
import java.util.Collections;
/**
 * This class demostrate the deck of card of the game
 * @author Chow Sheung Lam
 * @version 1.0
 */
public class deck_of_card 
{   /**
    * The ArrayList deck represents the cards of tge deck of card
    */
    private static ArrayList<String> deck = new ArrayList <String> ();

    /**
     * The method of shuffle will just shuffle the cards inside the deck
     */
    public static void shuffle()
    {
        Collections.shuffle(deck);
    }
    /**
     * The method addCard will just add all the 52 poker cards into the deck
     */
    public static void addCard()
    {
        for(int i =1;i<=4;i++)
        {
            for (int j=1;j<=13;j++)
            {
                String card = String.format("images/card_%d%d.gif", i ,j);
                deck.add(card);
            }
        }
    }
    /**
     * The method draw card will allow the cards inside the deck(top of the deck) being drawn by the Dealer or Player
     * @return card
     */

    public static String drawncard()
    {
        String card  = deck.get(0);
        deck.remove(0);
        return card;
    }

    /**
    * The method of clearcard returns nothing and clear all the card inside the deck
    */
    public static void cleancard()
    {
        deck.clear();
    }

}
