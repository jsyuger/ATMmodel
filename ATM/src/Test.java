import java.util.Scanner;


public class Test {
     public static void main(String []args){
    	 //��֤�û�
    	 ATM atm=new ATM();
    	 atm.turnOn();
    	 Scanner input=new Scanner(System.in);
    	 //����
    	 System.out.println("���뿨��");
    	 int cardNumber=input.nextInt();
    	 atm.plugcard(cardNumber);
    	 //��������
    	 System.out.println("��������");
    	 int password=input.nextInt();
    	 atm.enterPassWord(password);
    	 int s=atm.validate();
    	 System.out.println(s);	 
    	 //ȡ��
    	 Session session=new Session();
    	 //����ȡ����
    	 System.out.println("����ȡ����");
    	 int amount=input.nextInt();
    	 session.NewTransaction(atm.getCurrentAccount());
    	 session.drawMoneyTranscation(atm.getAccountID(),amount);
    	 System.out.println("ȡ����"+session.getTransactionResult());	
    	 System.out.println("���");
    	 System.out.println(session.getAccountBalance(atm.getAccountID()));	 
    	 
     }
}
