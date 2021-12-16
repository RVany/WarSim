package warrior;
import java.util.Random;

public abstract class Warrior 
{
	protected Random randNum = new Random();
	private int health = 100;
	private int strength = 100;
	private int dexterity = 100;
	private String type;
	protected String[] types = {"Human", "Orc", "Elf", "Dragon"};
	
	public Warrior()
	{}
	
	public String GetType()
	{
		return type;
	}
	public void SetType(String type)
	{
		this.type = type;
	}
	public String[] GetTypes()
	{
		return types;
	}
	
	/////////////////////
	// getters
	public int GetHealth()
	{
		return this.health;
	}
	public int GetStrength()
	{
		return this.strength;
	}
	public int GetDexterity()
	{
		return this.dexterity;
	}
	
	///////////////////////
	// setters
	protected void SetHealth(int hMod)
	{
		this.health += hMod;
	}
	protected void SetStrength(int sMod)
	{
		this.strength += sMod;
	}
	protected void SetDexterity(int dMod)
	{
		this.dexterity += dMod;
	}
	public void SetDamage(int amount)
	{
		if(amount > 0)
			this.health -= amount;
	}
}










