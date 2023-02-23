/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Car_Game_Project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Majid Hussain
 */
public class GameOverDialog extends JDialog{
    Dimension screenSize;
    
    public GameOverDialog(Dimension screenSize){
        this.screenSize = screenSize;
    }
    
    public void drawDialog(){
        intiComponends();
    }
    
    public void intiComponends(){
        setTitle("Game Over:");
        setSize(screenSize.width -(screenSize.width / 10), screenSize.height -(screenSize.height / 2));
        setLocationRelativeTo(null);
        setLayout(null);
        
        btnPanel.setBounds(0, (screenSize.height - 75) - (screenSize.height / 2), getWidth() + 15, 35);
        btnPanel.setBackground(Color.red);
        
        gameOverPanel.setBounds(0, 0, btnPanel.getWidth(), 50);
        gameOverPanel.setBackground(new Color(20, 30, 50));
        
        gameOverLbl.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        gameOverLbl.setFont(new Font("Souge UI Light", 0, 18));
        gameOverLbl.setForeground(new Color(255, 255, 255));
        
        closeBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        btnPanel.add(playAgainBtn);
        btnPanel.add(closeBtn);
    
        add(gameOverPanel);
        gameOverPanel.add(gameOverLbl);
        
        add(btnPanel);
    }
    
    public JPanel btnPanel = new JPanel(new GridLayout(1, 1));
    
    public JPanel gameOverPanel = new JPanel(new GridLayout(1, 1));
    public JLabel gameOverLbl = new JLabel("GAME OVER:");
    
    public JButton playAgainBtn = new JButton("PLAY AGAIN:");
    public JButton closeBtn = new JButton("CLOSE:");

}
