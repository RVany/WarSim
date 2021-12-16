package weather;

public class Windy extends Weather
{
	private int preWeatherRating = 25;
	private int postWeatherRating;
	public Windy()
	{
		super();
		super.SetWeatherRating(super.randNum.nextInt(preWeatherRating) + 10);
		postWeatherRating = super.GetWeatherRating();
		super.SetWeatherEffect(super.randNum.nextInt(10), postWeatherRating);
		super.SetType("Rainy");
	}
}

