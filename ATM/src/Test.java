import java.util.Scanner;


public class Test {
     public static void main(String []args){
    	 //验证用户
    	 ATM atm=new ATM();
    	 atm.turnOn();
    	 Scanner input=new Scanner(System.in);
    	 //卡号
    	 System.out.println("输入卡号");
    	 int cardNumber=input.nextInt();
    	 atm.plugcard(cardNumber);
    	 //输入密码
    	 System.out.println("输入密码");
    	 int password=input.nextInt();
    	 atm.enterPassWord(password);
    	 int s=atm.validate();
    	 System.out.println(s);	 
    	 //取款
    	 Session session=new Session();
    	 //输入取款金额
    	 System.out.println("输入取款金额");
    	 int amount=input.nextInt();
    	 session.NewTransaction(atm.getCurrentAccount());
    	 session.drawMoneyTranscation(atm.getAccountID(),amount);
    	 System.out.println("取款结果"+session.getTransactionResult());	
    	 System.out.println("余额");
    	 System.out.println(session.getAccountBalance(atm.getAccountID()));	 
    	 
     }
}
