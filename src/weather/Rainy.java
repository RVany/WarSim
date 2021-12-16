package weather;

public class Rainy extends Weather
{
	private int preWeatherRating = 10;
	private int postWeatherRating;
	public Rainy()
	{
		super();
		super.SetWeatherRating(super.randNum.nextInt(preWeatherRating) + 10);//Set the weatherrating 10 - 19
		postWeatherRating = super.GetWeatherRating();//10 - 19
		super.SetWeatherEffect(super.randNum.nextInt(10), postWeatherRating);//min(0-9)max(10 -19) WeatherEffect(0-28)
		super.SetType("Rainy");
	}
}
