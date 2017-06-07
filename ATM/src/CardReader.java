
public class CardReader {	
	private int accountid;
	public void readcard(Card card){
		int accountId=card.getCardId();
		this.accountid=accountId;		
	}
    public int getAccountId(){
    	return accountid;
    }
}
