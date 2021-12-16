import warrior.*;
import armour.*;
import weapon.*;
import weather.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class BattleMain 
{
	private static Scanner input = new Scanner(System.in);
	private static Random randNum = new Random();
	
	private static boolean isPlayer = true;
	private static boolean gameOver = false;
	private static boolean playerTurn = true;
	private static boolean playAgain = false;
	
	private static int attackType = 0;
	private static int damageAmount = 0;
	
	private static Printer printer = new Printer();
	private static Warrior pWarrior;
	private static Warrior eWarrior;
	private static Armour pArmour;
	private static Armour eArmour;
	private static Weapon pWeapon;
	private static Weapon eWeapon;
	private static Weather pWeather;
	private static Weather eWeather;

	public static void main(String[] args) 
	{
		printer.PrintWelcome();
		SetupGame();
		printer.PrintStats(pWarrior, eWarrior);
		
		//===========================>>
		// Main Game Loop
		while(!gameOver)
		{
			if(playerTurn)
			{
				// prompt player for attack type
				boolean valueBad = true;
				do 
				{
					try
					{
						
						printer.AttackTypes();
						attackType = input.nextInt();
						
						if(attackType >= 1 && attackType <= 2)
						{
							valueBad = false;
						}
						else 
						{
							
							System.out.println("\n" + attackType + " is not an option.\nPlease Select only 1 or 2");
							input.nextLine(); // discards the input
							valueBad = true;
						}
					}
					catch(InputMismatchException attack)
					{
						System.out.println("\n" + input.next() + " is not an option.\nPlease Select only 1 or 2");
						input.nextLine(); // discards the input
						valueBad = true;
					}
					
				}while(valueBad);
				// determine if hit/miss
						damageAmount =	pWeapon.Strike(attackType,
						pWarrior.GetDexterity(), 
						pWarrior.GetStrength(), pWeather.GetWeatherEffect());
						
										
				
				// take health away from enemy if hit
				eWarrior.SetDamage(damageAmount);
				
				if(damageAmount <= 0)
				{
					System.out.println("The Player Miss.\n");
				}
				
				else
				{
					System.out.println("The Player Hit with " + damageAmount +" of his Power.\n" );
					
					if(eWarrior.GetHealth() >0)
					{
						System.out.println("The Enemy Still has  " + eWarrior.GetHealth() +" of His Health.\n" );	
					}
					else 
					{
						System.out.println("The Enemy Loose All of His Health." );
					}
				}
				
				// check to see if enemy died
				if(eWarrior.GetHealth() <= 0)
				{
					
					System.out.println("\nPlayer Wins.");
					gameOver = PlayAgain();
				}
				
				playerTurn = false;
			}
			else
			{
				// pick an attack type
				attackType = randNum.nextInt(2) + 1;
				
				// strike
				damageAmount = eWeapon.Strike(attackType,
						eWarrior.GetDexterity(), 
						eWarrior.GetStrength(), pWeather.GetWeatherEffect());
				
				// take health from player
				pWarrior.SetDamage(damageAmount);
				
				if(damageAmount <= 0)
				{
					System.out.println("The Enemy Miss.\n");
				}
				
				else
				{
					System.out.println("The Enemy Hit with " + damageAmount +" of his Power.\n" );
					
					if(pWarrior.GetHealth() >0)
					{
						System.out.println("The player still has  " + pWarrior.GetHealth() +" of His Health.\n" );	
					}
					else 
					{
						System.out.println("The Player Loose All of His Health." );
					}
				}
				

				if(pWarrior.GetHealth() <= 0)
				{
					
					System.out.println("\nEnemy Wins.");
					gameOver = PlayAgain();
				}
				
				playerTurn = true;
			}
			//printer.PrintStats(pWarrior, eWarrior);
		} // end game loop
	} // end main
	
	public static boolean PlayAgain()
	{
		boolean isGameOver = true;
		boolean valueBad = true;
		int choice = 0;
		
		do 
		{
			try
			{
				printer.PrintPlayAgain();
				choice = input.nextInt();
				if(choice >= 1 && choice <= 2)
				{
					valueBad = false;
				}
				else 
				{
					
					System.out.println( "\n" + choice +  " is not an option.\n"  + "Please Select only 1 or 2");
					input.nextLine(); // discards the input
					valueBad = true;
				}
			}
			
			catch(InputMismatchException elvis)
			{
				System.out.println("\n\""+input.next()+"\"" + " is not an option.\n"  + "Please Select only 1 or 2");
				input.nextLine(); // discards the input
				valueBad = true;
			}
			
		}while(valueBad);
		
		if(choice == 1)
		playAgain = true;
		if(playAgain)
		{
			SetupGame();
			isGameOver = false;
		}
		else
		{
			System.out.println("\nThank You for playing.\nGood Bye!");
			isGameOver = true;
		}
		return isGameOver;
	}
	
	public static void SetupGame()
	{
		isPlayer = true;
		gameOver = false;
		playerTurn = true;
		playAgain = false;
		
		attackType = 0;
		damageAmount = 0;
		
		Warrior pWarrior = null;
		Warrior eWarrior = null;
		Armour pArmour = null;
		Armour eArmour = null;
		Weapon pWeapon = null;
		Weapon eWeapon = null;
		Weather pWeather = null;
		Weather eWeather = null;
		
		//================>>
		// Player Setup
		int choice = 0;
		boolean valueBad = true;
		
		/////////////////////
		// Warrior Choice
		do 
		{
			try
			{
				printer.PrintWarriors();
				choice = input.nextInt();
				if(choice >= 1 && choice <= 4)
				{
					valueBad = false;
				}
				else 
				{
					
					System.out.println( "\n" + choice +  " is not an option.\n"  + "Please Select only 1 2 3 or 4");
					input.nextLine(); // discards the input
					valueBad = true;
				}
			}
			
			catch(InputMismatchException elvis)
			{
				System.out.println("\n\""+input.next()+"\"" + " is not an option.\n"  + "Please Select only 1 2 3 or 4");
				input.nextLine(); // discards the input
				valueBad = true;
			}
			
		}while(valueBad);
		CreateWarrior(choice, isPlayer);
		valueBad = true;
		
		/////////////////////
		// Armour Choice
		do 
		{
			try
			{
				printer.PrintArmour();
				choice = input.nextInt();
				if(choice >= 1 && choice <= 4)
				{
					valueBad = false;
				}
				else 
				{
					
					System.out.println( "\n" + choice +  " is not an option.\n"  + "Please Select only 1 2 3 or 4");
					input.nextLine(); // discards the input
					valueBad = true;
				}
			}
			catch(InputMismatchException elvis)
			{
				System.out.println("\n\""+input.next()+"\"" + " is not an option.\n"  + "Please Select only 1 2 3 or 4");
				input.nextLine(); // discards the input
				valueBad = true;
			}
		
		}while(valueBad);
		CreateArmour(choice, isPlayer);
		valueBad = true;
		
		/////////////////////
		// Weapon Choice
		do 
		{
			try
			{
				printer.PrintWeapons();
				choice = input.nextInt();
				if(choice >= 1 && choice <= 4)
				{
					valueBad = false;
				}
				else 
				{
					
					System.out.println( "\n" + choice +  " is not an option.\n"  + "Please Select only 1 2 3 or 4");
					input.nextLine(); // discards the input
					valueBad = true;
				}
			}
			catch(InputMismatchException elvis)
			{
				System.out.println("\n\""+input.next()+"\"" + " is not an option.\n"  + "Please Select only 1 2 3 or 4");
				input.nextLine(); // discards the input
				valueBad = true;
			}
			
		}while(valueBad);
		CreateWeapon(choice, isPlayer);
		valueBad = true;
		
		/////////////////////
		// Weather Choice
		do 
		{
			try
			{
				printer.PrintWeather();
				choice = input.nextInt();
				if(choice >= 1 && choice <= 4)
				{
					valueBad = false;
				}
				else 
				{
					
					System.out.println( "\n" + choice +  " is not an option.\n"  + "Please Select only 1 2 3 or 4");
					input.nextLine(); // discards the input
					valueBad = true;
				}
			}
			catch(InputMismatchException elvis)
			{
				System.out.println("\n\""+input.next()+"\"" + " is not an option.\n"  + "Please Select only 1 2 3 or 4");
				input.nextLine(); // discards the input
				valueBad = true;
			}
			
		}while(valueBad);
		CreateWeather(choice, isPlayer);
		
		//========================>>
		// Enemy Setup
		
		isPlayer = false;
		CreateWarrior(randNum.nextInt(4) + 1, isPlayer);
		CreateArmour(randNum.nextInt(4) + 1, isPlayer);
		CreateWeapon(randNum.nextInt(4) + 1, isPlayer);
		CreateWeather(randNum.nextInt(4) + 1, isPlayer);
	}
	
	public static void CreateWarrior(int choice, boolean isPlayer)
	{
		if(isPlayer)
		{
			switch(choice)
			{
				case 1:
				{
					pWarrior = new Human();
					break;
				}
				case 2:
				{
					pWarrior = new Orc();
					break;
				}
				case 3:
				{
					pWarrior = new Elf();
					break;
				}
				case 4:
				{
					pWarrior = new Dragon();
					break;
				}
			}
		}
		else
		{
			switch(choice)
			{
				case 1:
				{
					eWarrior = new Human();
					break;
				}
				case 2:
				{
					eWarrior = new Orc();
					break;
				}
				case 3:
				{
					eWarrior = new Elf();
					break;
				}
				case 4:
				{
					eWarrior = new Dragon();
					break;
				}
			}
		}
	} // end CreateWarrior
	
	public static void CreateArmour(int choice, boolean isPlayer)
	{
		if(isPlayer)
		{
			switch(choice)
			{
				case 1:
				{
					pArmour = new Leather();
					break;
				}
				case 2:
				{
					pArmour = new Chain();
					break;
				}
				case 3:
				{
					pArmour = new Plate();
					break;
				}
				case 4:
				{
					pArmour = new Shield();
					break;
				}
			}
		}
		else
		{
			switch(choice)
			{
				case 1:
				{
					eArmour = new Leather();
					break;
				}
				case 2:
				{
					eArmour = new Chain();
					break;
				}
				case 3:
				{
					eArmour = new Plate();
					break;
				}
				case 4:
				{
					eArmour = new Shield();
					break;
				}
			}
		}
	} // end CreateArmour
	
	public static void CreateWeapon(int choice, boolean isPlayer)
	{
		if(isPlayer)
		{
			switch(choice)
			{
				case 1:
				{
					pWeapon = new Sword();
					break;
				}
				case 2:
				{
					pWeapon = new Bow();
					break;
				}
				case 3:
				{
					pWeapon = new Axe();
					break;
				}
				case 4:
				{
					pWeapon = new Pistol();
					break;
				}
			}
		}
		else
		{
			switch(choice)
			{
				case 1:
				{
					eWeapon = new Sword();
					break;
				}
				case 2:
				{
					eWeapon = new Bow();
					break;
				}
				case 3:
				{
					eWeapon = new Axe();
					break;
				}
				case 4:
				{
					eWeapon = new Pistol();
					break;
				}
			}
		}
	} // end CreateWeapon
	public static void CreateWeather(int choice, boolean isPlayer)
	{
		if(isPlayer)
		{
			switch(choice)
			{
				case 1:
				{
					pWeather = new Rainy();
					break;
				}
				case 2:
				{
					pWeather = new Snowy();
					break;
				}
				case 3:
				{
					pWeather = new Sunny();
					break;
				}
				case 4:
				{
					pWeather = new Windy();
					break;
				}
			}
		}
		else
		{
			switch(choice)
			{
				case 1:
				{
					eWeather = new Rainy();
					break;
				}
				case 2:
				{
					eWeather = new Snowy();
					break;
				}
				case 3:
				{
					eWeather = new Sunny();
					break;
				}
				case 4:
				{
					eWeather = new Windy();
					break;
				}
			}
		}
	} // end CreateWeather

} // end class


























