package Car_Game_Project;

import java.awt.Dimension;
import java.io.File;
import javax.swing.ImageIcon;
import processing.core.PVector;

public class MyCar {
    PVector position = null;
    Dimension size;
    Dimension screenSize;
    
    ImageIcon carImage = new ImageIcon("");
    
    float carVelecity = 3.0f;
    
    public MyCar(Car_Generator car_Generator) {
        position = new PVector(car_Generator.width / 2, car_Generator.height - 190);
        size = new Dimension(40, 90);
        screenSize = new Dimension(car_Generator.width, car_Generator.height);
        
        carImage = Defaults.rescaleImage(size.width, size.height, 
                new File("").getAbsolutePath() +"\\src\\cars\\myCar.png"
        );
        
    }
    
    boolean rightMove, leftMove, upMove, downMove;
    
    public void carUpdate(){
        if (leftMove) {
            if (position.x > 5) {
                position.x -= carVelecity;
            }
        }
        
        if (rightMove) {
            if (position.x < screenSize.width - 65) {
                position.x += carVelecity;
            }
        }
        
        if (upMove) {
            if (position.y > 0) {
                position.y -= carVelecity;
            }
        }
        
        if (downMove) {
            if (position.y < (screenSize.height - size.height - 40)) {
                position.y += carVelecity;
            }
        }
    }
}