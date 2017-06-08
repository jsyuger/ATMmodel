
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
	    System.out.println("ATM已经准备就绪...");
   }
    public CashDispenser getCashDispenser() {
		return cashDispenser;
	}
    public CardReader getCardReader(){
    	return cardReader;
    	
    }
    //插卡
    public void plugcard(int cardId){
    	card=new Card();
    	card.setCard(cardId);
    	cardReader.readcard(card);
    }
    //输入密码
    public void enterPassWord(int password){
    	customer=new Customer();
    	customer.setEnterPassWord(password);
    }
    //验证账户
    public int validate(){
    	int enterAccountId=cardReader.getAccountId();
    	int enterPW=customer.getEnterPassWord();
    	int pw=account.getPasswd(enterAccountId);
    	if(enterPW==pw)return 0;//验证成功
    	else 
    	if(pw==0) return 1;//账户不存在
    	else return 2;//密码有误
    }
    //获取账户id
    public int getAccountID(){
    	return account.getCurrentAccountID();
    }
    //获取当前账户
    public Account getCurrentAccount(){
    	return account;
    }
    //钞箱吐钱
    public void outMoney(int amount){
    	cashDispenser.outCash(amount);
    }
    
    //关闭ATM
    public void turnoff(){
    	System.out.println("ATM已经关闭，谢谢使用！");
    	System.out.println("----------------------");
    }
}
