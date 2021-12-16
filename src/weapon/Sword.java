package weapon;

public class Sword extends Weapon
{
	private int minDamage = 100;
	private int maxDamage = 200;
	
	public Sword()
	{
		super();
		super.SetDamageAmount(minDamage, maxDamage);
		super.SetDexCost(super.randNum.nextInt(5) + 1);
		super.SetType("Sword");
	}
	
	@Override
	public int Strike(int attackType, int dex, int strength, int weather)
	{
		int damageAmount = 0;
		int hitChance = 0;
		int roll = 0;
		boolean hit = false;
		float heavyMod = 0.1f; // used as percent
		
		if(attackType == 1) // standard attack
		{
			hitChance = 50;
		}
		else // heavy
		{
			hitChance = 75;
		}
		// roll the dice
		roll = super.randNum.nextInt(100) + 1;
		
		if(roll >= hitChance)
		{
			hit = true;
			damageAmount = this.GetDamageAmount() - 
					this.randNum.nextInt(30) + 5;
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
	
} // end class







