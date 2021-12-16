package weapon;
import java.util.Random;

public abstract class Weapon 
{
	protected Random randNum = new Random();
	private int damageAmount;
	private int dexCost;
	private String type;
	protected String[] types = {"Sword", "Bow", "Axe", "Pistol"};
	
	public Weapon()
	{}
	
	public String[] GetTypes()
	{
		return types;
	}
	
	////////////////////
	// getters
	public int GetDamageAmount()
	{
		return damageAmount;
	}
	public String GetType()
	{
		return type;
	}
	
	////////////////////
	// setters
	public void SetDexCost(int cost)
	{
		this.dexCost -= cost;
	}
	public void SetDamageAmount(int min, int max)
	{
		this.damageAmount = randNum.nextInt(max) + min;
	}
	public void SetType(String type)
	{
		this.type = type;
	}
	
	public abstract int Strike(int attackType, int dex,
			int strength, int weather);
}












