package proj2fa15;

/**
 * <p>
 * Title: Animal class
 * </p>
 *
 * <p>
 * Description: Animal class has strength, gender and name property. It contains
 * all the property of animal. property
 * </p>
 *
 * @author Bikash Mainali
 */
public class Animal
{
	// instance variable
	protected float		strength;
	protected boolean	gender;
	protected String	name;

	// create river object.
	River river = new River();

	/**
	 * Default constructor- When any object of animal or it's subclass is
	 * created it generates a random float number. Created a random number for
	 * gender and assign gender.
	 * 
	 */
	public Animal()
	{
		strength = (float) Math.random() * 100;
		int randomNumforGender = (int) (Math.random() * 2);

		if (randomNumforGender == 1)
		{
			gender = true;
		}
		else
		{
			gender = false;
		}
	}

//	/**
//	 * getStrength accessor method this accessor method returns the value stored
//	 * in the strength instance variable
//	 * 
//	 * @return value stored as strength
//	 * 
//	 */
//	public float getStrength()
//	{
//		return strength;
//	}
//	
//	/**
//	 * getGender accessor method this accessor method returns the value stored
//	 * in the strength instance variable but change as it is male or female.
//	 * 
//	 * @return value stored as male or female.
//	 */
//	public String getGender()
//	{
//		String str = gender ? "Male" : "female";
//		return str;
//	}
//
//	/**
//	 * getName accessor method this accessor method returns the value stored in
//	 * the name instance variable.
//	 * 
//	 * @return value stored in name.
//	 */
//	public String getName()
//	{
//		return name;
//	}

	/**
	 * movement method- this method determines in which direction the animal
	 * want to move. This is determined by a random number generated in the
	 * beginning. After movement is determined it calls checkcollide method on
	 * river class.
	 * 
	 * @param animal-
	 *            animal is the reference to the river.
	 * @param position-
	 *            position is determined which animal wants to move in the
	 *            river.
	 * @return condition - condition met on the time of execution. default
	 *         condition is 0. But we get value of condition from river class
	 *         when movement is done.
	 */
	public int movement(Animal[] animal, int position)
	{
		int movementPosition = (int) (Math.random() * 3);
		int condition = 0;
		switch (movementPosition)
		{
			case 0:
				if (position != 0)
				{
					condition = river.checkcollide(animal, position, (position - 1));
				}
				break;
			case 1:
				System.out.println("animal at " + position + " position is not moving.");
				System.out.println("animal do not move and is in same place\n" + "river[" + position + "] = "+
				animal[position].toString() +"\n-----------------------------------");
				break;
			case 2:
				if (position != (animal.length - 1))
				{
					condition = river.checkcollide(animal, position, (position + 1));
				}
				break;
			default:
				break;
		}
		return condition;
	}

	/**
	 * toString method -- this method returns the state of the Bear object
	 * 
	 * @return a reference to a String object that contains the all information
	 *         of the Bear.
	 */
	public String toString()
	{
		String Gender = gender ? "MALE" : "FEMALE";
		String str = strength + " " + Gender;
		return str;
	}

}
