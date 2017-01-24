import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class LacrosseGame
	{	
		static boolean wantsToPlay= true;
		static int uMakes;
		static int uMisses;
		static int cMakes;
		static int cMisses;
		static ArrayList <Players> computerTeam=  new ArrayList<Players>(); 
		static ArrayList <Players> userTeam =  new ArrayList<Players>();
		static Scanner userInput = new Scanner(System.in);
		static ArrayList <Players> teamates = new ArrayList<Players>();
		
		public static void main(String[] args)
			{
				while (wantsToPlay)
					{
				createPlayers();
				printPlayers();
				pickTeams();
				userTeamShoots();
				computerTeamShoots();
				printScore();
					}
			}
		
		public static void createPlayers()
			{
				teamates.clear();
				teamates.add (new Players ("Liam ", 26 , 12, "Green "));
				teamates.add (new Players ("Nick ", 32 , 3, "Brown "));
				teamates.add (new Players ("James ", 19, 55, "Red "));
				teamates.add (new Players ("John ", 44 , 81, "Yellow"));
				teamates.add (new Players ("Smith ", 38 , 15, "White "));
				teamates.add (new Players ("Ben", 51, 2, "Maroon"));
				teamates.add (new Players ("Sam", 21, 99, "Black"));
				teamates.add (new Players ("Will", 33, 17, "Orange"));
				teamates.add (new Players ("Rob", 42, 10, "White"));
				teamates.add (new Players ("Sean", 13, 40, "Gold"));

				System.out.println("Several players have been preset.");
				System.out.println("If you would like to create your own player type add");
				System.out.println("If you want to continue with the preset players type no");
				
				String newPlayer = userInput.nextLine().toLowerCase();
				if (newPlayer.equals("add"))
					{
						System.out.println("What would you like to name your character?");
						String newName = userInput.nextLine();
						System.out.println("What shoooting Percentage would you want your player to have?");
						int newPercentage = userInput.nextInt();
						System.out.println("What number will your player have?");
						int newNumber = userInput.nextInt();
						System.out.println("What color is the player's jersey?");
						Scanner userInput2 = new Scanner(System.in);
						String newColor = userInput2.nextLine();
						teamates.add (new Players (newName, newPercentage, newNumber, newColor));
					}
				else if (newPlayer.equals("no"))
					{ 
						System.out.println("Ok let us play the game with the standard players.");
						System.out.println();
					}
			}
		
		public static void printPlayers()
			{	
				System.out.println("Name:       " + "Shooting Percentage:  " + " Player's Number:      "
			+"Jersey Color:");
				System.out.println();
				for (int i = 0; i < teamates.size(); i++)
					{
						System.out.printf("%-20s%-20s%-20s%-20s" , i+1+ " " + teamates.get(i).getName() ,
								teamates.get(i).getPercent() , teamates.get(i).getNumber() ,
								teamates.get(i).getColor());
						System.out.println();
					}
			}
		public static void pickTeams()
			{
			System.out.println("Now you can pick your team.");
			System.out.println("Your team will have 4 players");
			for(int i = 0; i < 4 ; i++)
				{
					printPlayers();
					System.out.println("Pick your player by typing in the number on the left of the console" );
					int pickTeam = userInput.nextInt()-1;
					System.out.printf("%-20s%-20s%-20s%-20s" , teamates.get(pickTeam).getName() ,
							teamates.get(pickTeam).getPercent() , teamates.get(pickTeam).getNumber() ,
							teamates.get(pickTeam).getColor());
					System.out.println();
					userTeam.add(teamates.get(pickTeam));
					teamates.remove(pickTeam);
					
				}
			System.out.println("Now type a color for your team's uniforms.");
			Scanner userInput3 = new Scanner(System.in);
			String userTeamColor= userInput3.nextLine();
			for (int i=0 ; i<userTeam.size(); i++)
				{
					userTeam.get(i).setColor(userTeamColor);
				}
			System.out.println();
			System.out.println("This is your team!");
			for (Players p : userTeam)
				{
					System.out.printf("%-20s%-20s%-20s%-20s", p.getName() , p.getPercent() , p.getNumber() , p.getColor());
					System.out.println();
				}
			
			System.out.println();
			System.out.println("The remaining players the computer can chose from are:");
			printPlayers();
			System.out.println();
			System.out.println("The following is the computers team!");
			
			for (int i =0 ; i<4; i++)
				{
					Collections.shuffle(teamates);
					computerTeam.add(teamates.get(0));
					teamates.remove(0);
				}
			
			String [] computerColor = {"Silver", "Black", "Gold", "Bronze", "Magenta", "Navy"};
			int randomColor= (int) (Math.random()*computerColor.length);
			for (int i=0 ; i<computerTeam.size(); i++)
				{				
					computerTeam.get(i).setColor(computerColor[randomColor]);	
				}
			for (Players p : computerTeam)
				{
					System.out.printf("%-20s%-20s%-20s%-20s", p.getName() , p.getPercent() , p.getNumber() , p.getColor());
					System.out.println();
					
				}
			System.out.println();
			}
		public static void userTeamShoots()
			{
				System.out.println("Your team's shots:");
				uMakes=0;
				uMisses=0;
				for (int r = 0; r<2; r++)
					{
						for (int i = 0; i<userTeam.size(); i++)
							{
								
								int randomNumber= (int) (Math.random()*100)+1;
							
								if (randomNumber >= userTeam.get(i).getPercent())
									{
										System.out.println("Miss");
										uMisses++;
									}
								else 
									{
										System.out.println("Goal!");
										uMakes++;
									}
							}
					}
			System.out.println();
			}
		
		public static void computerTeamShoots()
			{
				System.out.println("My teams's shots:");
				cMakes=0;
				cMisses=0;
				for (int r = 0; r<2; r++)
					{
						for (int i = 0; i<computerTeam.size(); i++)
							{
								int randomNumber= (int) (Math.random()*100)+1;
			
								if (randomNumber >= computerTeam.get(i).getPercent())
									{
										System.out.println("Miss");
										cMisses++;
									}
								else 
									{
										System.out.println("Goal!");
										cMakes++;
									}
							}
					}
				
			}
		public static void printScore()
			{
			System.out.println("Each player has shot twice");
			if (uMakes== 1)
				{
				System.out.println("Your team scored one goal!");
				}
			else
				{
				System.out.println("Your team scored " + uMakes + " goals!");	
				}
			
			if (cMakes== 1)
				{
				System.out.println("My team scored one goal!");
				}
			else
				{
				System.out.println("My team scored " + cMakes + " goals!");	
				}
			
			if (uMakes> cMakes)
				{
					System.out.println("You Have Won The Game!");
				}
			else if (uMakes == cMakes)
				{
					System.out.println("We Have Tied!");
				}
			else
				{
					System.out.println("I WINNNNN!!!!");
				}
			
			System.out.println();
			System.out.println("Would you like to play again? Please type yes or no.");
			Scanner userInput9 = new Scanner(System.in);
			String keepPlaying = userInput9.nextLine();
			if (!keepPlaying.toLowerCase().equals("yes"))
				{
					wantsToPlay = false;
					System.out.println("Thanks for playing!");
				}
			} // new coo=mment
		//comment
	}
