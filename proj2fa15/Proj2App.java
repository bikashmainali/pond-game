package proj2fa15;
/**
 * <p>
 * Title: Project 2--Application class
 * </p>
 *
 * <p>
 * Description: Project2App implements all the other class to make the this
 * application work properly. This program asks user for a size of river. After
 * getting user input, this program create a river of that size and place random
 * animals (Bear or fish) in random place in river array. this program loops
 * until all condition are not met. condition are designed so that in debugging
 * process all the types of movement occurs.
 * </p>
 *
 * @author Bikash Mainali
 */

import javax.swing.JOptionPane;

public class Proj2App
{
	/**
	 * status method - It checks place of river. If there is nothing(null) it
	 * just store index of river in the string.if there are animal then it gets
	 * name, strength, index of the place and gender of the animal in that place
	 * of an array.
	 * 
	 * @param river is the reference to the array with water, river and bear.
	 */
	public static void status(Animal[] river)
	{
		String str = "---------------------------------------------------------------------------------------\n";
		for (int j = 0; j < river.length; j++)
		{
			// initialize local variable to store name, gender and stat
			String name = "";
			String gender = "";
			String stat = "";
			// if there is nothing in the index of river then print index.
			if (river[j] == null)
			{
				if ((j + 1) % 4 != 0)
				{
					stat = "          " + j + "          |";
				}
				// to make debugging easy add line after four element is
				// displayed.
				else if ((j + 1) % 4 == 0)
				{
					stat = "\n---------------------------------------------------------------------------------------\n"
							+ "          " + j + "          |\t";
				}
			}
			// if there is animal in that place than getname, gender and store
			// in a string.
			else if (river[j] != null)
			{
				name = river[j].name;
				gender = river[j].gender ? "Male" : "Female";
				float stren = river[j].strength;

				if ((j + 1) % 4 != 0)
				{
					stat = name + " " + gender + " " + j + " " + String.format("%.3f", stren) + " |";
				}
				// to make debugging easy add line after four element is
				// displayed.
				else if ((j + 1) % 4 == 0)
				{
					stat = "\n---------------------------------------------------------------------------------------\n"
							+ name + " " + gender + " " + j + " " + String.format("%.3f", stren) + " |";
				}
			}
			// concatenate all the element in an array.
			str = str + stat;
		}
		// after looking throught all the element in an array. Print the status
		// of the array.
		System.out.print(
				str + "\n---------------------------------------------------------------------------------------\n");
	}

	public static void main(String[] args)
	{
		// local variable
		int numberOfAttempts = 0;
		int sizeOfRiver = 0;
		// check total number of input and if the input is valid.
		while (numberOfAttempts < 3 && (sizeOfRiver < 10 || sizeOfRiver > 50))
		{
			// try catch is added to handle when user press invalid input.
			try
			{
				// get input from user and try to convert that integer.

				sizeOfRiver = Integer.parseInt(
						JOptionPane.showInputDialog("Enter size of your river in whole number between 10 to 50.\n"
								+ "Number of attempts remaining :" + (3 - numberOfAttempts)));
			}
			catch (NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Please Enter Valid numeric value.");
			}
			numberOfAttempts++;
		}
		// if user input valid size of the river.
		if (sizeOfRiver >= 10 && sizeOfRiver <= 50)
		{
			// create array of river.
			Animal[] river = new Animal[sizeOfRiver];
			int loopCounter = 0;

			// assign bear or fish object in random place in river array.
			while (loopCounter < (sizeOfRiver / 2))
			{
				// generate random number 0 or 1 each time in a loop
				// to determine which object
				int randomObject = (int) (Math.random() * 2);
				// generate random number from 0 to the value upto amount.
				// to specify position in an array
				int randomPosition = (int) (Math.random() * sizeOfRiver);
				// if the position of the place in array is null and
				// randomObject is 1, create a new Bear Object and store the in
				// a random position
				// generated
				if (river[randomPosition] == null && randomObject == 1)
				{
					river[randomPosition] = new Bear();
				}
				// if the position of the place in array is null and
				// randomObject is 0
				// create a new Fish Object and store the in a random position
				// generated
				else if (river[randomPosition] == null && randomObject == 0)
				{
					river[randomPosition] = new Fish();
				}
				else
				{
					loopCounter--;
				}
				loopCounter++;
			}
			// initialize river status print
			System.out.println("initial river:");
			status(river);
			System.out.println("--------------------------------------");
			System.out.println("--------------------------------------");

			// there are total of seven case that may occur in program.
			int value = 7654321;
			String val = value + "";
			int numOfLoop = 0;
			// while all the condition and total number of loop are less than 70
			// sometimes if the generated animals are only bears or fish then
			// some
			// condition may not satisfy which will make this program run in
			// infinite way. so if the loop is more than 40 times stop the loop.
			while (value > 0 && numOfLoop < 40)
			{
				// generate number upto the size of river.
				int randomPlaceInArray = (int) (Math.random() * sizeOfRiver);
				// if there is element in that place.
				if (river[randomPlaceInArray] != null)
				{
					// make movement and return the condition met.
					int valueReturn = river[randomPlaceInArray].movement(river, randomPlaceInArray); // Condition
					// valueReturn from 0 to 6. 0 is general so check.
					if (valueReturn > 0)
					{
						// System.out.println("value to move " + valueReturn);
						if (val.length() >= valueReturn && val.charAt(valueReturn - 1) != '0')
						{
							// get char value of the element at place value in
							// that place.
							char valueChar = val.charAt(valueReturn - 1);
							// convert that char value into interger.
							// valueCharInInt may get 1,2,3,4,5,6,7
							int valueCharInInt = Character.getNumericValue(valueChar);

							/*
							 * if value return is 1 than subtract 1 from
							 * 7654321. if value return is 2 than subtract 20
							 * from 7654321. if value return is 3 than subtract
							 * 300 from 7654321. if value return is 4 than
							 * subtract 4000 from 7654321. if value return is 5
							 * than subtract 50000 from 7654321. if value return
							 * is 6 than subtract 600000 from 7654321. if value
							 * return is 7 than subtract 7000000 from 7654321.
							 */
							// power generates
							// 1,10,100,1000,10000,100000,1000000
							int power = (int) (Math.pow(10, (valueCharInInt - 1)));
							// subtract power * valueCharInInt from value.
							value = value - (valueCharInInt * power);
							// as the condition met we change the value so it
							// effect the while loop.
							// System.out.println("new value :" + value);
							val = value + "";
						}
					}
					// print whole river array after each movement.
					status(river);
					// increase the loop value
					numOfLoop++;
				}
			}
		}
		else
		// if the user pass invalid input than show them to try again with valid
		// input.and program terminates
		{
			JOptionPane.showMessageDialog(null, "Try again with valid number between 10 and 50.");
		}
		//to denote that every thing is done print.
		System.out.println("\n\n                     All things are done and program quit normally.");
	}
}
