package proj2fa15;

/**
 * <p>
 * Title: River class
 * </p>
 *
 * <p>
 * Description: it check if the animal collide or not when it tries to move. if
 * same animal with same gender collide, animal with greater strength win. If
 * the they have same strength then animal moving from win and animal in that
 * position dies. if same animal with different gender collide then it creates
 * new object(animal) in random empty space in the river. If different animal
 * collide with each other then Fish dies.
 * </p>
 *
 * @author Bikash Mainali
 */
public class River
{
	
	public int checkcollide(Animal[] animals, int positionMovingFrom, int positionMovingInto)
	{
		//local variable
		int condition = -1;
		boolean status = true;
		
		//if the position moving into is not empty and status is true
		if (animals[positionMovingInto] != null && status == true)
		{
			boolean genderInFirst = true;
			boolean genderInSecond = true;
			String nameFirst = "";
			String nameSecond = "";
			//animal which is trying to move.
			System.out.println(
					"animals[" + positionMovingFrom + "] is trying to move to position : " + positionMovingInto);
			// if same animal then 
			if (animals[positionMovingInto].name.equals(animals[positionMovingFrom].name))
			{
				//get and print animal name.
				System.out.println("same animal : " + animals[positionMovingInto].name);
				// if same gender
				if (animals[positionMovingInto].gender == animals[positionMovingFrom].gender)
				{
					//print the gender but if it is true than print male else print Female.
					System.out.println("same Gender : " + (animals[positionMovingFrom].gender ? "Male" : "female"));
					// compare strength
					// if animal moving from is has greater or equal strength than animal moving from wins and take the palce.
					if (animals[positionMovingFrom].strength >= animals[positionMovingInto].strength)
					{
						
						System.out.println("river[" + positionMovingInto + "] = "
								+ animals[positionMovingInto].strength + "\nriver[" + positionMovingFrom + "] = "
								+ animals[positionMovingFrom].strength);
						animals[positionMovingInto] = animals[positionMovingFrom];
						System.out.println(positionMovingFrom + " wins and is in " + positionMovingInto + "\n");
						System.out.println(
								"river[" + positionMovingInto + "] = " + animals[positionMovingInto].toString());
						animals[positionMovingFrom] = null;
						//status changes end the loop.
						status = false;
						// first condition met.
						System.out.println("first Condition Met");
						condition = 0;
					}
					else if (animals[positionMovingFrom].strength < animals[positionMovingInto].strength)
					{
						
						System.out.println(positionMovingFrom + " loose and died");
						animals[positionMovingFrom] = null;
						System.out.println("river[" + positionMovingFrom + "] =  null");
						System.out.println(
								"river[" + positionMovingInto + "] = " + animals[positionMovingInto].toString());
						status = false;
						// second condition met
						condition = 1;

						System.out.println("Second Condition Met");
					}

				}
				// different gender
				try
				{
					genderInFirst = animals[positionMovingInto].gender;
					genderInSecond = animals[positionMovingFrom].gender;
				}
				catch (NullPointerException e)
				{
					//i don't want my user to panic but all thing tested.
				}

				if (genderInFirst != genderInSecond && status == true)
				{
					System.out.println("different gender collide");
					int n = 0;
					while (n == 0)
					{

						int generateNumOfSizeRiver = (int) (Math.random() * animals.length);
						if (animals[generateNumOfSizeRiver] == null)
						{
							System.out.println("generating new object in random place");
							if (animals[positionMovingInto] instanceof Bear)
							{
								animals[generateNumOfSizeRiver] = new Bear();
								System.out.println("Bear object created in position " + generateNumOfSizeRiver);
								System.out.println("river[" + generateNumOfSizeRiver + "] = "
										+ animals[generateNumOfSizeRiver].toString());
								status = false;

								System.out.println("Third Condition Met");
								condition = 2;

							}
							else if (animals[positionMovingInto] instanceof Fish)
							{
								animals[generateNumOfSizeRiver] = new Fish();
								System.out.println("Fish object created in position " + generateNumOfSizeRiver);
								System.out.println("river[" + generateNumOfSizeRiver + "] = "
										+ animals[generateNumOfSizeRiver].toString());
								status = false;

								System.out.println("Fourth Condition Met");
								condition = 3;
							}
							n = 1;
						}
					}
				}

			}
			// different animal
			try
			{
				nameFirst = animals[positionMovingInto].name;
				nameSecond = animals[positionMovingFrom].name;
			}
			catch (Exception e)
			{
			}
			if ((nameFirst.equals(nameSecond)) == false && status == true)
			{
				System.out.println("different animal");
				// nameFirst = river[positionMovingInto].name;
				// String animal2 = river[positionMovingFrom].name;
				if (nameFirst.equals("BEAR"))
				{
					System.out.println("animal moving to " + positionMovingInto + " died");
					animals[positionMovingFrom] = null;

					System.out.println("river[" + positionMovingFrom + "] =  null");
					System.out.println("river[" + positionMovingInto + "] = " + animals[positionMovingInto].toString());
					status = false;

					System.out.println("Fifth Condition Met");
					condition = 4;
				}
				if (nameSecond.equals("BEAR"))
				{
					System.out.println("animal moving to " + positionMovingInto + " wins and is there");
					animals[positionMovingInto] = animals[positionMovingFrom];
					animals[positionMovingFrom] = null;
					System.out.println("river[" + positionMovingInto + "] = " + animals[positionMovingInto].toString());
					status = false;

					System.out.println("Sixth Condition Met");
					condition = 5;
				}
			}
		}
		else if (animals[positionMovingInto] == null)
		{
			System.out.println("animal[" + positionMovingFrom + "] moving to position : " + positionMovingInto);
			System.out.println("animal move to empty place " + positionMovingInto);
			animals[positionMovingInto] = animals[positionMovingFrom];
			System.out.println("river[" + positionMovingInto + "] = " + animals[positionMovingInto].toString());
			animals[positionMovingFrom] = null;

			System.out.println("Seventh Condition Met");
			condition = 6;
		}
		System.out.println("-----------------------------------");
		return condition;
	}

}
