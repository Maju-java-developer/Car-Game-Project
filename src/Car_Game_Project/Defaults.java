package Car_Game_Project;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Defaults {
    
    public static ImageIcon rescaleImage(int width, int height, String path){
        ImageIcon icon = new ImageIcon(
                new ImageIcon(path)
                        .getImage().
                        getScaledInstance(width,
                                height, 
                                Image.SCALE_SMOOTH)
        );
        return icon;
    }
    
    // INSTANCES:
    public static int score = 0;
    public static int scoreLimit;
    public static ImageIcon carImages[] = new  ImageIcon[5];
    // INSTANCES:
    
}
