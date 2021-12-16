package armour;

public class Chain extends Armour
{
	private int minDefRating = 100;
	private int maxDefRating = 200;
	
	public Chain()
	{
		super();
		super.SetDefRating(minDefRating, maxDefRating);
		super.SetDexCost(super.randNum.nextInt(20) + 10);
	}
}
