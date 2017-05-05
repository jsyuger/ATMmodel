package diceGame;



public class Die {
	private int faceValue;

	public int getFaceValue() {
		return faceValue;
	}

	public void roll() {
		this.faceValue = (int) (Math.random()*6+1);
	}
	
}
