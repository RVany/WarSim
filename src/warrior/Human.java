package warrior;

public class Human extends Warrior
{
	public Human()
	{			
		super();
		super.SetHealth(super.randNum.nextInt(10) + 50);					
		super.SetStrength(super.randNum.nextInt(30) + 40);
		super.SetDexterity(super.randNum.nextInt(10));
		super.SetType("Human");
	}
}