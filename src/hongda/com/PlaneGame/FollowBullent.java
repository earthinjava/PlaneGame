package hongda.com.PlaneGame;

import java.awt.Color;
import java.awt.Graphics;

import util.Constant;

public class FollowBullent extends Bullet {	
	public FollowBullent(){
		x=Math.random()*Constant.MYFRAME_WIDTH/2+Constant.MYFRAME_WIDTH/2;
		y=Math.random()*Constant.MYFRAME_HEIGTH/2+Constant.MYFRAME_HEIGTH/2;
		speed=3;
		degress=Math.random()*2*Math.PI;
		c=Color.red;
		dn=5;
	}
	public void draw(Graphics g,Plane p){
		Color l=g.getColor();
		if(state==false){
			g.setColor(Color.BLUE);
		}
		else{
			g.setColor(Color.red);
		}		
		if(y>=Constant.MYFRAME_HEIGTH-dn-5||y<=30+dn/2){
			degress=-degress;
		}
		if(x>=Constant.MYFRAME_WIDTH-dn-5||x<=dn/2){
			degress=Math.PI-degress;
		}
		if(x>dn/2&&x<Constant.MYFRAME_WIDTH-dn-5&&y<Constant.MYFRAME_HEIGTH-dn-5&&y>30+dn/2){
			if(Math.abs(p.x-x)<40&&Math.abs(p.y-y)<40){
				state=false;				
			}
			if(state){
				if(p.x<=x){
					degress=Math.PI+Math.atan((y-p.y)/(x-p.x))+0.5;
				}
				if(p.x>x){
					degress=Math.atan((p.y-y)/(p.x-x))+0.5;
				}	
			}
		}		
		x+=speed*Math.cos(degress);
		y+=speed*Math.sin(degress);		
		g.fillOval((int)x,(int)y,dn,dn);
		g.setColor(l);
		
	}
}
