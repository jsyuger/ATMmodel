
public class Account {
	private int[][] Account={{10001,666666},{10002,666666},{10003,666666}};
	private int[][] money={{10001,5000},{10002,5000},{10003,5000}}; 
    private int currentAccountID;
    
	public int getPasswd(int accountId) {
		int i;
		int error=0;
		for(i=0;i<3;i++){
			if(accountId==Account[i][0]){currentAccountID=i; return Account[i][1];}
			else i++;
		}		
		return error;
	}
	
    public int[][] getAccount() {
		return Account;
	}
	public void setAccount(int[][] account) {
		Account = account;
	}
	public int getMoney(int accountID) {
		return money[accountID][1];
	}
	public void setMoney(int accountID,int balance) {
		this.money[accountID][1]= balance;
	}
	public int getCurrentAccountID(){
    	return currentAccountID;
    }
    
}
