package Car_Game_Project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import processing.core.PVector;

public class Car_Generator extends JPanel{
    int width;
    int height;

    int delay = 10;
    Timer updateTimer = null;
    
    MovingBackground movingBackground = null;
    MyCar myCar = null;
    EnemyCar enemyCar = null;
    GameOverDialog gameOverDialog = null;
    
    ArrayList<EnemyCar> enemyCars = new ArrayList<EnemyCar>();

    public Car_Generator(int width, int height){
        this.width = width;
        this.height = height;
    }

    public void intiialize(){
        gameSetup();
        updateGame();
    }
    
    public void gameSetup(){
        movingBackground = new MovingBackground(2f, new Dimension(width, height));
        myCar = new MyCar(this);
        gameOverDialog = new GameOverDialog(new Dimension(width, height));
        CreatingEnemyCar();
    }
        
    public void CreatingEnemyCar(){
        for (int i = 0; i < 15; i++) {
            enemyCar = new EnemyCar(
                    RandomRange.randomFloat(
                            2.5f, 
                            3.5f),
                    new Dimension(width, height));
            enemyCars.add(enemyCar);
        }
    }

    int enemyCarCreateTime = 130;
    
    int minCarCreateTime = 130;
    int mixCarCreateTime = 140;
        
    public void updateNewCar(){
        enemyCarCreateTime --;

        if (enemyCarCreateTime < 0) {
            enemyCarCreateTime = RandomRange.randomInt(minCarCreateTime, mixCarCreateTime);
            CreatingEnemyCar();
        }
    }
    
    public void updateGame(){
        updateTimer = new Timer(delay, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                movingBackground.backgroundUpdate();
                myCar.carUpdate();

                for (int i = 0; i < enemyCars.size(); i++) {
                    enemyCars.get(i).enemyUpdate();
                }
//                updateNewCar();
                repaint();
                revalidate();
            }
        });
        updateTimer.start();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 

        Graphics2D graphics2D = (Graphics2D) g;

        // Draw MovingBackground:
        graphics2D.drawImage(
            movingBackground.background.getImage(), 
            (int)movingBackground.position.x,
            (int)movingBackground.position.y,
            movingBackground.size.width, 
            movingBackground.size.height, 
            null
        );
        // Draw MovingBackground:

        //-----------------------------------------
        //--------- My Car Section: ---------
        //-----------------------------------------
        Rectangle2D myCarRec = new Rectangle2D.Float(
            myCar.position.x, 
            myCar.position.y, 
            myCar.size.width,
            myCar.size.height
        );
        
        graphics2D.drawImage(
                myCar.carImage.getImage(), 
                (int)myCar.position.x, 
                (int)myCar.position.y, 
                myCar.size.width,
                myCar.size.height,
                this
        );
        // MY CAR SECTION WORK END:
        
        //----------------------------------------
        //------- ENEMY CAR Section: --------
        //----------------------------------------
        for (int i = 0; i < enemyCars.size(); i++) {
            Rectangle2D enemyCarRec = new Rectangle.Float(
                    enemyCars.get(i).position.x,
                    enemyCars.get(i).position.y, 
                    enemyCars.get(i).size.width, 
                    enemyCars.get(i).size.height       
            );

            graphics2D.drawImage(
                    enemyCars.get(i).enemyCar.getImage(), 
                    (int)enemyCars.get(i).position.x, 
                    (int)enemyCars.get(i).position.y, 
                    enemyCars.get(i).size.width, 
                    enemyCars.get(i).size.height, 
                    null
            );
                        
            graphics2D.setColor(Color.WHITE);
            graphics2D.setFont(new Font("Souge UI Light", 0, 18));
            graphics2D.drawString("SCORE: "+Defaults.score, 20, 20);
            
            if (enemyCars.get(i).position.y > height) {
                enemyCars.remove(i);
            }
            // ENEMY CAR SECTION END:
            
            // Check if Mycar Hit With EnemyCar Then Happen GameOver:
            if (myCarRec.intersects(enemyCarRec)) {
                gameOverDialog.setVisible(true);
                gameOverDialog.drawDialog();
                updateTimer.stop();
                
                gameOverDialog.playAgainBtn.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        updateTimer.start();
                        for (int j = 0; j < enemyCars.size(); j++) {
                            enemyCars.get(j).position = new PVector(
                                    RandomRange.randomFloat(0, width - 75), 
                                    RandomRange.randomFloat(-300, -4500) 
                            );
                        }
                        Defaults.score = 0;
                        gameOverDialog.dispose();
                    }
                });

            }else {
                graphics2D.setColor(Color.black);
            }
        }
    }
}
