package weapon;

public class Axe extends Weapon
{
	private int minDamage = 150;
	private int maxDamage = 250;
	
	public Axe()
	{
		super();
		super.SetDamageAmount(minDamage, maxDamage);
		super.SetDexCost(super.randNum.nextInt(20) + 10);
		super.SetType("Axe");
	}
	
	@Override
	public int Strike(int attackType, int dex, int strength, int weather)
	{
		int damageAmount = 0;
		int hitChance = 0;
		int roll = 0;
		boolean hit = false;
		float heavyMod = 0.2f; // used as percent
		
		if(attackType == 1) // standard attack
		{
			hitChance = 60;
			
			
			
		}
		else // heavy
		{
			hitChance = 85;
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
			damageAmount -=(weather - 25);
		}
					
		return damageAmount;
	}
}
