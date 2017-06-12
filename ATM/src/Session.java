import java.util.ArrayList;
import java.util.List;

/**
 * @author jsyuger
 * @date : 2017年6月12日 上午11:02:22
 */  


public class Session {
	   private    int      SessionState=0;//会话状态，当为0时为自由状态，当为1时为启用状态
       private Transaction transaction;//开启一个新的业务
       private List<Transaction> tc = new ArrayList<Transaction>();
       private    int      TransactionResult;//业务结果
       
       //添加交易
       public void addTransaction(Account currentAccount){
    	   //transaction=new Transaction();
    	   tc.add(transaction);
       }
       
       //删除交易
       public void removeTransaction(){
    	   tc.remove(transaction);
       }
       
       //新建交易
       public void NewTransaction(Account currentAccount){
    	   transaction=new Transaction();
    	   transaction.getAccount(currentAccount);
       }
       
       
       /*
       	*取款交易
       */
       
       //取款交易处理
       public void drawMoneyTranscation(int currentAccountID,int amount){
    	   SessionState=1;
    	   TransactionResult=transaction.drawMoney(currentAccountID, amount);
    	   SessionState=0;
       }
       
       //余额
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
