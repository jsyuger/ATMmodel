
public class ATM {
	private CashDispenser cashDispenser;
    private CardReader cardReader;
    private Card card;
    private Customer customer;
    private Account account;
    public void turnOn(){
	    cashDispenser=new CashDispenser();
	    cardReader=new CardReader();
	    //customer=new Customer();
	    //card=new Card();
	    account=new Account();
	    System.out.println("ATM�Ѿ�׼������...");
   }
    public CashDispenser getCashDispenser() {
		return cashDispenser;
	}
    public CardReader getCardReader(){
    	return cardReader;
    	
    }
    //�忨
    public void plugcard(int cardId){
    	card=new Card();
    	card.setCard(cardId);
    	cardReader.readcard(card);
    }
    //��������
    public void enterPassWord(int password){
    	customer=new Customer();
    	customer.setEnterPassWord(password);
    }
    //��֤�˻�
    public int validate(){
    	int enterAccountId=cardReader.getAccountId();
    	int enterPW=customer.getEnterPassWord();
    	int pw=account.getPasswd(enterAccountId);
    	if(enterPW==pw)return 0;//��֤�ɹ�
    	else 
    	if(pw==0) return 1;//�˻�������
    	else return 2;//��������
    }
    //��ȡ�˻�id
    public int getAccountID(){
    	return account.getCurrentAccountID();
    }
    //��ȡ��ǰ�˻�
    public Account getCurrentAccount(){
    	return account;
    }
    //������Ǯ
    public void outMoney(int amount){
    	cashDispenser.outCash(amount);
    }
    
    //�ر�ATM
    public void turnoff(){
    	System.out.println("ATM�Ѿ��رգ�ллʹ�ã�");
    	System.out.println("----------------------");
    }
}
