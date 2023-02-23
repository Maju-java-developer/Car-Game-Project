package Car_Game_Project;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainApp extends JFrame{

    public MainApp(){
        intiComponends();
    } 
    
    int width = 900;
    int height = 720;
    
    public void intiComponends(){
        setTitle("Car_Game");
        setSize(width, height);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1, 1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        car_Generator = new Car_Generator(width, height);
        car_Generator.setBackground(Color.red);
        car_Generator.intiialize();
        
        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                // Left Button Action:
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    car_Generator.myCar.leftMove = true;
                    car_Generator.myCar.rightMove = false;
                    car_Generator.myCar.upMove = false;
                    car_Generator.myCar.downMove = false;
                }
                
                // Right Button Action:
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    
                    car_Generator.myCar.leftMove = false;
                    car_Generator.myCar.rightMove = true;
                    car_Generator.myCar.upMove = false;
                    car_Generator.myCar.downMove = false;
                }
                
                // Up Button Action:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    car_Generator.myCar.leftMove = false;
                    car_Generator.myCar.rightMove = false;
                    car_Generator.myCar.upMove = true;
                    car_Generator.myCar.downMove = false;
                }

                // Down Button Action:
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    car_Generator.myCar.leftMove = false;
                    car_Generator.myCar.rightMove = false;
                    car_Generator.myCar.upMove = false;
                    car_Generator.myCar.downMove = true;
                }
                
                repaint();
                revalidate();

            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Left Button Action:
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    car_Generator.myCar.leftMove = true;
                    car_Generator.myCar.rightMove = false;
                    car_Generator.myCar.upMove = false;
                    car_Generator.myCar.downMove = false;
                }
                
                // Right Button Action:
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    
                    car_Generator.myCar.leftMove = false;
                    car_Generator.myCar.rightMove = true;
                    car_Generator.myCar.upMove = false;
                    car_Generator.myCar.downMove = false;
                }
                
                // Up Button Action:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    car_Generator.myCar.leftMove = false;
                    car_Generator.myCar.rightMove = false;
                    car_Generator.myCar.upMove = true;
                    car_Generator.myCar.downMove = false;
                }

                // Down Button Action:
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    car_Generator.myCar.leftMove = false;
                    car_Generator.myCar.rightMove = false;
                    car_Generator.myCar.upMove = false;
                    car_Generator.myCar.downMove = true;
                }
                
                repaint();
                revalidate();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                car_Generator.myCar.leftMove = false;
                car_Generator.myCar.rightMove = false;
                car_Generator.myCar.upMove = false;
                car_Generator.myCar.downMove = false;
            }
        });
        
        add(car_Generator);
    }
    
    private Car_Generator car_Generator = null;
    
    public static void main(String[] args) {
        new MainApp().setVisible(true);
    }
}
