import warrior.*;
import armour.*;
import weapon.*;
import weather.*;

public class Printer 
{
	private Warrior wTypes = new Human(); // must be a child
	private Armour aTypes = new Leather(); // must be a child
	private Weapon wepTypes = new Sword(); // must be a child
	private Weather weaTypes = new Rainy(); // must be a child
	public Printer()
	{}
	
	public void AttackTypes()
	{
		System.out.println("\nPlease pick a Attack Type: ");
		System.out.println("\n////////////////////////////////");
		System.out.printf("1) %s 2) %s\n", "Standard", "Heavy");
		System.out.println("////////////////////////////////\n");
	}
	public void PrintPlayAgain()
	{
		System.out.println("\nDo you want to Play Again? ");
		System.out.println("////////////////////////////////");
		System.out.printf("1) %s 2) %s\n", "Yes", "No");
		System.out.println("////////////////////////////////\n");
	}
	
	public void PrintStats(Warrior pWarrior, Warrior eWarrior)
	{
		System.out.println("////////////////////////////////");
		System.out.println(" Player(" + pWarrior.GetType() + ")");
		System.out.printf(" Health: %s\n Strength: %s\n Dexterity: %s\n", 
				pWarrior.GetHealth(), 
				pWarrior.GetStrength(), 
				pWarrior.GetDexterity());
		System.out.println("\n////////////////////////////////");
		System.out.println(" Enemy(" + eWarrior.GetType() + ")");
		System.out.printf(" Health: %s\n Strength: %s\n Dexterity: %s\n", 
				eWarrior.GetHealth(), 
				eWarrior.GetStrength(), 
				eWarrior.GetDexterity());
	}
	
	
	
	public void PrintWelcome()
	{
		System.out.println("\n/////////////////////////////////////////////");
		System.out.println("// Welcome to WarSim 18, prepare to die... //");
		System.out.println("///////////////////////////////////////////// ");
	}
	
	public void PrintWarriors()
	{
		System.out.println("\nPlease pick a warrior: ");
		String[] warriors = wTypes.GetTypes();
		for(int i = 0; i < warriors.length; i++)
		{
			System.out.println(i + 1 + ") " + warriors[i]);
		}
	}
	
	public void PrintArmour()
	{
		System.out.println("\nPlease pick armour: ");
		String[] armour = aTypes.GetTypes();
		for(int i = 0; i < armour.length; i++)
		{
			System.out.println(i + 1 + ") " + armour[i]);
		}
	}
	
	public void PrintWeapons()
	{
		System.out.println("\nPlease Pick weapon: ");
		String[] weapons = wepTypes.GetTypes();
		for(int i = 0; i < weapons.length; i++)
		{
			System.out.println(i + 1 + ") " + weapons[i]);
		}
	}
	public void PrintWeather()
	{
		System.out.println("\nPlease Pick weather: ");
		String[] weather = weaTypes.GetTypes();
		for(int i = 0; i < weather.length; i++)
		{
			System.out.println(i + 1 + ") " + weather[i]);
		}
	}
} 



