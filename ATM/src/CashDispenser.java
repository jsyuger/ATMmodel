
public class CashDispenser {
     private int cash=100000;
     
     //��ȡȡ������
     public void getCash(int cash){
    	 this.cash=cash;
     }
     
     //�³�
     public void outCash(int amount){
    	 cash=cash-amount;
    	 System.out.println("�����³������Ժ�");
     }
     
     //��ȡ���䵱ǰ����
     public int cashInCashDispenser(){
    	 return cash;
     }
}
