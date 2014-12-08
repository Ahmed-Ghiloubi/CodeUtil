/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestion_ecole_pro;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Ahmed
 */
public class ImagePanel extends JPanel{

    private BufferedImage image;

    public ImagePanel() {
       try {                
          image = ImageIO.read(getClass().getResource("contact.png"));
       } catch (IOException ex) {
            // handle exception...
       }
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this.getWidth(),this.getHeight() ,null); 
                    // see javadoc for more info on the parameters
    }
}