package diceGame;


import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class Test extends JFrame{
	private static ImageIcon imgIcon=new ImageIcon("src/girl.png");
	private static Image img=imgIcon.getImage();
	private int number[];
	private JFrame frame;
	
	public Test(){
		//��ӱ���ͼƬ
		BackPanel jp=new BackPanel();
		jp.setVisible(true);//���ò��ɼ�
		jp.setOpaque(false);  //���ÿؼ�͸��
		
		//��Ӱ�ť
		JToggleButton begin=new JToggleButton("");
		begin.setText("��ʼ��Ϸ");
		begin.setBounds(290,450,95,30);
		getContentPane().add(begin);
		begin.setVisible(true);
		
		//������������
		add(jp);
		
		//��Ӽ�����
		begin.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){
		    	 Player player=new Player();
		    	 number=player.start();
		    	 rolling();
		    	 timer1();
		    	 //System.out.print(number[0]+number[1]);
			 }
		 });
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 JFrame frame=new Test();
		 frame(frame);
	}
	
	static class BackPanel extends JPanel{
		 protected void paintComponent(Graphics g){
			 super.paintComponent(g);
			 g.drawImage(img,0,0,this);
		 }
	}
	

	public static void frame(JFrame frame) {
		 frame.setTitle("������Ϸ");
		 frame.setSize(390,530);
		 frame.setLocation(30,30);
		 frame.setVisible(true);
		 frame.setResizable(false);
		 //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void frameDispose() {
		 frame.setVisible(false);
		 //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void rolling(){
		frame=new JFrame();
		JPanel jp1=new JPanel();
		JLabel result=new JLabel("����Ϊ��ҡ���ӣ����Ժ�......");
	    jp1.add(result);
	    ImageIcon imageIcon1=new ImageIcon("src/rolling.gif");
	    jp1.add(new JLabel(imageIcon1));
	    ImageIcon imageIcon2=new ImageIcon("src/rolling.gif");
	    jp1.add(new JLabel(imageIcon2));
	    frame.add(jp1);
		frame(frame);
		timer2(jp1);
		
	}
	
	public void result(){
		JPanel jp2=new JPanel();
		
		String s;
		if((number[0]+number[1])%2==0)
			s="�������ӵĵ���֮��Ϊż����You have lost";
		else
			s="�������ӵĵ���֮��Ϊ������You have won";
		String s1=number[0]+"";
		String s2=number[1]+"";
	    JLabel result=new JLabel(s);
	    jp2.add(result);
	    JButton again=new JButton("����һ��");
	    jp2.add(again);
		
	    ImageIcon imageIcon1=new ImageIcon("src/"+s1+".jpg");
	    jp2.add(new JLabel(imageIcon1));
	    ImageIcon imageIcon2=new ImageIcon("src/"+s2+".jpg");
	    jp2.add(new JLabel(imageIcon2));
	    
	    frame.add(jp2);
	    //frame()�������Ԥ�����س���
	    frame(frame);
	    
	    //��Ӽ�����
  		again.addActionListener(new ActionListener(){
  		     public void actionPerformed(ActionEvent e){
  		    	 Player player=new Player();
  		    	 number=player.start();
  		    	 frameDispose();
  		    	 rolling();
  		    	 timer1();
  		    	 
  			 }
  		 });
	    
	}
	
	//timer1
	public void timer1() {  
        Timer timer = new Timer();  
        timer.schedule(new TimerTask() {  
            public void run() {
            	dispose();
                result(); 
            }  
        }, 3000);// �趨ָ����ʱ��time,�˴�Ϊ3000����  
    } 
	
	//timer1
	public void timer2(final JPanel panel) {  
        Timer timer = new Timer();  
        timer.schedule(new TimerTask() {  
            public void run() {
            	panel.setVisible(false); 
            }  
        }, 3000);// �趨ָ����ʱ��time,�˴�Ϊ3000����  
    }
  	
	/*
	public void timer(){
		try
		{
			//rolling();
			Thread.sleep(5000);
		}
		catch (InterruptedException e)
		{
		    e.printStackTrace();
		}
		
		//finally{result();}
	}
	*/
}
