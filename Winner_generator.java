import java.util.ArrayList;
import java.util.Collections;
/**
 * This class will generate the winner of the card game, it has a player object and a dealer object respectively
 * @author Chow Sheung Lam
 * @version 1.0
 */
public class Winner_generator {
    Player p = new Player();
    Dealer d = new Dealer();
    /**
     * The method of getPlayerscard allows the winner_generaotr to assign it's own player and dealer object 
     * @param p
     * @param d
     */
    public void getPlayerscard(Player p, Dealer d)
    {
        this.p = p;
        this.d = d;
    }
    /**
     * The method of determinewinner allows the winner generator to returns the winner of the card game in this term
     * if it returns true, that means the dealer wins else then the player wins
     * @return dwins
     */

    public Boolean determinewinner()
    {   Boolean dwins = true;
        int p_special_c = 0;
        int d_special_c = 0;
        int p_points = 0;
        int d_points = 0;
        for(int i=1;i<=4;i++)
        {
            for(int j=11;j<=13;j++)
            {
                String s_c = String.format("images/card_%d%d.gif", i,j);
                if(p.contain_c(s_c) == true)
                {
                    p_special_c  +=1;
                }
                if(d.contain_c(s_c) == true)
                {
                    d_special_c  += 1;
                }
            }
        }
        if (d_special_c > p_special_c)
        {
            return true;
        }
        else if(p_special_c > d_special_c)
        {
            return false;
        }
        else
        {
            for(int i =1;i<=4;i++)
            {
                for(int j=1;j<=10;j++)
                {
                    String n_c = String.format("images/card_%d%d.gif", i,j);
                    if(p.contain_c(n_c) == true)
                    {
                        p_points += j;
                    }
                    if(d.contain_c(n_c) == true)
                    {
                        d_points += j;
                    }
                }
            }
            p_points = p_points%10;
            d_points = d_points%10;

            if(p_points > d_points)
            {
                return false;
            }
        }
        return dwins;
    }

}
