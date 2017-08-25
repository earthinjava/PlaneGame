package hongda.com.PlaneGame;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import util.MyFrame;
import util.Rect;

@SuppressWarnings("serial")
public class PlaneGameFrame extends MyFrame {	
	
	private Bullet[] bullet;
	private Plane plane;
	private Monitor m=new Monitor();	
	private Date startDate,endDate;	
	private Bullet[] overbullet;
	private int overnum=4000;
	private int startnum=18;
	private int fnum=startnum/10;
	private int easy=startnum;
	private ArrayList<Bullet> ar=new ArrayList<Bullet>();
	private int count=0;
	
	private FollowBullent[] fbullet;
	
	public PlaneGameFrame(){		
		fbullet=new FollowBullent[fnum];
		plane=new Plane("images/plane2.jpg");
		bullet=new Bullet[easy];
		
		for(int i=0;i<easy;i++){
			bullet[i]=new Bullet();
		}		
		overbullet=new Bullet[overnum];
		for(int i=0;i<overnum;i++){
			overbullet[i]=new Bullet(10);
		}

		for(int i=0;i<fnum;i++){
			fbullet[i]=new FollowBullent();
		}
		
		addKeyListener(m);
		startDate=new Date();		
	}	
	
	@Override
	public void paint(Graphics g) {			
		plane.draw(g);
		float l;
		float m;
		printIfo(g,"难度："+(startnum-8),"宋体",15,700,60);
//画出增加的子弹
		Iterator<Bullet> li=ar.iterator();
		while(li.hasNext()){
			((FollowBullent)li.next()).draw(g,plane);
		}
		
		for(int i=0;i<easy;i++){
			bullet[i].draw(g);
			Rect r1=new Rect(plane.x,plane.y,plane.wide,plane.height);
			Rect r2=new Rect((int)bullet[i].x,(int)bullet[i].y,bullet[i].dn,bullet[i].dn);
			if(r1.inof(r2)){
				plane.setAlive(false);
				if(endDate == null){
					endDate=new Date();									
				}
			}
		}
//追踪子弹		
		for(int i=0;i<fnum;i++){
			fbullet[i].draw(g,plane);
			Rect r1=new Rect(plane.x,plane.y,plane.wide,plane.height);
			Rect r2=new Rect((int)fbullet[i].x,(int)fbullet[i].y,fbullet[i].dn,fbullet[i].dn);
			if(r1.inof(r2)){
				plane.setAlive(false);
				if(endDate == null){
					endDate=new Date();									
				}
			}
		}
		
		if(!plane.getAlive()){
			printIfo(g,"GAME OVER","宋体",50,280,400);
			m = (endDate.getTime()/100)-(startDate.getTime()/100);
			printIfo(g,"时间："+m/10+"s","宋体",30,320,450);
			printIfo(g,"ENTER START","宋体",25,325,500);
			printIfo(g,"F1增加难度","宋体",20,350,530);
			printIfo(g,"F2减小难度","宋体",20,350,560);			
			for(int i=0;i<overnum;i++){
				overbullet[i].draw(g);
			}
		}
		else{
			l = (new Date().getTime()/100)-(startDate.getTime()/100);
			printIfo(g,"时间："+l/10+"s","宋体",15,700,80);
//计数增加子弹	
			count++;
			if(count==100){
				count=0;
				FollowBullent bt=new FollowBullent();				
				ar.add(bt);
			}
		}
		
		
	}
	
	public void printIfo(Graphics g,String s,String font,int height,int x,int y){
		Font f=new Font(font,Font.BOLD,height);
		g.setFont(f);
		g.drawString(s,x,y);
	}
//重新开始	
	public void restart(){
		
		easy=startnum;
		fnum=startnum/10;
		ar.clear();
		
		fbullet=new FollowBullent[fnum];
		plane=new Plane("images/plane2.jpg");
		bullet=new Bullet[easy*4];
		for(int i=0;i<easy*4;i++){
			bullet[i]=new Bullet();
		}		
		
		for(int i=0;i<overnum;i++){
			overbullet[i]=new Bullet(10);
		}	
		
		for(int i=0;i<fnum;i++){
			fbullet[i]=new FollowBullent();
		}
		
		startDate=new Date();
		endDate = null;		
	}
	

	public static void main(String[] args) {		
		PlaneGameFrame a;
		a=new PlaneGameFrame();		
		a.launchFrame();		
	}
	
	class Monitor extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			plane.addDir(e);
			if(e.getKeyCode()==KeyEvent.VK_ENTER){
				restart();
			}
			if(e.getKeyCode()==KeyEvent.VK_F1){
				startnum+=1;
				System.out.println(startnum);
			}
			if(e.getKeyCode()==KeyEvent.VK_F2){
				if(startnum>=10){
					startnum-=1;
					System.out.println(startnum);
				}
			}
		}
		@Override
		public void keyReleased(KeyEvent e) {
			plane.subDir(e);			
		}		
		
		
	}

}


