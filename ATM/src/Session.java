
public class Session {
	   private    int      SessionState=0;//�Ự״̬����Ϊ0ʱΪ����״̬����Ϊ1ʱΪ����״̬
       private Transaction transaction;//����һ���µ�ҵ��
       private    int      TransactionResult;//ҵ����
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
