import java.util.ArrayList;
import java.util.List;


public class Session {
	   private    int      SessionState=0;//�Ự״̬����Ϊ0ʱΪ����״̬����Ϊ1ʱΪ����״̬
       private Transaction transaction;//����һ���µ�ҵ��
       private List<Transaction> tc = new ArrayList<Transaction>();
       private    int      TransactionResult;//ҵ����
       
       //��ӽ���
       public void addTransaction(Account currentAccount){
    	   //transaction=new Transaction();
    	   tc.add(transaction);
       }
       
       //ɾ������
       public void removeTransaction(){
    	   tc.remove(transaction);
       }
       
       //�½�����
       public void NewTransaction(Account currentAccount){
    	   transaction=new Transaction();
    	   transaction.getAccount(currentAccount);
       }
       
       public void drawMoneyTranscation(int currentAccountID,int amount){
    	   SessionState=1;
    	   TransactionResult=transaction.drawMoney(currentAccountID, amount);
    	   SessionState=0;
       }
       public int getAccountBalance(int currentAccountID){
    	   return transaction.getAccountBalance(currentAccountID);
       }
	public int getTransactionResult() {
		return TransactionResult;
	}
	public void setTransactionResult(int transactionResult) {
		TransactionResult = transactionResult;
	}
       
}
