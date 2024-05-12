import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImgService {
    public static JLabel loadImage(String filePath){
        BufferedImage image;
        JLabel imageContainer;
        try{
            InputStream inputStream = ImgService.class.getResourceAsStream(filePath);
            image = ImageIO.read(inputStream); // read image from file
            imageContainer = new JLabel(new ImageIcon(image)); // put image into a JLabel
            return imageContainer; // return the JLabel
        } catch (IOException e){
            System.out.println("Error: " + e); // print error if there is one
            return null; // return null if there is an error


        }

    }

    public static void updateImage(JLabel imageContainer, String filePath){ // update image
        BufferedImage image; // create a new BufferedImage
        try{
            InputStream inputStream = ImgService.class.getResourceAsStream(filePath); // get the file
            image = ImageIO.read(inputStream); // read the image
            imageContainer.setIcon(new ImageIcon(image)); // set the image
        } catch (IOException e){
            System.out.println("Error: " + e); // print error if there is one
        }




        }




    
}
