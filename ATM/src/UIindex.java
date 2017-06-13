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
	Font f1=new Font("����",Font.BOLD,45);
	Font f2=new Font("Times New Roman",Font.BOLD,18);
	private static ATM atm;
	
	private Session session;
	
	//���ù��췽����ʼ������
	public UIindex(){
		//����ATM
		atm=new ATM();
		atm.turnOn();
		//��ӱ���ͼƬ
		imgIcon=new ImageIcon("src/images/shouye.jpg");
		img=imgIcon.getImage();
		BackPanel jp=new BackPanel();
		jp.setVisible(true);
		jp.setOpaque(false);  //���ÿؼ�͸��
		
		//���ȷ�ϰ�ť
		JToggleButton jtb1=new JToggleButton("");
		jtb1.setText("ȷ��");
		jtb1.setBounds(490,360,75,35);
		//����ı���
		final JTextField jtf1=new JTextField();
		jtf1.setFont(f2);
		((AbstractDocument)jtf1.getDocument()).setDocumentFilter(new UIutil(12));//�����ı������룬�����˹����� UIutil
		jtf1.setBounds(300,360,160,35);
		
		getContentPane().add(jtb1);
		getContentPane().add(jtf1);
		jtb1.setVisible(true);
		
		//������������
		add(jp);
		
		//��Ӽ�����
		jtb1.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){
		    	 cardNumber=jtf1.getText();
		    	 int cardnumber=change(cardNumber);
		    	 atm.plugcard(cardnumber);
		    	 frameDispose();
		    	 UIpassword();
		    	 System.out.println("��ǰ���п��ţ�"+jtf1.getText());
			 }
		 });
			
	}
	
	//����������洦��
	public void UIpassword(){
		//��������
		imgIcon=new ImageIcon("src/images/password.jpg");
		img=imgIcon.getImage();
		frame=new JFrame();
		BackPanel jp_password=new BackPanel();
		//	jp_password.setVisible(true);
		//	jp_password.setOpaque(false); //͸��
		
		//���ָ�ʽ����Ϊ��
		jp_password.setLayout(null);
		//�������
		JLabel attention=new JLabel("��ܰ���ѣ���ע����Χ������ȫ��");
		attention.setForeground(Color.white);
		attention.setFont(new java.awt.Font("Dialog",1,15));
		attention.setBounds(180,25,250,30);
		jp_password.add(attention);
	    
		//������ð�ť
		JButton jb1=new JButton("");
		jb1.setBounds(0,298,125,52);
		//���ȷ�ϰ�ť
		JButton jb2=new JButton("");
		jb2.setBounds(450,298,125,52);
		//������������ı���
		final JPasswordField pw=new JPasswordField(6);
		((AbstractDocument)pw.getDocument()).setDocumentFilter(new UIutil(6));//�����ı������룬�����˹����� UIutil
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
		
		//Ϊ���ð�ť��Ӽ�����
		jb1.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){
		    	 pw.setText("");
		    	 
			 }
		 });
		
		//Ϊȷ�ϰ�ť��Ӽ�����
		jb2.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){	  
		    	 int password=change(pw.getText());
		    	 //��֤����
		    	 int validateS=validate(password);
		    	 if(validateS==0) {
		    		 frameDispose();
		    		//�½�һ��SESSION
			    	session=new Session();
		    		 UIchooseService();
		    		
		    	 }
		    	 else{
		    		 JOptionPane.showMessageDialog(null, "������������������");
		    		 pw.setText("");
		    	 }
		    	 
			 }
		 });
		
	}
	
	
	
	//ҵ��ѡ����洦��
	public void UIchooseService(){
		
		//��������
		imgIcon=new ImageIcon("src/images/choose.jpg");
		img=imgIcon.getImage();
		frame=new JFrame();
		BackPanel jp_service=new BackPanel();
		//���ָ�ʽ����Ϊ��
		jp_service.setLayout(null);
		
		//��ʾ�Ựʣ��ʱ��
		second=30;
		if(haveDone==false)timer();
		haveDone=true;
		attention.setForeground(Color.red);
		attention.setFont(new java.awt.Font("Dialog",1,28));
		attention.setBounds(480,25,50,50);
		jp_service.add(attention);
		
		//���ȡ�ť
		JButton withdraw=new JButton("");
		withdraw.setBounds(410,135,170,47);
		//withdraw.setBounds(410,135,180,80);
		//ImageIcon ii = new ImageIcon("src/images/qukuan.png");  
		//withdraw.setIcon(ii);  
		//withdraw.setBorderPainted(false);
		withdraw.setOpaque(false);
		withdraw.setContentAreaFilled(false);
		jp_service.add(withdraw);
		
		//����˿���ť
		JButton JBexitCard=new JButton("");
		JBexitCard.setBounds(410,360,170,47);
		JBexitCard.setOpaque(false);
		JBexitCard.setContentAreaFilled(false);
		jp_service.add(JBexitCard);	
		
		//�����ʾ��ť
		JButton JBbalance=new JButton("");
		JBbalance.setBounds(20,135,150,47);
		JBbalance.setOpaque(false);
		JBbalance.setContentAreaFilled(false);
		jp_service.add(JBbalance);
		
	    frame.add(jp_service);
		frame(frame);
		
		
		
		//Ϊȡ�ť��Ӽ�����
		withdraw.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){
		    	 frameDispose();
		    	 UIinputNumber();
		    	 System.out.println("����ȡ��ҵ��");
		    	 session.NewTransaction(atm.getCurrentAccount());
			 }
		 });	
		
		//Ϊ�˿���ť��Ӽ�����
		JBexitCard.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){
		    	 frameDispose();
		    	 UIexitCard();
			 }
		 });
		
		//Ϊ��ʾ��ť��Ӽ�����
		JBbalance.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){
		     System.out.println("���");
		     session.NewTransaction(atm.getCurrentAccount());
		     System.out.println(session.getAccountBalance(atm.getAccountID()));	
			 }
		 });
	}
	
	//����ȡ�����
	public void UIinputNumber(){
		//��������
		imgIcon=new ImageIcon("src/images/inputNumber.jpg");
		img=imgIcon.getImage();
		frame=new JFrame();
		BackPanel jp_input=new BackPanel();
		//���ָ�ʽ����Ϊ��
		jp_input.setLayout(null);
		//��ʾ�Ựʣ��ʱ��
		second=30;
		attention.setForeground(Color.red);
		attention.setFont(new java.awt.Font("Dialog",1,28));
		attention.setBounds(480,15,50,50);
		jp_input.add(attention);
		//���200��ť
		JButton jb200=new JButton("");
		jb200.setBounds(0,78,120,48);
		//���500��ť
		JButton jb500=new JButton("");
		jb500.setBounds(0,170,120,48);
		//���1000��ť
		JButton jb1000=new JButton("");
		jb1000.setBounds(0,260,120,48);
		//���2000��ť
		JButton jb2000=new JButton("");
		jb2000.setBounds(455,78,120,48);
		//���3000��ť
		JButton jb3000=new JButton("");
		jb3000.setBounds(455,170,120,48);
		//���ȷ�ϰ�ť
		JButton jb_confirm=new JButton("");
		jb_confirm.setBounds(455,260,120,48);
		//��ӷ��ذ�ť
		JButton jb_return=new JButton("");
		jb_return.setBounds(455,350,125,46);
		//����˿���ť
		JButton jb_exit=new JButton("");
		jb_exit.setBounds(0,350,125,46);
		//������������ı���
		final JTextField number=new JTextField(6);
		((AbstractDocument)number.getDocument()).setDocumentFilter(new UIutil(4));//�����ı������룬�����˹����� UIutil
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
		
		//Ϊ���ְ�ť��Ӽ�����
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
		//Ϊ���ܰ�ť��Ӽ�����
		jb_return.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){
		    	 frameDispose();
		    	 UIchooseService();
		    }
		 });
		jb_confirm.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){
		    	 //�ж�����
		    	 inputNumber=number.getText();
		    	 int amount=change(inputNumber);
		    	 if(amount%100==0&&amount<=5000&&amount!=0){
			    	 System.out.println("ȡ����Ϊ"+amount);
			    	 session.drawMoneyTranscation(atm.getAccountID(),amount);
			    	 int transactionResult=session.getTransactionResult();
			    	 
			    	 System.out.println("ȡ����"+transactionResult);	
			    	 if(transactionResult==1) {
			    		 UIprinter UInoticeOutMoney=new UIprinter();
			    		 UInoticeOutMoney.noticeOutMoney();
			    		 atm.outMoney(amount);
			    		
			    	      timer_noticeOutMoney();
			    	      }
			    	 else{
			    		 JOptionPane.showMessageDialog(null, "���㣬����������");
			    		 number.setText("");
			    	 }
			    	 
		    	 }
		    	 else
		    		 JOptionPane.showMessageDialog(null, "����Ľ����벻����5000������100��������", "���������ʾ", JOptionPane.ERROR_MESSAGE);
		    }
		 });
		jb_exit.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){
		    	 frameDispose();
		    	 UIexitCard();
		    }
		 });
	}
	
	//ȡ��ɹ����洦��
	public void UIsuccess(){
		//��������
		imgIcon=new ImageIcon("src/images/success.jpg");
		img=imgIcon.getImage();
		frame=new JFrame();
		BackPanel jp_success=new BackPanel();
		//���ָ�ʽ����Ϊ��
		jp_success.setLayout(null);
		
		//��ʾ�Ựʣ��ʱ��
		second=30;
		attention.setForeground(Color.red);
		attention.setFont(new java.awt.Font("Dialog",1,28));
		attention.setBounds(480,25,50,50);
		jp_success.add(attention);
		
		//�����Ϣ��ʾ
		JLabel cardNo=new JLabel(cardNumber);
		cardNo.setBounds(250,140,120,20);
		JLabel money=new JLabel(inputNumber);
		money.setBounds(250,175,80,20);
		JLabel cost=new JLabel("0");
		cost.setBounds(250,210,80,20);
		jp_success.add(cardNo);
		jp_success.add(money);
		jp_success.add(cost);
		
		//��Ӵ�ӡƾ����ť
		JButton printer=new JButton("");
		printer.setBounds(470,236,110,36);
		printer.setOpaque(false);
		printer.setContentAreaFilled(false);
		jp_success.add(printer);
		
		//����˳���ť��ť
		JButton jb_exit=new JButton("");
		jb_exit.setBounds(0,320,110,36);
		jb_exit.setOpaque(false);
		jb_exit.setContentAreaFilled(false);
		jp_success.add(jb_exit);
		
		//����˳���ť��ť
		JButton jb_return=new JButton("");
		jb_return.setBounds(470,320,110,36);
		jb_return.setOpaque(false);
		jb_return.setContentAreaFilled(false);
		jp_success.add(jb_return);
		
	    frame.add(jp_success);
		frame(frame);
		
		//Ϊ��ӡƾ����ť��Ӽ�����
		printer.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){
		    	 //frameDispose();
		    	 //UIinputNumber();
		    	 UIprinter p=new UIprinter();
		    	 p.UIprinting();
		    	 System.out.print("���ڴ�ӡƾ��...");
			 }
		 });
		
		//Ϊ�˿���ť��Ӽ�����
		jb_exit.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){
		    	 frameDispose();
		    	 UIexitCard();
		    	 System.out.print("�Ѿ��˳���Ƭ�������Ự��");
			 }
		 });
		
		//Ϊ�˿���ť��Ӽ�����
		jb_return.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){
		    	 frameDispose();
		    	 UIchooseService();
		    	 System.out.println("�ѽ���ҵ��ѡ��˵�");
			 }
		 });
	}
	
	//�˿����洦��
	public void UIexitCard(){
		//��������
		imgIcon=new ImageIcon("src/images/outCard.jpg");
		img=imgIcon.getImage();
		frame=new JFrame();
		BackPanel jp_exit=new BackPanel();
		
		//��ʾ�Ựʣ��ʱ��
		second=4;
		attention.setForeground(Color.green);
		attention.setFont(new java.awt.Font("Dialog",1,28));
		attention.setBounds(480,25,50,50);
		jp_exit.add(attention);
		
		//������������
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
		 frame.setTitle("�й�XX����ATM");
		 frame.setSize(580,450);
		 //frame.setLocation(30,30);
		 frame.setLocationRelativeTo(null);
		 frame.setVisible(true);
		 frame.setResizable(false);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 //�ر�ʱ��Ӽ�����
		 frame.addWindowListener(new WindowAdapter()  
	        {  
	            public void windowClosing(WindowEvent e)  
	            {  
	                //System.out.println("����windowClosing�¼�"); 
	                atm.turnoff();
	            }  
	  
	            public void windowClosed(WindowEvent e)  
	            {  
	                System.out.println("����windowClosed�¼�");  
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
	
	//����������
	public static class BackPanel extends JPanel{
		 protected void paintComponent(Graphics g){
			 super.paintComponent(g);
			 g.drawImage(img,0,0,this);
		 }
	}
	
	//��ʱ��1 �Ự����ʱ
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
	
	//��ʱ��2 3��֮�󷵻���ҳ
	public void timer_toIndex(){
			Timer timer = new Timer();  
	        timer.schedule(new TimerTask() {  
	            public void run() {
	            	frameDispose();
	            	frame=new UIindex();
	        		frame(frame);
	            	System.out.println("�Ѿ�������ҳ");
	            }  
	        }, 3000);// �趨ָ����ʱ��time,�˴�Ϊ3000���� 
		    
		}
	
	//��ʱ��3 ��ʾ����
		public void timer_noticeOutMoney(){
				Timer timer = new Timer();  
		        timer.schedule(new TimerTask() {  
		            public void run() {
		            	frameDispose();
			    	    UIsuccess();
		            }  
		        }, 3000);// �趨ָ����ʱ��time,�˴�Ϊ3000���� 
			    
			}
	
	//�ַ�����ת��
	public int change(String str){
		try {
		    int a = Integer.parseInt(str);
		    return a;
		} catch (NumberFormatException e) {
		    //e.printStackTrace();
		    return 10000;
		}
	}
	//��֤�˻�������
		public int validate(int passwd){
			atm.enterPassWord(passwd);
	   	    System.out.println("��֤����"+passwd);
	   	    int s=atm.validate();
			return s;
		}
	   
}