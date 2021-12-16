package armour;

public class Shield extends Armour
{
	private int minDefRating = 300;
	private int maxDefRating = 400;
	
	public Shield()
	{
		super();
		super.SetDefRating(minDefRating, maxDefRating);
		super.SetDexCost(super.randNum.nextInt(40) + 20);
	}
}