package diceGame;


public class Player {
	private DiceGame dicegame;
	
	public void start(){
		this.dicegame=new DiceGame();
		dicegame.play();
	}
	
	public int[] end(){
		return dicegame.gameResult();
		//System.out.print("1");
	}

}
