
public class CashDispenser {
     private int cash=0;
     
     //��ȡȡ������
     public void getCash(int cash){
    	 this.cash=cash;
     }
     
     //�³�
     public void outCash(int amount){
    	 cash=cash-amount;
    	 System.out.println("�����³������Ժ�");
     }
     
     //
     
}
