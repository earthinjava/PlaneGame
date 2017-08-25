package hongda.com.PlaneGame;

import java.awt.Color;
import java.awt.Graphics;

import util.Constant;

public class Bullet {
	public double x;
	public double y;
	public double speed;
	public double degress;
	public Color c;
	public int dn;
	public boolean state=true;
	
	public Bullet(){
		x=Constant.MYFRAME_WIDTH/2;
		y=Constant.MYFRAME_HEIGTH/2;
		speed=5;
		degress=Math.random()*2*Math.PI;
		c=Color.blue;
		dn=5;
	}
	public Bullet(int i){
		x=Constant.MYFRAME_WIDTH/2;
		y=Constant.MYFRAME_HEIGTH/2;
		speed=10;
		degress=Math.random()*2*Math.PI;
		c=Color.blue;
		dn=5;
	}
	
	public void draw(Graphics g){
		Color l=g.getColor();
		g.setColor(c);
		g.fillOval((int)x,(int)y,dn,dn);
		g.setColor(l);
		if(y>=Constant.MYFRAME_HEIGTH-dn-5||y<=30+dn/2){
			degress=-degress;
		}
		if(x>=Constant.MYFRAME_WIDTH-dn-5||x<=dn/2){
			degress=Math.PI-degress;
		}
		x+=speed*Math.cos(degress);
		y+=speed*Math.sin(degress);
	}
	
	
}
