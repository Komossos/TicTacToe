package de.games.niehuisgames;

public class Main_TTT 
{
	public static void main(String[] args) 
	{
		Methods_TTT.greeting();
		Methods_TTT.setPlayerName();
		System.out.println(Methods_TTT.field);
		while(Methods_TTT.cntrRounds<9)
		{
			System.out.println(Methods_TTT.playGame());
		    if(Methods_TTT.checkWinCondition() == true)
		    {
		    	System.exit(0);
		    }
		}
		if(Methods_TTT.cntrRounds==9)
		{
			System.out.println("Unentschieden.");
		}
	}
}
