package warrior;

public class Orc extends Warrior
{
	public Orc()
	{			
		super();
		super.SetHealth(super.randNum.nextInt(70) + 90);					
		super.SetStrength(super.randNum.nextInt(100) + 150);
		super.SetDexterity(- super.randNum.nextInt(30) + 10);
		super.SetType("Orc");
	}
}