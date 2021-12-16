package weather;

public class Sunny extends Weather
{
	private int preWeatherRating = 20;
	private int postWeatherRating;
	public Sunny()
	{
		super();
		super.SetWeatherRating(super.randNum.nextInt(preWeatherRating) + 10);
		postWeatherRating = super.GetWeatherRating();
		super.SetWeatherEffect(super.randNum.nextInt(10), postWeatherRating);
		super.SetType("Rainy");
	}
}
