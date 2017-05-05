package diceGame;



public class DiceGame {
	private Die die1;
	private Die die2;
	
	public int[] play(){
		Die d1=new Die();
		this.die1=d1;
		Die d2=new Die();
		this.die1=d2;
		d1.roll();
		d2.roll();
		
		//游戏规则定义
		int sum;
		int a[]={d1.getFaceValue(),d2.getFaceValue()};
		sum=d1.getFaceValue()+d2.getFaceValue();
		System.out.printf("%d,%d",d1.getFaceValue(),d2.getFaceValue());
		if(sum%2==0)
			System.out.print("You have lost!");
		else
			System.out.print("You win!");
		
		return a;
	}
}
