package proj2fa15;

/**
 * <p>
 * Title: Fish class
 * </p>
 *
 * <p>
 * Description: inherits all thing from animal class. and just have name property
 * </p>
 *
 * @author Bikash Mainali
 */
public class Fish extends Animal {

	/**
	 * Default Fish constructor -- just give it a name of FISH.
	 */
	public Fish(){
		name= "FISH";
	}
	
	/**
	 * toString method -- this method returns the state of the Fish object
	 * @return a reference to a String object that contains the all information of the Fish.
	 */
	public String toString()
	{
		return name + " " + super.toString();
	}

}
