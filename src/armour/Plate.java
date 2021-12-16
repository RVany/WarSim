package armour;

public class Plate extends Armour
{
	private int minDefRating = 200;
	private int maxDefRating = 300;
	
	public Plate()
	{
		super();
		super.SetDefRating(minDefRating, maxDefRating);
		super.SetDexCost(super.randNum.nextInt(30) + 20);
	}
}