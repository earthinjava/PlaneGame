package util;

public class Rect{
	private int x;
	private int y;
	private int heigh;
	private int wide;
	
	public Rect(int x,int y,int heigh,int wide){
		this.setX(x);
		this.setY(y);
		this.setHeigh(heigh);
		this.setWide(wide);
	}
	
	public Rect get(int x,int y,int height,int wide){
		Rect r=new Rect(x,y,height,wide);
		return r;
	}
	
	public  boolean inof(Rect r){
		if(r.getX()<=x+wide&&r.getX()+r.getWide()>=x){
			if(r.getY()<=y+heigh&&r.getY()+r.getHeigh()>=y){
				return true;
			}
		}
		return false;
	}

	public int getWide() {
		return wide;
	}

	public void setWide(int wide) {
		this.wide = wide;
	}

	public int getHeigh() {
		return heigh;
	}

	public void setHeigh(int heigh) {
		this.heigh = heigh;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	
}
