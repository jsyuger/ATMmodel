import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.text.AbstractDocument;
import javax.swing.text.html.ImageView;

public class UIindex extends JFrame{
	private static ImageIcon imgIcon=new ImageIcon("src/images/shouye.jpg");
	private static Image img=imgIcon.getImage();
	private static JFrame frame;
	private int second=30;
	private boolean haveDone=false;
	private String cardNumber=null;
	private String inputNumber=null;
	private JLabel attention=new JLabel(""+second);
	Font f1=new Font("黑体",Font.BOLD,45);
	Font f2=new Font("Times New Roman",Font.BOLD,18);
	private static ATM atm;
	
	private Session session;
	
	//利用构造方法初始化界面
	public UIindex(){
		//创建ATM
		atm=new ATM();
		atm.turnOn();
		//添加背景图片
		imgIcon=new ImageIcon("src/images/shouye.jpg");
		img=imgIcon.getImage();
		BackPanel jp=new BackPanel();
		jp.setVisible(true);
		jp.setOpaque(false);  //设置控件透明
		
		//添加确认按钮
		JToggleButton jtb1=new JToggleButton("");
		jtb1.setText("确认");
		jtb1.setBounds(490,360,75,35);
		//添加文本框
		final JTextField jtf1=new JTextField();
		jtf1.setFont(f2);
		((AbstractDocument)jtf1.getDocument()).setDocumentFilter(new UIutil(12));//限制文本框输入，调用了工具类 UIutil
		jtf1.setBounds(300,360,160,35);
		
		getContentPane().add(jtb1);
		getContentPane().add(jtf1);
		jtb1.setVisible(true);
		
		//添加面板至容器
		add(jp);
		
		//添加监听器
		jtb1.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){
		    	 cardNumber=jtf1.getText();
		    	 int cardnumber=change(cardNumber);
		    	 atm.plugcard(cardnumber);
		    	 frameDispose();
		    	 UIpassword();
		    	 System.out.println("当前银行卡号："+jtf1.getText());
			 }
		 });
			
	}
	
	//输入密码界面处理
	public void UIpassword(){
		//更换背景
		imgIcon=new ImageIcon("src/images/password.jpg");
		img=imgIcon.getImage();
		frame=new JFrame();
		BackPanel jp_password=new BackPanel();
		//	jp_password.setVisible(true);
		//	jp_password.setOpaque(false); //透明
		
		//布局格式设置为空
		jp_password.setLayout(null);
		//添加文字
		JLabel attention=new JLabel("温馨提醒：请注意周围环境安全。");
		attention.setForeground(Color.white);
		attention.setFont(new java.awt.Font("Dialog",1,15));
		attention.setBounds(180,25,250,30);
		jp_password.add(attention);
	    
		//添加重置按钮
		JButton jb1=new JButton("");
		jb1.setBounds(0,298,125,52);
		//添加确认按钮
		JButton jb2=new JButton("");
		jb2.setBounds(450,298,125,52);
		//添加密码输入文本框
		final JPasswordField pw=new JPasswordField(6);
		((AbstractDocument)pw.getDocument()).setDocumentFilter(new UIutil(6));//限制文本框输入，调用了工具类 UIutil
		pw.setBounds(165,165,260,70);
		pw.setEchoChar('*');
		pw.setFont(f1);
		
		jb1.setOpaque(false);
		jb1.setContentAreaFilled(false);
		jb2.setOpaque(false);
		jb2.setContentAreaFilled(false);
		jp_password.add(jb1);
		jp_password.add(jb2);
		jp_password.add(pw);
	    frame.add(jp_password);
		frame(frame);
		
		//为重置按钮添加监听器
		jb1.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){
		    	 pw.setText("");
		    	 
			 }
		 });
		
		//为确认按钮添加监听器
		jb2.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){	  
		    	 int password=change(pw.getText());
		    	 //验证密码
		    	 int validateS=validate(password);
		    	 if(validateS==0) {
		    		 frameDispose();
		    		//新建一个SESSION
			    	session=new Session();
		    		 UIchooseService();
		    		
		    	 }
		    	 else{
		    		 JOptionPane.showMessageDialog(null, "密码有误，请重新输入");
		    		 pw.setText("");
		    	 }
		    	 
			 }
		 });
		
	}
	
	
	
	//业务选择界面处理
	public void UIchooseService(){
		
		//更换背景
		imgIcon=new ImageIcon("src/images/choose.jpg");
		img=imgIcon.getImage();
		frame=new JFrame();
		BackPanel jp_service=new BackPanel();
		//布局格式设置为空
		jp_service.setLayout(null);
		
		//提示会话剩余时间
		second=30;
		if(haveDone==false)timer();
		haveDone=true;
		attention.setForeground(Color.red);
		attention.setFont(new java.awt.Font("Dialog",1,28));
		attention.setBounds(480,25,50,50);
		jp_service.add(attention);
		
		//添加取款按钮
		JButton withdraw=new JButton("");
		withdraw.setBounds(410,135,170,47);
		//withdraw.setBounds(410,135,180,80);
		//ImageIcon ii = new ImageIcon("src/images/qukuan.png");  
		//withdraw.setIcon(ii);  
		//withdraw.setBorderPainted(false);
		withdraw.setOpaque(false);
		withdraw.setContentAreaFilled(false);
		jp_service.add(withdraw);
		
		//添加退卡按钮
		JButton JBexitCard=new JButton("");
		JBexitCard.setBounds(410,360,170,47);
		JBexitCard.setOpaque(false);
		JBexitCard.setContentAreaFilled(false);
		jp_service.add(JBexitCard);	
		
		//添加显示余额按钮
		JButton JBbalance=new JButton("");
		JBbalance.setBounds(20,135,150,47);
		JBbalance.setOpaque(false);
		JBbalance.setContentAreaFilled(false);
		jp_service.add(JBbalance);
		
	    frame.add(jp_service);
		frame(frame);
		
		
		
		//为取款按钮添加监听器
		withdraw.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){
		    	 frameDispose();
		    	 UIinputNumber();
		    	 System.out.println("进入取款业务");
		    	 session.NewTransaction(atm.getCurrentAccount());
			 }
		 });	
		
		//为退卡按钮添加监听器
		JBexitCard.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){
		    	 frameDispose();
		    	 UIexitCard();
			 }
		 });
		
		//为显示余额按钮添加监听器
		JBbalance.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){
		     System.out.println("余额");
		     session.NewTransaction(atm.getCurrentAccount());
		     System.out.println(session.getAccountBalance(atm.getAccountID()));	
			 }
		 });
	}
	
	//输入取款金额处理
	public void UIinputNumber(){
		//更换背景
		imgIcon=new ImageIcon("src/images/inputNumber.jpg");
		img=imgIcon.getImage();
		frame=new JFrame();
		BackPanel jp_input=new BackPanel();
		//布局格式设置为空
		jp_input.setLayout(null);
		//提示会话剩余时间
		second=30;
		attention.setForeground(Color.red);
		attention.setFont(new java.awt.Font("Dialog",1,28));
		attention.setBounds(480,15,50,50);
		jp_input.add(attention);
		//添加200按钮
		JButton jb200=new JButton("");
		jb200.setBounds(0,78,120,48);
		//添加500按钮
		JButton jb500=new JButton("");
		jb500.setBounds(0,170,120,48);
		//添加1000按钮
		JButton jb1000=new JButton("");
		jb1000.setBounds(0,260,120,48);
		//添加2000按钮
		JButton jb2000=new JButton("");
		jb2000.setBounds(455,78,120,48);
		//添加3000按钮
		JButton jb3000=new JButton("");
		jb3000.setBounds(455,170,120,48);
		//添加确认按钮
		JButton jb_confirm=new JButton("");
		jb_confirm.setBounds(455,260,120,48);
		//添加返回按钮
		JButton jb_return=new JButton("");
		jb_return.setBounds(455,350,125,46);
		//添加退卡按钮
		JButton jb_exit=new JButton("");
		jb_exit.setBounds(0,350,125,46);
		//添加密码输入文本框
		final JTextField number=new JTextField(6);
		((AbstractDocument)number.getDocument()).setDocumentFilter(new UIutil(4));//限制文本框输入，调用了工具类 UIutil
		number.setBounds(180,160,200,60);
		number.setFont(f1);
		
		jb200.setOpaque(false);
		jb200.setContentAreaFilled(false);
		jb500.setOpaque(false);
		jb500.setContentAreaFilled(false);
		jb1000.setOpaque(false);
		jb1000.setContentAreaFilled(false);
		jb2000.setOpaque(false);
		jb2000.setContentAreaFilled(false);
		jb3000.setOpaque(false);
		jb3000.setContentAreaFilled(false);
		jb_exit.setOpaque(false);
		jb_exit.setContentAreaFilled(false);
		jb_return.setOpaque(false);
		jb_return.setContentAreaFilled(false);
		jb_confirm.setOpaque(false);
		jb_confirm.setContentAreaFilled(false);
		
		jp_input.add(jb200);
		jp_input.add(jb500);
		jp_input.add(jb1000);
		jp_input.add(jb2000);
		jp_input.add(jb3000);
		jp_input.add(jb_return);
		jp_input.add(jb_exit);
		jp_input.add(jb_confirm);
		jp_input.add(number);
	    frame.add(jp_input);
		frame(frame);
		
		//为数字按钮添加监听器
		jb200.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){number.setText("200");}
		 });
		jb500.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){number.setText("500");}
		 });
		jb1000.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){number.setText("1000");}
		 });
		jb2000.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){number.setText("2000");}
		 });
		jb3000.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){number.setText("3000");}
		 });
		//为功能按钮添加监听器
		jb_return.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){
		    	 frameDispose();
		    	 UIchooseService();
		    }
		 });
		jb_confirm.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){
		    	 //判断输入
		    	 inputNumber=number.getText();
		    	 int amount=change(inputNumber);
		    	 if(amount%100==0&&amount<=5000&&amount!=0){
			    	 System.out.println("取款金额为"+amount);
			    	 session.drawMoneyTranscation(atm.getAccountID(),amount);
			    	 int transactionResult=session.getTransactionResult();
			    	 
			    	 System.out.println("取款结果"+transactionResult);	
			    	 if(transactionResult==1) {
			    		 UIprinter UInoticeOutMoney=new UIprinter();
			    		 UInoticeOutMoney.noticeOutMoney();
			    		 atm.outMoney(amount);
			    		
			    	      timer_noticeOutMoney();
			    	      }
			    	 else{
			    		 JOptionPane.showMessageDialog(null, "余额不足，请重新输入");
			    		 number.setText("");
			    	 }
			    	 
		    	 }
		    	 else
		    		 JOptionPane.showMessageDialog(null, "输入的金额必须不大于5000并且是100的整数倍", "输入错误提示", JOptionPane.ERROR_MESSAGE);
		    }
		 });
		jb_exit.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){
		    	 frameDispose();
		    	 UIexitCard();
		    }
		 });
	}
	
	//取款成功界面处理
	public void UIsuccess(){
		//更换背景
		imgIcon=new ImageIcon("src/images/success.jpg");
		img=imgIcon.getImage();
		frame=new JFrame();
		BackPanel jp_success=new BackPanel();
		//布局格式设置为空
		jp_success.setLayout(null);
		
		//提示会话剩余时间
		second=30;
		attention.setForeground(Color.red);
		attention.setFont(new java.awt.Font("Dialog",1,28));
		attention.setBounds(480,25,50,50);
		jp_success.add(attention);
		
		//添加信息显示
		JLabel cardNo=new JLabel(cardNumber);
		cardNo.setBounds(250,140,120,20);
		JLabel money=new JLabel(inputNumber);
		money.setBounds(250,175,80,20);
		JLabel cost=new JLabel("0");
		cost.setBounds(250,210,80,20);
		jp_success.add(cardNo);
		jp_success.add(money);
		jp_success.add(cost);
		
		//添加打印凭条按钮
		JButton printer=new JButton("");
		printer.setBounds(470,236,110,36);
		printer.setOpaque(false);
		printer.setContentAreaFilled(false);
		jp_success.add(printer);
		
		//添加退出按钮按钮
		JButton jb_exit=new JButton("");
		jb_exit.setBounds(0,320,110,36);
		jb_exit.setOpaque(false);
		jb_exit.setContentAreaFilled(false);
		jp_success.add(jb_exit);
		
		//添加退出按钮按钮
		JButton jb_return=new JButton("");
		jb_return.setBounds(470,320,110,36);
		jb_return.setOpaque(false);
		jb_return.setContentAreaFilled(false);
		jp_success.add(jb_return);
		
	    frame.add(jp_success);
		frame(frame);
		
		//为打印凭条按钮添加监听器
		printer.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){
		    	 //frameDispose();
		    	 //UIinputNumber();
		    	 UIprinter p=new UIprinter();
		    	 p.UIprinting();
		    	 System.out.print("正在打印凭条...");
			 }
		 });
		
		//为退卡按钮添加监听器
		jb_exit.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){
		    	 frameDispose();
		    	 UIexitCard();
		    	 System.out.print("已经退出卡片，结束会话。");
			 }
		 });
		
		//为退卡按钮添加监听器
		jb_return.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){
		    	 frameDispose();
		    	 UIchooseService();
		    	 System.out.println("已进入业务选择菜单");
			 }
		 });
	}
	
	//退卡界面处理
	public void UIexitCard(){
		//更换背景
		imgIcon=new ImageIcon("src/images/outCard.jpg");
		img=imgIcon.getImage();
		frame=new JFrame();
		BackPanel jp_exit=new BackPanel();
		
		//提示会话剩余时间
		second=4;
		attention.setForeground(Color.green);
		attention.setFont(new java.awt.Font("Dialog",1,28));
		attention.setBounds(480,25,50,50);
		jp_exit.add(attention);
		
		//添加面板至容器
		frame.add(jp_exit);
		frame(frame);
		timer_toIndex();
		
	}
	
	
	
	
	//main
	public static void main(String[] args) {
		//init 
		
		frame=new UIindex();
		frame(frame);
	}

	public static void frame(JFrame frame) {
		 frame.setTitle("中国XX银行ATM");
		 frame.setSize(580,450);
		 //frame.setLocation(30,30);
		 frame.setLocationRelativeTo(null);
		 frame.setVisible(true);
		 frame.setResizable(false);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 //关闭时添加监听器
		 frame.addWindowListener(new WindowAdapter()  
	        {  
	            public void windowClosing(WindowEvent e)  
	            {  
	                //System.out.println("触发windowClosing事件"); 
	                atm.turnoff();
	            }  
	  
	            public void windowClosed(WindowEvent e)  
	            {  
	                System.out.println("触发windowClosed事件");  
	                atm.turnoff();
	            }  
	        });  
	}
	
	//hide frame
	public void frameDispose() {
		 frame.setVisible(false);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	//背景加载类
	public static class BackPanel extends JPanel{
		 protected void paintComponent(Graphics g){
			 super.paintComponent(g);
			 g.drawImage(img,0,0,this);
		 }
	}
	
	//计时器1 会话倒计时
	public void timer(){
		Timer timer = new Timer();
		
	    timer.schedule(new TimerTask(){
	      public void run() {
	    	  second=second-1;
	    	  if(second>=0)
	    		  attention.setText(""+second);
	          //System.out.println("test");
	      }
	    }, 0, 1000);
	    
	}
	
	//计时器2 3秒之后返回首页
	public void timer_toIndex(){
			Timer timer = new Timer();  
	        timer.schedule(new TimerTask() {  
	            public void run() {
	            	frameDispose();
	            	frame=new UIindex();
	        		frame(frame);
	            	System.out.println("已经进入首页");
	            }  
	        }, 3000);// 设定指定的时间time,此处为3000毫秒 
		    
		}
	
	//计时器3 提示出钞
		public void timer_noticeOutMoney(){
				Timer timer = new Timer();  
		        timer.schedule(new TimerTask() {  
		            public void run() {
		            	frameDispose();
			    	    UIsuccess();
		            }  
		        }, 3000);// 设定指定的时间time,此处为3000毫秒 
			    
			}
	
	//字符类型转换
	public int change(String str){
		try {
		    int a = Integer.parseInt(str);
		    return a;
		} catch (NumberFormatException e) {
		    //e.printStackTrace();
		    return 10000;
		}
	}
	//验证账户和密码
		public int validate(int passwd){
			atm.enterPassWord(passwd);
	   	    System.out.println("验证密码"+passwd);
	   	    int s=atm.validate();
			return s;
		}
	   
}