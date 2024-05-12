import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RollingDiceGui extends JFrame{
    public RollingDiceGui(){
        super("Rolling Double Dice"); //title of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close the frame when the user clicks on the close button
        setPreferredSize(new Dimension(700, 700)); //set the size of the frame
        pack(); //pack the frame
        setResizable(false); //make the frame not resizable
        setLocationRelativeTo(null); //center the frame

        addGuiComponents();
    }

    private void addGuiComponents() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);

        // 1. Banner
        JLabel bannerImg = ImgService.loadImage("resources/banner.png");
        bannerImg.setBounds(45, 25, 600, 100);
        jPanel.add(bannerImg); //add the banner to the panel


        // 2. Dices
        JLabel diceOneImg = ImgService.loadImage("resources/dice1.png"); //load the image of the first dice
        diceOneImg.setBounds(100, 200, 200, 200); //set the position and the size of the first dice
        jPanel.add(diceOneImg); //add the first dice to the panel

        JLabel diceTwoImg = ImgService.loadImage("resources/dice1.png"); //load the image of the second dice
        diceTwoImg.setBounds(390, 200, 200, 200); //set the position and the size of the second dice
        jPanel.add(diceTwoImg); //add the second dice to the panel

        // 3. Roll Button
        Random rand = new Random(); //create a new random object
        JButton rollButton = new JButton("Roll!"); //create a new button
        rollButton.setBounds(250, 550, 200, 50); //set the position and the size of the button
        rollButton.setFocusable(false);
        rollButton.addActionListener(new ActionListener() { //add an action listener to the button

            @Override
            public void actionPerformed(ActionEvent e) {
                rollButton.setEnabled(false); //disable the button

                // roll for 3 seconds
                long startTime = System.currentTimeMillis(); //get the current time
                Thread rollThread = new Thread(new Runnable(){
                    @Override
                    public void run() {
                        long endTime = System.currentTimeMillis(); //get the current time
                        try{
                            while ((endTime - startTime)/1000F < 3) { //while 3 seconds have not passed
                                // roll dice
                                int diceOne = rand.nextInt(6) + 1; // Roll the first dice (random number between 1 and 6)
                                int diceTwo = rand.nextInt(6) + 1; // Roll the second dice (random number between 1 and 6)
                                

                                // update dice images
                                ImgService.updateImage(diceOneImg, "resources/dice" + diceOne + ".png"); //update the image of the first dice
                                ImgService.updateImage(diceTwoImg, "resources/dice" + diceTwo + ".png"); //update the image of the second dice

                                repaint();
                                revalidate(); //refresh the frame

                                // sleep thread
                                Thread.sleep(60); //sleep for 60 milliseconds
                                endTime = System.currentTimeMillis(); //get the current time
                        }

                        rollButton.setEnabled(true); //enable the button
                        
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
                );
                rollThread.start(); //start the thread
                
            }



        });
        jPanel.add(rollButton); //add the button to the panel

        this.getContentPane().add(jPanel); //add the panel to the frame
    }


    
}
