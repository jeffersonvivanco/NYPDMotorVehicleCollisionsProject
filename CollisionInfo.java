package FirstProPackage;

import java.util.*; 
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;

/**
 * @author Jefferson Vivanco
 * CollisionInfo Class: This class is in charge of running the entire program. Here, we read the input file and create an output file. This class also has the split
 * 						method which parses each line of the input file. From this class, we create all the CollisionList and Collision objects as well as calling 
 * 						the methods from the collisionlist object to perform the 5 tasks. 
 *
 */
public class CollisionInfo {

	/**
	 * @param args is the array that holds the command line arguments. We use args[0] to get the user input.
	 * @throws FileNotFoundException throws the 
	 */
	public static void main(String[] args) throws FileNotFoundException 
	{
		CollisionInfo main = new CollisionInfo();//We create an instance of the CollisionInfo class so we can its not static split method 
		//-------------------------------------//CHECKING COMMAND LINE ARGUMENTS
		if(args.length!=1){
			System.err.printf("Please make sure you entered one argument." );
			System.exit(1);
		}
		
		//------------------------------------//CREATING FILE & CHECKING IF FILE EXISTS AND READABLE 
		
		//Creating File object using first argument  
		File userFile = new File(args[0]); 
		
		if (!userFile.exists() || !userFile.canRead() )
		{
			System.err.printf("ERROR: cannot read file %s.\n\n", args[0]);
			System.exit(1);
		}
		//------------------------------------//GETTING INFO FROM USERFILE 
		
		Scanner readFile = new Scanner ( userFile );//SETTING UP SCANNER TO READ FILES 
		
		
		CollisionList NumberOfCollisionsByZp = new CollisionList();//This list stores the collision objects which will be sorted based on zip code and used for tasks 1-4
		CollisionList InvolvingVecType=new CollisionList(); //This list stores the collision objects that take in vehicle type code 1 and 2 as its paramters
		CollisionList NumberOfCollisionsByONSCRS = new CollisionList();//This list stores the collision objects that take in the date, OnStreetName, and CrossStreetName as its parameters

		
		while(readFile.hasNext())//THIS LOOPS READS THE DOCUMENT 
		{
			String line = readFile.nextLine(); //Reading the next line 
			ArrayList<String> collisionLine  = main.split(line);//Splitting each line of the file 
			
			if(collisionLine.size()==21)//Checks if the line has 21 entries, if it doesn't, it skips it and goes to the next line
			{
				String d = collisionLine.get(0);
				String t = collisionLine.get(1);
				String b = collisionLine.get(2);
				String zP = collisionLine.get(3); 
				String la = collisionLine.get(4);
				String lo = collisionLine.get(5); 
				String OSN = collisionLine.get(6);
				String CSN = collisionLine.get(7); 
				String NPI = collisionLine.get(8); 
				String NPK = collisionLine.get(9); 
				String NPeI = collisionLine.get(10);
				String NPeK = collisionLine.get(11); 
				String NCI = collisionLine.get(12);
				String NCK = collisionLine.get(13); 
				String NMI = collisionLine.get(14);
				String NMK = collisionLine.get(15);
				String CFV1 = collisionLine.get(16);
				String CFV2 = collisionLine.get(17);
				String uK = collisionLine.get(18);
				String VTC1 = collisionLine.get(19);
				String VTC2 = collisionLine.get(20);
				
				Collision newZpC = new Collision(zP,NPI,NPK,NPeI,NPeK,NCI,NCK,NMI,NMK);//Creating a collision to be sorted by zip codes 
				Collision newIVType = new Collision(VTC1,VTC2); //Creating a collision using only VTC1 and VTC2 as parameters 
				Collision newOnCrType = new Collision(d, OSN, CSN);//Creating a collision using date, OnStreetName, and CrossStreetName
				//Adding elements to the collision lists
				NumberOfCollisionsByZp.addCollision(newZpC);
				InvolvingVecType.addCollision(newIVType);
				NumberOfCollisionsByONSCRS.addCollision(newOnCrType);

			}
	
			
		}

		NumberOfCollisionsByZp.sortZipCode();//This method sorts the collisionlist of zip code based collision objects.d 
		readFile.close();
		


		//------------------------------------//EDITING FILE NAME TO CREATE OUTPUT FILE NAME 
		String FileName = args[0]; //Stores the file name in a string 
		String FileOutName="";
		if(FileName.endsWith(".csv"))
		{
			FileOutName =FileName.substring(0, FileName.length()-4);
			FileOutName = FileOutName+".out"; 
		}
		else{
			FileOutName = FileName+".out"; 
		}
		
		//------------------------------------//WRITING OUTPUT FILE, PRINTING TO THE OUTPUT FILE THE RESULTS OF OUR ANALYSIS(RESULTS OF ALL THE TASKS)
		File outputFile = new File(FileOutName); 
		PrintWriter output = new PrintWriter(outputFile);
		output.print("Hi, This a NYPD Motor Vehicle Collisions Analysis based on the file "+FileName+".\n\n\n");

		
		output.print("Task 1: Top 3 zip codes with the largest number of collisions\n");
		output.println(NumberOfCollisionsByZp.ZPMostCo()+"\n");
		output.print("Task 2: Top 3 zip codes with the smallest number of collisions\n");
		output.println(NumberOfCollisionsByZp.ZPLeastCo()+"\n"); 
		output.print("Task 3: Top 3 zip codes with the most injuries and fatalities from collisions\n"); 
			CollisionList zipMostFat = NumberOfCollisionsByZp.ZPMostIF();
			for(int i=0; i<zipMostFat.sizeOfList(); i++)
			{
				output.println(zipMostFat.getCollision(i).getZipCode()+"  "+zipMostFat.getCollision(i).getInjuFat()+" injuries and fatalities"); 
			}
		output.print("\n\nTask 4: Top 3 zip codes that are the most dangerous for cyclists\n");
			CollisionList zipMostCYFat = NumberOfCollisionsByZp.ZPMostCY(); 
			for(int i=0; i<zipMostCYFat.sizeOfList(); i++)
			{
				output.println(zipMostCYFat.getCollision(i).getZipCode()+"  "+zipMostCYFat.getCollision(i).getCyInjuFat()+" cyclists hurt"); 
			}
		output.print("\n\nTask 5: Percentage of collisions involving the following vehicle types:\n\n");
		output.println("taxi        "+InvolvingVecType.getPerTaxi()+"%");
		output.println("bus         "+InvolvingVecType.getPerBus()+"%");
		output.println("bicycle     "+InvolvingVecType.getPerBike()+"%"); 
		output.println("fire truck  "+InvolvingVecType.getPerFireTruck()+"%"); 
		output.println("ambulance   "+InvolvingVecType.getPerAmbu()+"%\n");
		output.print("\n\nTask 6: The street with the most collisions that you should probably avoid is...\n"+NumberOfCollisionsByONSCRS.streetMostCollisions()+"\n\n\n"); 
		output.close();
		//------------------------------------//
	}
	/**
	 * @param textLine is a string, this parameter is the line we pass for it to be parse
	 * @return an ArrayList of string, this method returns an arrayList of the 21 entries of the line we passed 
	 * Note: @author Joanna Klukowska
	 */
	public ArrayList<String> split (String textLine ) {
		ArrayList<String> entries = new ArrayList<String>();
		int lineLength = textLine.length();
		StringBuffer nextWord = new StringBuffer(); 
		char nextChar;
		boolean insideQuotes = false;
		
		for(int i = 0; i < lineLength; i++ ) {
			nextChar = textLine.charAt(i); 
			//add character to the current entry 
			if ( nextChar != ',' && nextChar != '"' ) {
				nextWord.append( nextChar );
			}
			//double quote found, decide if it is opening or closing one
			else if (nextChar == '"' ) {
				if ( insideQuotes ) {
					insideQuotes = false;
				}
				else {
					insideQuotes = true;
				}
			}
			//found comma inside double quotes, just add it to the string
			else if (nextChar == ',' && insideQuotes) {
				nextWord.append( nextChar );
			}
			//end of the current entry reached, add it to the list of entries
			//and reset the nextWord to empty string
			else if (nextChar == ',' && !insideQuotes) {
				//trim the white space before adding to the list
				entries.add( nextWord.toString().trim() );
				
				nextWord = new StringBuffer();
			}
			
			else {
				System.err.println("This should never be printed.\n");
			}
		}
		//add the last word
		//trim the white space before adding to the list
		entries.add( nextWord.toString().trim() );
				
		return entries; 
	}
	
	
	
}
