
public class Transaction {   
	private Account account;
	
	public void getAccount(Account currentAccount){
		this.account=currentAccount;
	}
	public int drawMoney(int accountID,int amount){
    	   int AccountMoney=account.getMoney(accountID);   
    	   int balance=AccountMoney-amount;
   		   if(balance<0) return 0;//����
   		   else{account.setMoney(accountID, balance);return 1;}//ȡ��ɹ�
   	 }
	
	public int getAccountBalance(int accountID){
		
		return account.getMoney(accountID);
	}
    	  
}

