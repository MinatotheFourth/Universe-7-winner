import java.util.Random;
import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
	{
		//Variables for getting the index, input, final string, and the string from the input 
		Random mix = new Random();
		Scanner input = new Scanner(System.in);
		String MVP, answer;
		
		//Our arrary of fighters
		String[] fighters = {"Android 17", "Goku", "Frieza", "Vegeta", "Gohan", 
				"Android 18", "Piccolo", "Master Roshi", "Tien", "Krillin"};
		
		//Greeting statement
		System.out.println("This time, the winner of this tournament is entirely randomized."
				+ "\nEven though Android 17 canonically won, even he's not safe from elimination this time."
				+ "\nStill, that doesn't mean he can't win this one too."
				+ "\nHe just has a 10% chance of doing so now.");
		System.out.print("\nGo ahead, press s to get started! ");
		
		//Initial input
		answer = input.nextLine();
		
		//This is for when the user input the wrong charater or nothing
		if(!(answer.equalsIgnoreCase("s")))
				do {
					
					System.out.println("Incorrect input! Enter s!");
					answer = input.nextLine();
					
				}while(!(answer.equalsIgnoreCase("s")));
			
		//This is where the method is used and prints out the returned data
		MVP = eliminate(input, fighters, answer, mix);
		System.out.println("\nThe survivor of Universe 7 is " + MVP + "!");

	}
	
	//This method here will eliminate the fighters one by one entirely at random
	public static String eliminate(Scanner i, String[] U7, String a, Random r)
	{
		//Declaring variables
		String winner = null;	
		int count = 0;
		int index;
		
		//This is the main loop in which the eliminations will take place
		do
		{
			//User is told to enter "e" to eliminate
			System.out.print("Press e to eliminate somebody: ");
			a = i.nextLine();
			
			//This loop is for when the user doesn't enter "e"
			if(!(a.equalsIgnoreCase("e")))
				do {
					
					System.out.print("Enter the letter e!");
					a = i.nextLine();
					
				}while(!(a.equalsIgnoreCase("e")));
			//End loop
			
			
			//This other do/while is for setting the randoized element to null
			//This is so that we can avoid repeated elements from showing up more than once
			//As a result, the index is randomized until the corresponding element isn't null
			do {
				
				index = r.nextInt(10);
				
			}while(!(U7[index] != null));
			//End loop
			
			//These couple of lines state which element in the array was picked
			//Then, their value is set to null after in order to allow the user to know.
			System.out.println("\nIt looks like " + U7[index] + " has been eliminated!");
			U7[index] = null;
			
			count++; //Increases the count variable as there can only be 9 eliminated.
			
		}while(count < 9);
		//End main do/while loop.
		
		//This next area will determine which element in the array isn't null and return the value to the "MVP variable
		
		if(!(U7[index] != null))
		//I'm using a randomizer as only the computer knows the value of index is. Using index++ would require more code to prevent an out of bounds error 
		do {
			
			index = r.nextInt(10);
			
		}while(!(U7[index] != null));
		//End do/while
		
		winner = U7[index];
		
		return winner;
	}

}
