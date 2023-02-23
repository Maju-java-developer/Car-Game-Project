package Car_Game_Project;

import java.awt.Dimension;
import java.io.File;
import javax.swing.ImageIcon;
import processing.core.PVector;

public class EnemyCar {

    PVector position;
    Dimension screenSize;
    Dimension size;

    ImageIcon enemyCar = new ImageIcon("");
    
    float velY;
    
    public EnemyCar(float velY, Dimension screenSize) {
        this.velY = velY;
        this.screenSize = screenSize;
        size = new Dimension(40, 90);
    
        position = new PVector(
                RandomRange.randomFloat(5, screenSize.width - 75), 
                RandomRange.randomFloat(-500, -5000)
        );

        for (int i = 0; i < Defaults.carImages.length; i++) {
            Defaults.carImages[i] = Defaults.rescaleImage(size.width, size.height,
                    new File("").getAbsolutePath() + "\\src\\cars\\Car_"+(i+1)+".png");
        }
        
        updateCarPath();
        
    }
    
    public void enemyUpdate(){
        position.y += velY;

        if (position.y > screenSize.height) {
            position = new PVector(
                    RandomRange.randomFloat(0, screenSize.width - 75),
                    RandomRange.randomFloat(-500, -5000)
            );
            Defaults.score += Defaults.scoreLimit = RandomRange.randomInt(10, 15);
        }
    }

    private void updateCarPath() {
        int carPathNumber = RandomRange.randomInt(1, Defaults.carImages.length - 1);

        if (carPathNumber == 1) {
            enemyCar = Defaults.carImages[0];
        }
        
        if (carPathNumber == 2) {
            enemyCar = Defaults.carImages[1];
        }
        
        if (carPathNumber == 3) {
            enemyCar = Defaults.carImages[2];
        }
        
        if (carPathNumber == 4) {
            enemyCar = Defaults.carImages[3];
        }
        
        if (carPathNumber == 5) {
            enemyCar = Defaults.carImages[4];
        }
    }
}
