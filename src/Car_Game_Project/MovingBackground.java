package Car_Game_Project;

import java.awt.Dimension;
import java.io.File;
import javax.swing.ImageIcon;
import processing.core.PVector;

public class MovingBackground {
    
    PVector position;
    Dimension size;
    Dimension screenSize;

    float velY;
    
    ImageIcon background = new ImageIcon("");
        
    public MovingBackground(float velY, Dimension screenSize) {
        this.velY = velY;
        this.screenSize = screenSize;
        position = new PVector(0, -720);
        
        size = new Dimension(screenSize.width - 15, 720 * 2);
        
        background = Defaults.rescaleImage(this.screenSize.width, this.screenSize.height,
                new File("").getAbsolutePath() + "\\src\\roadImage\\Road_Pic_1.png"
        );
    }
        
    public void backgroundUpdate(){
        position.y += velY;
        
        if (position.y > 0) { 
            position.y = -(720);
        }
    }
}
