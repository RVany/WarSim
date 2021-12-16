package weapon;

public class Bow extends Weapon
{
	private int minDamage = 70;
	private int maxDamage = 150;
	
	public Bow()
	{
		super();
		super.SetDamageAmount(minDamage, maxDamage);
		super.SetDexCost(- super.randNum.nextInt(10) + 1);
		super.SetType("Bow");
	}
	
	@Override
	public int Strike(int attackType, int dex, int strength, int weather)
	{
		int damageAmount = 0;
		int hitChance = 0;
		int roll = 0;
		boolean hit = false;
		float heavyMod = 0.05f; // used as percent
		
		if(attackType == 1) // standard attack
		{
			hitChance = 40;
		}
		else // heavy
		{
			hitChance = 65;
		}
		// roll the dice
		roll = super.randNum.nextInt(100) + 1;
		
		if(roll >= hitChance)
		{
			hit = true;
			damageAmount = this.GetDamageAmount() - 
					this.randNum.nextInt(20) + 5;
			if(attackType == 2)
			{
				damageAmount += damageAmount * heavyMod;
			}
		}
		//affect weather effect
		if(weather>=25)
		{
			damageAmount +=(weather - 25);
		}
		return damageAmount;
	}
}
