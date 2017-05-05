package diceGame;


public class Player {
	private DiceGame dicegame;
	
	public int[] start(){
		DiceGame diceGame=new DiceGame();
		this.dicegame=diceGame;
		return diceGame.play();
		//System.out.print("1");
	}

}
