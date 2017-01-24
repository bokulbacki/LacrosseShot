import java.util.ArrayList;
import java.util.Scanner;
public class LacrosseShot
	{
			static int randomNumber;
			static int input;
			static int [] shotPercentage = {18, 42, 22, 8, 33, 12, 16, 26, 55};
			static ArrayList <Players> teamates = new ArrayList<Players>();
		public static void main(String[] args)
			{
				choosePercent ();
				checkGoal ();
			}
		
		public static void choosePercent ()
			{
				Scanner userInput = new Scanner(System.in);
				
				System.out.println("Choose a number between 1 and 9");
				input = userInput.nextInt();
				System.out.println("The percentage you chose was " + shotPercentage[input-1]);
				
			}
		
		public static void checkGoal ()
			{
				for (int i = 0; i<5; i++)
						{
								randomNumber= (int) (Math.random()*100)+1;
					
							if (randomNumber >= shotPercentage[input -1])
								{
								System.out.println("The player did not make his shot.");
								}
							else 
								{
									System.out.println("The player made his shot.");
								}
						}
			}	
				
			
// comment
	}
