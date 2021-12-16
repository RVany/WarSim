package armour;
import java.util.Random;

public abstract class Armour 
{
	protected Random randNum = new Random();
	private int defRating;
	private int dexCost;
	private String type;
	protected String[] types = {"Leather", "Chain", "Plate", "Shield"};
	
	public Armour()
	{}
	
	public String[] GetTypes()
	{
		return types;
	}
	
	//////////////////
	// getters
	public int GetDefRating()
	{
		return this.defRating;
	}
	public int GetDexCost()
	{
		return dexCost;
	}
	public String GetType()
	{
		return type;
	}
	//////////////////
	// setters
	public void SetDexCost(int cost)
	{
		this.dexCost -= cost;
	}
	
	public void SetDefRating(int min, int max)
	{
		this.defRating = randNum.nextInt(max) + min;
	}
	
}



