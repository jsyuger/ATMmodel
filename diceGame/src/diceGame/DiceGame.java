package diceGame;



public class DiceGame {
	private Die die1;
	private Die die2;
	
	public void play(){
		this.die1=new Die();
		this.die2=new Die();
		die1.roll();
		die2.roll();
		System.out.println("����ҡ���ӣ����Ժ�...");
	}
	
	public int[] gameResult(){
		//play();
		//��Ϸ������
		int sum;
		int a[]={die1.getFaceValue(),die2.getFaceValue()};
		sum=die1.getFaceValue()+die2.getFaceValue();
		System.out.printf("ҡ��������%d��%d����Ϊ%d,",
				die1.getFaceValue(),die2.getFaceValue(),die1.getFaceValue()+die2.getFaceValue());
		if(sum%2==0)
			System.out.println("��ż����You have lost!");
		else
			System.out.println("��������You win!");
		
		return a;
	}
}
