package warrior;

public class Dragon extends Warrior
{
	public Dragon()
	{
		super();
		super.SetHealth(super.randNum.nextInt(90) + 100);
		super.SetStrength(super.randNum.nextInt(150) + 200);
		super.SetDexterity(super.randNum.nextInt(100) + 50);
		super.SetType("Dragon");
	}
}