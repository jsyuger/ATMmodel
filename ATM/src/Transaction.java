
public class Transaction {   
	private Account account;
	
	public void getAccount(Account currentAccount){
		this.account=currentAccount;
	}
	
	//取款交易过程
	public int drawMoney(int accountID,int amount){
    	   int AccountMoney=account.getMoney(accountID);   
    	   int balance=AccountMoney-amount;
   		   if(balance<0) return 0;//余额不足
   		   else{account.setMoney(accountID, balance);return 1;}//取款成功
   	 }
	
	//余额
	public int getAccountBalance(int accountID){
		return account.getMoney(accountID);
	}
    	  
}

