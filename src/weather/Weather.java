package weather;
import java.util.Random;


public abstract class Weather {

	protected Random randNum = new Random();
	private int weatherRating;
	private int weatherEffect;
	private String type;
	protected String[] types = {"Rainy", "Snowy", "Sunny", "Windy"};
	
	public Weather()
	{}
	
	public String[] GetTypes()
	{
		return types;
	}
	
	//////////////////
	// getters
	public int GetWeatherRating()
	{
	return this.weatherRating;
	}
	public int GetWeatherEffect()
	{
	return weatherEffect;
	}
	public String GetType()
	{
	return type;
	}
	//////////////////
	// setters
	public void SetWeatherRating(int rate)
	{
	this.weatherRating = rate;
	}
	
	public void SetWeatherEffect(int min, int max)
	{
	this.weatherEffect = randNum.nextInt(max) + min;
	}
	public void SetType(String type)
	{
		this.type = type;
	}
}
