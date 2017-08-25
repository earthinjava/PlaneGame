package util;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
 * ����һ������
 */

@SuppressWarnings("serial")
public class MyFrame extends Frame {	
	
	public void launchFrame(){
//���ô���λ�ã���С�����ӻ�
		setSize(Constant.MYFRAME_WIDTH,Constant.MYFRAME_HEIGTH);
		setLocation(200,50);
		setVisible(true);
		
		new ThreadRepaint().start();
//����رհ�ť
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
	}
//�ػ��߳�	
	class  ThreadRepaint extends Thread{
		@Override
		public void run(){
			while(true){
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		   }
		}
	}
//˫����
	
	private Image offScreenImage=null;
	public void update(Graphics g) {  
        if (offScreenImage == null) {  
            offScreenImage = this.createImage(Constant.MYFRAME_WIDTH,Constant.MYFRAME_HEIGTH);  
        }  
        Graphics gImage = offScreenImage.getGraphics();  
        Color c = gImage.getColor();  
        gImage.setColor(Color.WHITE);  
        gImage.fillRect(0, 0, Constant.MYFRAME_WIDTH, Constant.MYFRAME_HEIGTH);  
        gImage.setColor(c);  
        paint(gImage);  
        g.drawImage(offScreenImage, 0, 0, null);  
    }  
}
