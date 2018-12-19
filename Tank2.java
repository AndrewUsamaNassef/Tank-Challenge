/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Point;

/**
 *
 * @author Andrew
 */
public class Tank2 {
    public Point pos=new Point();
    public String ImagePath;
    public Bullet2 bullet = new Bullet2();
    
    public int speed;

    public Tank2(String ImagePath) 
    {
        speed=5;
        this.ImagePath=ImagePath;
        bullet.imgPath="c:\\rocket2.gif";

    }
    
    void mover()
    {
        this.pos.x+=speed;
    }
    void movel() 
    {
        this.pos.x-=speed;
    }
    void connect(Tank t){
    	bullet.ta=t;
    }
    public void fireBullet2() 
    {
        bullet.pos.x=this.pos.x+60;
        bullet.pos.y=this.pos.y;
        Thread t1=new Thread (bullet);
        t1.start();
    }
}
