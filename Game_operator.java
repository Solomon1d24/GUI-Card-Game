import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
/**
 * The class Game_operator is the drive of the game, it holds the objects of the game such as player, dealer, deck_of_card and winner_generator
 * Besides, it also contains some private insrtances such as card_change, mony, bet2, start_game and Game_over
 * @author Chow Sheung Lam
 * @version 1.0
 */

public class Game_operator{
    private int card_change = 0;
    private int money = 100;
    private int bet2 = 0;
    private Boolean b1_press = false;
    private Boolean b2_press = false;
    private Boolean b3_press = false;
    private Boolean start_game = false;
    private Boolean Game_over = false;
    Player p = new Player();
    Dealer d = new Dealer();
    deck_of_card deck = new deck_of_card();
    Winner_generator w = new Winner_generator();
    /**
     * The method main execute the whole game
     * @param args
     */
    public static void main(String[] args){
        Game_operator gui = new Game_operator();
        gui.go();
    }
    /**
     * The method go() starts the whole game
     */

    public void go(){

        JLabel label_Image1 = new JLabel();
        JLabel label_Image2 = new JLabel();
        JLabel label_Image3 = new JLabel();
        JLabel label_Image4 = new JLabel();
        JLabel label_Image5 = new JLabel();
        JLabel label_Image6 = new JLabel();
        JButton btn_rpcard1 = new JButton("Replace Card 1");
        /**
         * The actionlistener of btn_rpcard1 below allows the card1 to be re-drawn once only
         */
        btn_rpcard1.addActionListener(new ActionListener()
        {   
            public void actionPerformed(ActionEvent e)
            {   if(card_change <2 && b1_press == false && start_game == true && Game_over== false)
                {
                p.changecard(0, deck.drawncard());
                ImageIcon temp4 = new ImageIcon(p.displaycard(0));
                label_Image4.setIcon(temp4);
                card_change ++;
                b1_press = true;
                }
            }

        });
        JButton btn_rpcard2 = new JButton("Replace Card 2");
        /**
         * The actionlistener of btn_rpcard2 below allows the card2 to be re-drawn once only
         */
        btn_rpcard2.addActionListener(new ActionListener()
        {   
            public void actionPerformed(ActionEvent e)
            {   if(card_change <2 && b2_press == false && start_game == true && Game_over== false)
                {   p.changecard(1, deck.drawncard());
                    ImageIcon temp5 = new ImageIcon(p.displaycard(1));
                    label_Image5.setIcon(temp5);
                    card_change ++;
                    b2_press = true;
                }
            }

        });
        JButton btn_rpcard3 = new JButton("Replace Card 3");
        /**
         * The actionlistener of btn_rpcard3 below allows the card3 to be re-drawn once only
         */
        btn_rpcard3.addActionListener(new ActionListener()
        {   
            public void actionPerformed(ActionEvent e)
            {   if (card_change <2 && b3_press == false && start_game == true && Game_over== false)
                {   p.changecard(2,deck.drawncard());
                    ImageIcon temp6 = new ImageIcon(p.displaycard(2));
                    label_Image6.setIcon(temp6);
                    card_change ++;
                    b3_press = true;
                }
            }

        });
        JButton btn_start   = new JButton("Start");
        JButton btn_result  = new JButton("Result");

    
        JLabel label_bet = new JLabel("Please place your bet!");
        JLabel label_info = new JLabel("Amount of money you have:$100");
        JTextField txt_inputbet = new JTextField(10);

        ImageIcon Image1 = new ImageIcon("images/card_back.gif");
        ImageIcon Image2 = new ImageIcon("images/card_back.gif");
        ImageIcon Image3 = new ImageIcon("images/card_back.gif");
        ImageIcon Image4 = new ImageIcon("images/card_back.gif");
        ImageIcon Image5 = new ImageIcon("images/card_back.gif");
        ImageIcon Image6 = new ImageIcon("images/card_back.gif");
        /**
         * The actionlistener of btn_start below allows a round of the game to start while the game is not over
         * Otherwise this round of game won't start.
         * @exception IOException Oninput error.
         * @seeIOException
         */
        btn_start.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {   
                int bet = -1;
                if(Game_over == false && start_game == false)
                {    try{
                        bet = Integer.parseInt(txt_inputbet.getText());
                        bet2 = Integer.parseInt(txt_inputbet.getText());
                        if (bet <= 0)
                        {
                            String message = "The bet you place must be a positive integer!";
                            JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else if(bet > money){
                            String message = "Warning: You only have $" + money + "!";
                            JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                        {  
                            card_change = 0;
                            b1_press = false;
                            b2_press = false;
                            b3_press = false;
                            start_game = true;
                            label_bet.setText("You current bet is: $"+txt_inputbet.getText());
                            deck.addCard();
                            deck.shuffle();
                            p.drawcard(deck.drawncard());
                            p.drawcard(deck.drawncard());
                            p.drawcard(deck.drawncard());
                            d.drawcard(deck.drawncard());
                            d.drawcard(deck.drawncard());
                            d.drawcard(deck.drawncard());
                            ImageIcon temp4 = new ImageIcon(p.displaycard(0));
                            ImageIcon temp5 = new ImageIcon(p.displaycard(1));
                            ImageIcon temp6 = new ImageIcon(p.displaycard(2));
                            label_Image4.setIcon(temp4);
                            label_Image5.setIcon(temp5);
                            label_Image6.setIcon(temp6);
                            
                        }
                    }
                    catch(Exception error)
                    {
                        String message = "The bet you place must be a positive integer!";
                        JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        /**
         * The actionlistener of the btn_result will show the results of the game in this round and will make the 
         * game over if the money that the player holds equals to zero.
         */
        btn_result.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {   if(Game_over== false && start_game ==true)
                {   ImageIcon temp1 = new ImageIcon(d.displaycard(0));
                    ImageIcon temp2 = new ImageIcon(d.displaycard(1));
                    ImageIcon temp3 = new ImageIcon(d.displaycard(2));
                    label_Image1.setIcon(temp1);
                    label_Image2.setIcon(temp2);
                    label_Image3.setIcon(temp3);
                    w.getPlayerscard(p, d);
                    boolean dwin = w.determinewinner();
                    if(dwin == true)
                    {
                        String message = "Sorry! The Dealer wins this round!";
                        JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);
                        money = money - bet2;
                        label_bet.setText("Please place your bet!");
                        label_info.setText("Amount of money you have: $" + money);
                        ImageIcon Image1 = new ImageIcon("images/card_back.gif");
                        ImageIcon Image2 = new ImageIcon("images/card_back.gif");
                        ImageIcon Image3 = new ImageIcon("images/card_back.gif");
                        ImageIcon Image4 = new ImageIcon("images/card_back.gif");
                        ImageIcon Image5 = new ImageIcon("images/card_back.gif");
                        ImageIcon Image6 = new ImageIcon("images/card_back.gif");
                        label_Image1.setIcon(Image1);
                        label_Image2.setIcon(Image2);
                        label_Image3.setIcon(Image3);
                        label_Image4.setIcon(Image4);
                        label_Image5.setIcon(Image5);
                        label_Image6.setIcon(Image6);
                        d.clearcard();
                        p.clearcard();
                        deck.cleancard();
                        if(money <=0)
                        {
                            String message2 = "You have no more money!\n" + "Please start a new game!\n";
                            JOptionPane.showMessageDialog(null, message2, "Message", JOptionPane.INFORMATION_MESSAGE);
                            label_bet.setText("You have no more money!");
                            label_info.setText("Please start a new game!");
                            Game_over = true;
                            d.clearcard();
                            p.clearcard();
                            deck.cleancard();
                        }
                        start_game = false;
                    }
                    else if(dwin == false)
                    {
                        String message = "Congrauations! You win this round!";
                        JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);
                        money = money + bet2;
                        label_bet.setText("Please place your bet!");
                        label_info.setText("Amount of money you have: $" + money);
                        ImageIcon Image1 = new ImageIcon("images/card_back.gif");
                        ImageIcon Image2 = new ImageIcon("images/card_back.gif");
                        ImageIcon Image3 = new ImageIcon("images/card_back.gif");
                        ImageIcon Image4 = new ImageIcon("images/card_back.gif");
                        ImageIcon Image5 = new ImageIcon("images/card_back.gif");
                        ImageIcon Image6 = new ImageIcon("images/card_back.gif");
                        label_Image1.setIcon(Image1);
                        label_Image2.setIcon(Image2);
                        label_Image3.setIcon(Image3);
                        label_Image4.setIcon(Image4);
                        label_Image5.setIcon(Image5);
                        label_Image6.setIcon(Image6);
                        d.clearcard();
                        p.clearcard();
                        deck.cleancard();
                        start_game = false;
                    }
                    d.clearcard();
                    p.clearcard();
                    deck.cleancard();
                }
            }
        });
      
        label_Image1.setIcon(Image1);
        label_Image2.setIcon(Image2);
        label_Image3.setIcon(Image3);
        label_Image4.setIcon(Image4);
        label_Image5.setIcon(Image5);
        label_Image6.setIcon(Image6);
    
        JPanel MainPanel = new JPanel();
        JPanel DealerPanel = new JPanel();
        JPanel PlayerPanel = new JPanel();
        JPanel RpCardBtnPanel = new JPanel();
        JPanel ButtonPanel = new JPanel();
        JPanel InfoPanel = new JPanel();
    
        DealerPanel.add(label_Image1);
        DealerPanel.add(label_Image2);
        DealerPanel.add(label_Image3);
        PlayerPanel.add(label_Image4);
        PlayerPanel.add(label_Image5);
        PlayerPanel.add(label_Image6);
        RpCardBtnPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.5;
        RpCardBtnPanel.add(btn_rpcard1, c);
        c.gridx = 1;
        RpCardBtnPanel.add(btn_rpcard2, c);
        c.gridx = 2;
        RpCardBtnPanel.add(btn_rpcard3, c);
        ButtonPanel.add(new JLabel("Bet:$ "));
        ButtonPanel.add(txt_inputbet);
        ButtonPanel.add(btn_start);
        ButtonPanel.add(btn_result);
        InfoPanel.add(label_bet);
        InfoPanel.add(label_info);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Control");
        JMenu menu2 = new JMenu("Help"); 
        JMenuItem menuItem2 = new JMenuItem("Instruction");
        /**
         * The actionlistener of the menuItem2 allows the player to read the instruction of the game once
         * the player clicekd thje instruction menuitem object.
         */
        menuItem2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                String message = "J, Q, K are regarded as special cards.\n" + "Rule 1: The one with more special cards wins.\n" + "Rule 2: If both have the same number of special cards, add the face values of the other card(s) and take the remainder after dividing the sum by 10. The one with a bigger remainder wins. (Note: Ace = 1).\n" ;
                String message2 = "Rule 3: The dealer wins if both rule 1 and rule 2 cannot distinguish the winner.";
                message = message + message2; 
                JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        /**
         * The actionlistener of the menuItem allows the player to exit from the game once the player clicks
         * the Exit menuItem object.
         */
        JMenuItem menuItem = new JMenuItem("Exit");
        menuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(menuItem);
        menu2.add(menuItem2);
        menuBar.add(menu);
        menuBar.add(menu2);

        MainPanel.setLayout(new GridLayout(5,1)); 
        MainPanel.add(DealerPanel);
        MainPanel.add(PlayerPanel);
        MainPanel.add(RpCardBtnPanel);
        MainPanel.add(ButtonPanel);
        MainPanel.add(InfoPanel);

        DealerPanel.setBackground(Color.green); 
        PlayerPanel.setBackground(Color.green); 
        RpCardBtnPanel.setBackground(Color.green);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(MainPanel);
        frame.setTitle("A Simple Card Game");
        frame.setSize(400, 700);
        frame.setVisible(true);
    }
}