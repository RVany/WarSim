package armour;

public class Leather extends Armour
{
	private int minDefRating = 50;
	private int maxDefRating = 100;
	
	public Leather()
	{
		super();
		super.SetDefRating(minDefRating, maxDefRating);
		super.SetDexCost(super.randNum.nextInt(10) + 1);
	}
}
