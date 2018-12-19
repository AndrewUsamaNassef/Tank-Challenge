/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author Andrew
 */
public class Bullet2 implements Runnable{
    public Point pos=new Point();
    public Color CurrentColor;
    public int Speed;
    public String imgPath;
    public Tank ta;
    public int score;
    public Bullet2()
    {
        Speed=1;
        score=0;
    }
    public  void  move()
    {
        pos.y+=Speed;
    }

    @Override
    public void run() 
    {
         for (int i=0;i<400;i++)
        {
            //System.out.println("Rocket Moving " +pos.y);
            move();
            if (pos.distance(ta.pos.x, ta.pos.y)<=100)
            {
            	score++;
                System.out.println("Score of Tank 2:");
                System.out.println(score);
                break;
                
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                
            }  
        }
    }
    
}
