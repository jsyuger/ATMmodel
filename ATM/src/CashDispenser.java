
public class CashDispenser {
     private int cash=100000;
     
     //获取取款数额
     public void getCash(int cash){
    	 this.cash=cash;
     }
     
     //吐钞
     public void outCash(int amount){
    	 cash=cash-amount;
    	 System.out.println("正在吐钞，请稍候");
     }
     
     //获取钞箱当前数额
     public int cashInCashDispenser(){
    	 return cash;
     }
}
