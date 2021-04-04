import java.util.ArrayList;
/**
 * This class is the player of this card game, it has a private variable called cardholding which contains all cards
 * it holds. It has methods like drawcard, displaycard, clearcard and contain_c
 * @author Chow Sheung Lam
 * @version 1.0
 */

public class Player {
    /**
     *  The ArrayList of cardholding represents the cards that the Player holds
     */
    private static ArrayList<String> cardholding = new ArrayList <String> ();

    /**
    * The method of drawcard returns no value which demonstrate the player to draw card from a deck of card
    * @param card
    * 
    */
    public static void drawcard(String card)
    {
        cardholding.add(card);
    }

    /**
    * The medthod of displaycard returns a particular card that the player holds by inputinng the index number of the card in the cardholding
    * @param i
    * @return cardholding.get(i)
    */

    public static String displaycard(int i)
    {
        return cardholding.get(i);
    } 

    /**
    * The method of clearcard returns nothing and clear all the card inside the cardholding
    */
    public static void clearcard()
    {
        cardholding.clear();
    }
    /**
     * The method of changecard allow the player to change a particular card that he/she holds 
     * @param i
     * @param card
     */
    public static void changecard(int i, String card)
    {
        cardholding.set(i, card);
    }
    /**
     * The method of getcards returns the cardholding of Player
     * @return cardholding
     */
    public static ArrayList<String> getcards()
    {
        return cardholding;
    }
    /**
     * The method of contain_c determines whether the Player's cardholding has a particular card
     * @param card
     * @return true/false
     */
    public static Boolean contain_c(String card)
    {
        if(cardholding.contains(card))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
}
