import java.awt.Dimension;

import javax.swing.JFrame;

public class RollingDiceGui extends JFrame{
    public RollingDiceGui(){
        super("Rolling Double Dice"); //title of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close the frame when the user clicks on the close button
        setPreferredSize(new Dimension(700, 700)); //set the size of the frame
        pack(); //pack the frame
        setResizable(false); //make the frame not resizable
        setLocationRelativeTo(null); //center the frame
        
;
    }

    
}
