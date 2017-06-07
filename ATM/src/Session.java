
public class Session {
	   private    int      SessionState=0;//会话状态，当为0时为自由状态，当为1时为启用状态
       private Transaction transaction;//开启一个新的业务
       private    int      TransactionResult;//业务结果
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
