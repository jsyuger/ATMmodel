package diceGame;



public class DiceGame {
	private Die die1;
	private Die die2;
	
	public void play(){
		this.die1=new Die();
		this.die2=new Die();
		die1.roll();
		die2.roll();
		System.out.println("正在摇骰子，请稍后...");
	}
	
	public int[] gameResult(){
		//play();
		//游戏规则定义
		int sum;
		int a[]={die1.getFaceValue(),die2.getFaceValue()};
		sum=die1.getFaceValue()+die2.getFaceValue();
		System.out.printf("摇出来的是%d、%d，和为%d,",
				die1.getFaceValue(),die2.getFaceValue(),die1.getFaceValue()+die2.getFaceValue());
		if(sum%2==0)
			System.out.println("是偶数！You have lost!");
		else
			System.out.println("是奇数！You win!");
		
		return a;
	}
}
