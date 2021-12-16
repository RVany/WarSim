package warrior;

public class Elf extends Warrior
{
	public Elf()
	{
		super();
		super.SetHealth(super.randNum.nextInt(40) + 50);
		super.SetStrength(- super.randNum.nextInt(10) + 30);
		super.SetDexterity(super.randNum.nextInt(100) + 20);
		super.SetType("Elf");
	}
}