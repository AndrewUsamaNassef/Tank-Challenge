/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author ASUS
 */
public class MovingBalls extends JPanel implements Runnable{

   public ArrayList<Ball>Balls=new ArrayList<>(5);
   public Tank BlueTank=new Tank("c:\\TankBlueS.jpg");
   public Tank2 tank= new Tank2("c:\\tank.jpg");
    public MovingBalls()
    {
    	BlueTank.connect(tank);
    	tank.connect(BlueTank);
    			
        setSize(600,600);
        setBackground(Color.red);
        BlueTank.pos.x=220;
        BlueTank.pos.y=340;
        tank.pos.x=220;
        tank.pos.y=20;
        this.addKeyListener(new keylist());
        
        
    }
    private class keylist implements KeyListener
    {

        @Override
        public void keyTyped(KeyEvent e) {
           
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //System.out.println("Test");
            if (e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                
                BlueTank.mover();
                
            }
            if (e.getKeyCode()==KeyEvent.VK_D)
            {
                
                tank.mover();
                
            }
            if (e.getKeyCode()==KeyEvent.VK_LEFT)
            {
                
                BlueTank.movel();
                //repaint();
            }
            if (e.getKeyCode()==KeyEvent.VK_A)
            {
                
                tank.movel();
                //repaint();
            }
            if (e.getKeyCode()==KeyEvent.VK_SPACE)
            {
                
                BlueTank.fireBullet();
            }
            if (e.getKeyCode()==KeyEvent.VK_ALT)
            {
                
                tank.fireBullet2();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
           
        }
    }
    public void  paintComponent(Graphics g)
    {
        g.clearRect(0, 0, 600, 600);
        
        try
        {
        BufferedImage imgtank = ImageIO.read(new File(BlueTank.ImagePath));
        BufferedImage imgrocket = ImageIO.read(new File(BlueTank.Rocket.imgPath));
        g.drawImage(imgtank, BlueTank.pos.x, BlueTank.pos.y,null);
        g.drawImage(imgrocket, BlueTank.Rocket.pos.x, BlueTank.Rocket.pos.y,null);
        BufferedImage imgtank2 = ImageIO.read(new File(tank.ImagePath));
        BufferedImage imgrocket2 = ImageIO.read(new File(tank.bullet.imgPath));
        g.drawImage(imgtank2, tank.pos.x, tank.pos.y,null);
        g.drawImage(imgrocket2, tank.bullet.pos.x, tank.bullet.pos.y,null);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        
   
        }
        
    
    @Override
    public void run() {
    try
    {
    while(true)
    {
        for (Ball OneBall: Balls)
        {
            OneBall.move(this.getWidth());
        }    
        
        //y+=10;
        Thread.sleep(50);
        repaint();
    }
    }
    catch (InterruptedException e)
    {}
    }
    
}
