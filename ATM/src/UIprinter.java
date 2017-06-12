import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//该类是打印机完成打印过程的工具类 相当于接口
public class UIprinter extends JFrame{
	private static JFrame frame;
	private static JFrame frame1;
	private static Font font1=new Font("Times New Roman",Font.BOLD,18);
	private static Font font2=new Font("楷体",Font.BOLD,14);
	    public static void UIprinting(){
	    	frame=new JFrame();
	    	JPanel p1=new JPanel();
	    	JLabel j1=new JLabel("attention!");
	    	JLabel j2=new JLabel("正在进行：打印凭条......");
	  		p1.add(j1);
	  		p1.add(j2,BorderLayout.SOUTH);
	  		j1.setFont(font1);
	  		j2.setFont(font2);
	  		//add(p1,BorderLayout.CENTER); 
	  		frame.add(p1);
			frame(frame);
			timer1(p1);
	  		
	  	}
	    
	    public static void UIprinterSuccess(){
	    	JPanel jp1=new JPanel();
	    	JLabel jl1=new JLabel("It is OK!");
	    	JLabel jl2=new JLabel("凭条已成功打印！请取走凭条。");
	    	jp1.add(jl1);
	  		jp1.add(jl2,BorderLayout.SOUTH);
	  		jl1.setFont(font1);
	  		jl2.setFont(font2);	
	  		frame.add(jp1);
	  		timer2();
	    }
	    
	   //提示出钞
	    public static void noticeOutMoney(){
	    	 frame1=new JFrame();
	    	 frame1.setTitle("提示出钞");
			 frame1.setSize(220,150);
			 frame1.setLocationRelativeTo(null);
			 //frame.setLocation(30,30);
			 frame1.setVisible(true);
			 frame1.setResizable(false);
			 frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	JPanel jp1=new JPanel();
	    	JLabel jl1=new JLabel("wait for a moment");
	    	JLabel jl2=new JLabel("正在出钞,请稍候");
	    	jp1.add(jl1);
	  		jp1.add(jl2,BorderLayout.SOUTH);
	  		jl1.setFont(font1);
	  		jl2.setFont(font2);	
	  		frame1.add(jp1);
	  		timer3();
	    }
	    
	    
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			 UIprinting();
			 frame(frame);
		}

		public static void frame(JFrame frame) {
			 frame.setTitle("打印凭条");
			 frame.setSize(220,150);
			 frame.setLocationRelativeTo(null);
			 //frame.setLocation(30,30);
			 frame.setVisible(true);
			 frame.setResizable(false);
			 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		public static void frameDispose() {
			 frame.setVisible(false);
			 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		 //计时器 隐藏JPanel
	    public static void timer1(final JPanel panel) {  
	        Timer timer = new Timer();  
	        timer.schedule(new TimerTask() {  
	            public void run() {
	            	panel.setVisible(false);
	            	UIprinterSuccess();
	            	System.out.println("凭条已经成功打印");
	            }  
	        }, 2000);// 设定指定的时间time,此处为3000毫秒  
	    }
	    
	    //计时器2 关闭frame
	    public static void timer2() {  
	        Timer timer = new Timer();  
	        timer.schedule(new TimerTask() {  
	            public void run() {
	            	frameDispose();
	            }  
	        }, 3000);// 设定指定的时间time,此处为3000毫秒  
	    }
	    
	    //计时器3 关闭出钞frame
	    public static void timer3() {  
	        Timer timer = new Timer();  
	        timer.schedule(new TimerTask() {  
	            public void run() {
	            	frame1.setVisible(false);
	   			    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            }  
	        }, 3000);// 设定指定的时间time,此处为3000毫秒  
	    }
}