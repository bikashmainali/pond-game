package proj2fa15;

/**
 * <p>
 * Title: Bear class
 * </p>
 *
 * <p>
 * Description: inherits all thing from animal class. and just have name
 * property
 * </p>
 *
 * @author Bikash Mainali
 */
public class Bear extends Animal
{
	/**
	 * Default Bear constructor -- just give it a name of Bear.
	 */
	public Bear()
	{
		name = "BEAR";
	}

	/**
	 * toString method -- this method returns the state of the Bear object
	 * @return a reference to a String object that contains the all information of the Bear.
	 */
	public String toString()
	{
		return name + " " + super.toString();
	}

}
