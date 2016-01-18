package modelPart;

public interface InterfaceModel 
{
	
	/**Method move takes the index of a pit which player chooses and the number of stones in the pit
	 * and returns the index of the array where last stone is place. 
	 * @param startIndex
	 * @param stone
	 * @return int the index of last stone moved
	 */
	public void move(int player);
	
	/**Method isFinish check if all the stones are gone from one player's the pit
	 * @return ture if the game is over
	 */
	public boolean isFinish();
	
	/**
	 * method declareWinner shows the winner and ending score
	 */
	public void declareWinner();

}
