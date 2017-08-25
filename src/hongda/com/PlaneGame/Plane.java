package hongda.com.PlaneGame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import util.MyImage;

public class Plane {
	
	public int x;
	public int y;
	private int speed=5;
	private Image img;
	public int height;
	public int wide;
	public boolean left,right,up,down;
	private boolean alive=true;	
	
	public Plane(String imgpath) {		
		img=MyImage.get(imgpath);
		x=100;
		y=100;
		height=img.getHeight(null)-5;
		wide=img.getWidth(null)-5;
	}	
		
	public void draw(Graphics g){
		if(alive){
			g.drawImage(img, x, y, null);
			move();		
		}
	}	
	
	public void move(){
		
		if(left){
			if(x>=10){
			x-=speed;
			}
		}
		if(right){
			if(x<=750){
			x+=speed;
			}
		}
		if(down){
			if(y<=750){
			y+=speed;
			}
		}
		if(up){
			if(y>=35){
			y-=speed;
			}
		}
		
	}
	
	public void subDir(KeyEvent e){
		int i=e.getKeyCode();	
		switch(i){
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_A:
			left=false;
			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D:
			right=false;
			break;
		case KeyEvent.VK_UP:
		case KeyEvent.VK_W:
			up=false;
			break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_S:
			down=false;
			break;	
		}			
	}

	public void addDir(KeyEvent e){
		int i=e.getKeyCode();
		switch(i){
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_A:
			left=true;
			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D:
			right=true;
			break;
		case KeyEvent.VK_UP:
		case KeyEvent.VK_W:
			up=true;
			break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_S:
			down=true;
			break;	
		}
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public boolean getAlive() {
		return alive;
	}
}
