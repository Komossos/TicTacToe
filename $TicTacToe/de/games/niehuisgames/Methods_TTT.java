package de.games.niehuisgames;

import java.util.Scanner;

public class Methods_TTT 
{
	static String[] gaps = {" "," "," "," "," "," "," "," "," "};
	static String field = "     1   2   3\nA: | "+gaps[0]+" | "+gaps[1]+" | "+gaps[2]+" |\nB: | "+gaps[3]+" | "+gaps[4]+" | "+gaps[5]+" |\nC: | "+gaps[6]+" | "+gaps[7]+" | "+gaps[8]+" |\n";
	static String playerName1, playerName2;
	static int cntrRounds = 0;
	static int[] gapValues = new int[9];
	static String[] comparePlayerInput = {"a1", "a2", "a3", "b1", "b2", "b3", "c1", "c2", "c3"};
	// static boolean playAgainBool = true;

		
	public static void greeting()
	{
		System.out.println("		Willkommen beim klassischen TicTacToe!");
		System.out.println("Gewonnen hat derjenige, der als erster drei seiner Elemente in eine Reihe bekommt.\n____________________________________________________________________________________\n");
	}
	
	public static void setPlayerName()
	{
		System.out.print("	Bitte gib den Namen von Spieler 1 ein: ");
		Scanner in = new Scanner(System.in);
		playerName1 = in.nextLine();
		System.out.print("	Bitte gib den Namen von Spieler 2 ein: ");
		playerName2 = in.nextLine();
		System.out.println("\nEs spielen "+playerName1+" und "+playerName2+" gegeneinander.\n");
	}
	
	public static String playGame()
	{
		if(cntrRounds%2 == 0) System.out.print(playerName1+" [O] ist am Zug: ");
		else System.out.print(playerName2+" [X] ist am Zug: ");

		Scanner in = new Scanner(System.in);
		String playerInput = in.nextLine();
		playerInput = playerInput.toLowerCase();
		if(playerInput.equals("exit")) System.exit(0);
		outerloop:
		while(true)
		{
			for(int i=0 ; i<9 ; i++)
			{
				if(playerInput.equals(comparePlayerInput[i])&&gaps[i].equals(" "))
				{
					if(cntrRounds%2 == 0)
					{
						gaps[i]="O";
						gapValues[i] = 1;
					}
					else
					{
						gaps[i]="X";
						gapValues[i] = -1;
					}
					cntrRounds++;
					break outerloop;
				}
			}
			System.out.println("\nEingabe war nicht zulässig.\n");
			if(cntrRounds%2 == 0) System.out.print(playerName1+" [O] ist am Zug: ");
			else System.out.print(playerName2+" [X] ist am Zug: ");
			playerInput = in.nextLine();
			playerInput = playerInput.toLowerCase();
			if(playerInput.equals("exit")) System.exit(0);

		}
		field = "     1   2   3\nA: | "+gaps[0]+" | "+gaps[1]+" | "+gaps[2]+" |\nB: | "+gaps[3]+" | "+gaps[4]+" | "+gaps[5]+" |\nC: | "+gaps[6]+" | "+gaps[7]+" | "+gaps[8]+" |\n";
		return field;
	}
	
	public static boolean checkWinCondition()
	{
		int[] check = new int[8];
		check[0] = gapValues[0]+gapValues[1]+gapValues[2];
		check[1] = gapValues[3]+gapValues[4]+gapValues[5];
		check[2] = gapValues[6]+gapValues[7]+gapValues[8];
		check[3] = gapValues[0]+gapValues[3]+gapValues[6];
		check[4] = gapValues[1]+gapValues[4]+gapValues[7];
		check[5] = gapValues[2]+gapValues[5]+gapValues[8];
		check[6] = gapValues[0]+gapValues[4]+gapValues[8];
		check[7] = gapValues[2]+gapValues[4]+gapValues[6];
		
		for(int i = 0; i < 8; i++)
		{
			if (check[i] == 3)
			{
				System.out.println("Glückwunsch, "+playerName1+" hat gewonnen");
				return true;
			}
			else if (check[i] == -3)
			{
				System.out.println("Glückwunsch, "+playerName2+" hat gewonnen");
				return true;
			}
		}
		return false;
	}

	public static void playAgain()
	{
		System.out.println("Möchtet ihr noch einmal spielen? [Y]/[N]");
		Scanner in = new Scanner(System.in);
		String controlPlayAgain = in.nextLine();
		controlPlayAgain = controlPlayAgain.toLowerCase();
		
		if(controlPlayAgain.equals("y"))
		{
		cntrRounds = 0;
		for(int i = 0; i<9; i++)
		{
			gaps[i]=" ";
			gapValues[i]=0;
		}
		field = "     1   2   3\nA: | "+gaps[0]+" | "+gaps[1]+" | "+gaps[2]+" |\nB: | "+gaps[3]+" | "+gaps[4]+" | "+gaps[5]+" |\nC: | "+gaps[6]+" | "+gaps[7]+" | "+gaps[8]+" |\n";
		}
	}
}
