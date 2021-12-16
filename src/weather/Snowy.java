package weather;

public class Snowy extends Weather
{
	private int preWeatherRating = 15;
	private int postWeatherRating;
	public Snowy()
	{
		super();
		super.SetWeatherRating(super.randNum.nextInt(preWeatherRating) + 10);
		postWeatherRating = super.GetWeatherRating();
		super.SetWeatherEffect(super.randNum.nextInt(10), postWeatherRating);
		super.SetType("Rainy");
	}
}
