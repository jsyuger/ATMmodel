
public class CashDispenser {
     private int cash=0;
     
     //获取取款数额
     public void getCash(int cash){
    	 this.cash=cash;
     }
     
     //吐钞
     public void outCash(int amount){
    	 cash=cash-amount;
    	 System.out.println("正在吐钞，请稍候");
     }
     
     //
     
}
