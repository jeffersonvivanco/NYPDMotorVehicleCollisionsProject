package FirstProPackage;
import java.util.*;


/**
 * @author Jefferson Vivanco
 * CollisionList Class: This class is used to create a CollisionList object. This object holds an arraylist of collision objects. This class has getters such as 
 * 						the (get(element)) method and setters such as (add(Collision)) but in addition to this, this class is in charge of making all the calculations
 * 						for each of the tasks. 
 */
public class CollisionList {

	ArrayList<Collision> ListOfCollisions = new ArrayList<>(); //This arraylist holds all the collision objects 
	
	/**
	 * //default constructor 
	 */
	public CollisionList()
	{
		//default constructor 
	}
	/**
	 * This method adds a collision object to the array list of collisions 
	 * @param x is a Collision object. This object is added to the ArrayList ListOfCollisions
	 */
	public void addCollision(Collision x)
	{
		ListOfCollisions.add(x); 
	}
	
	/**
	 * @return the size of the ArrayList ListOfCollisions 
	 */
	public int sizeOfList()
	{
		return ListOfCollisions.size(); 
	}
	
	/**
	 * This method returns a Collision object 
	 * @param x is the specified location in the ArrayList ListOfCollisions of the element we want 
	 * @return a Collision object
	 */
	public Collision getCollision(int x)
	{
		return ListOfCollisions.get(x); 
	}
	
	/**
	 * This method removes an element from the list 
	 * @param x is the specified location in the ArrayList ListCollisions of the element we want removed 
	 */
	public void removeFromList(int x)
	{
		this.ListOfCollisions.remove(x); 
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override 
	public String toString()
	{
		String printCL="";
		for(int i=0; i<this.ListOfCollisions.size(); i++)
		{
			printCL = printCL+ListOfCollisions.get(i)+"\n";
		}
		return printCL;
	}
	
	/**
	 * THIS METHOD SORTS THE COLLISIONS BY ZIP CODES. THEN IT GATHERS THE EQUAL ZIPCODES AND GETS THE NUMBER OF TIMES THAT ZIPCODE OCCURS 
	 */
	public void sortZipCode()
	{
		this.ListOfCollisions.remove(0); //Removes the first element that explains what each column is 
		Collections.sort(this.ListOfCollisions);
		for(int i=ListOfCollisions.size()-1; i>0; i--)
		{
			if(ListOfCollisions.get(i).getZipCode().equals(ListOfCollisions.get(i-1).getZipCode()))
			{
				ListOfCollisions.get(i).incCounter();
				ListOfCollisions.get(i).addInjuFat(ListOfCollisions.get(i-1).getInjuFat());//Adds the injuries and fatalities of both zip codes
				ListOfCollisions.get(i).addCyInjuFat(ListOfCollisions.get(i-1).getCyInjuFat());//Adds the injuries and fatalities of cyclists of both zip codes
				ListOfCollisions.remove(i-1); 
				
			}
		}

	}
	

	/**
	 * THIS METHOD GETS THE ZIPCODES WITH THE MOST COLLISIONS 
	 * @return a CollisionList of the zip codes with the most collisions
	 */
	public CollisionList ZPMostCo()
	{
		ArrayList<Collision> list2 = new ArrayList<>(this.ListOfCollisions); //This method makes a copy of the original collision list 
		Collision ZPmc = ListOfCollisions.get(0); //Dummy variable to store collision
		CollisionList ZPListmc = new CollisionList(); //List to be return with the zipcodes with the most collisions 
		int x=0; 
		while(x<3)//To get top 3
		{
			int StorageOfMax=0;
			int max=0;
			for(int i=0; i<list2.size(); i++)
			{
				
				if(list2.get(i).getCount()>max)
				{
					max = list2.get(i).getCount(); 
					ZPmc=list2.get(i); 
					StorageOfMax=i;
				}
			}
			
			ZPListmc.addCollision(ZPmc);
			list2.remove(StorageOfMax);
			for(int i=list2.size()-1; i>0; i--)//This for loop finds a tie
			{
				if(list2.get(i).getCount()==max)
				{
					ZPListmc.addCollision(list2.get(i));
					list2.remove(i);
				}
			}

			x++; 
		}	
		return ZPListmc;
	}
	
	/**
	 * THIS METHOD GETS THE ZIPCODES WITH THE LEAST COLLISIONS
	 * @returna a CollisionList of the zip codes with the least collisions
	 */
	public CollisionList ZPLeastCo()
	{
		ArrayList<Collision> list1 = new ArrayList<>(this.ListOfCollisions); //This method makes a copy of the original collision list 
		Collision ZPlc=null;//Dummy variable to store collision
		CollisionList ZPListlc = new CollisionList(); //List to be return with the zipcodes with the least collisions 
		int x=0; 
		while(x<3)//To get least 3
		{
			int StorageOfLeast=0; 
			int min= 100000000; 
			
			for(int i=0; i<list1.size();i++)
			{
				if(list1.get(i).getCount()<min)
				{
					min = list1.get(i).getCount(); 
					ZPlc = list1.get(i); 
					StorageOfLeast = i; 
				}

			}
			ZPListlc.addCollision(ZPlc);
			list1.remove(StorageOfLeast);
			for(int i=list1.size()-1; i>0;i--)//Finds for loop finds a tie
			{
				if(list1.get(i).getCount()==min)
				{
					ZPListlc.addCollision(list1.get(i));
					list1.remove(i);
				}
					
			}
			x++; 
		}
		return ZPListlc; 
	}

	/**
	 * THIS METHOD GET THE TOP THREE ZIP CODES WITH THE MOST INJURIES AND FATALITIES 
	 * @return a CollisionList of zip codes with the most injuries and fatalities
	 */
	public CollisionList ZPMostIF()
	{
		ArrayList<Collision> list3 = new ArrayList<>(this.ListOfCollisions); //This method makes a copy of the original collision list 
		Collision ZPif = ListOfCollisions.get(0); //Dummy variable to store collision
		CollisionList ZPListIF = new CollisionList(); //List to be return with the zipcodes with the most collisions 
		int x=0; 
		
		while(x<3)//To get top 3
		{
			int StorageOfMax=0;
			int max=list3.get(0).getInjuFat();
			for(int i=0; i<list3.size(); i++)
			{
				
				if(list3.get(i).getInjuFat()>=max)
				{
					max = list3.get(i).getInjuFat(); 
					ZPif=list3.get(i); 
					StorageOfMax=i;
				}
			}
			
			ZPListIF.addCollision(ZPif);
			list3.remove(StorageOfMax);
			for(int i=list3.size()-1; i>0; i--)//This for loop looks for a tie
			{
				if(list3.get(i).getInjuFat()==max)
				{
					ZPListIF.addCollision(list3.get(i));
					list3.remove(i);
				}
			}
			
			
			
			x++; 
		}	
		return ZPListIF;
		
	}
	/**
	 * THIS METHOD GETS THE TOP THREE ZIPCODES WITH THE MOST INJURIES AND FATALITIES FROM CYCLISTS 
	 * @return a CollisionList of zip codes with the most cyclist injuries and fatalities
	 */
	public CollisionList ZPMostCY()
	{
		ArrayList<Collision> list4 = new ArrayList<>(this.ListOfCollisions); //This method makes a copy of the original collision list 
		Collision ZPCY = ListOfCollisions.get(0); //Dummy variable to store collision
		CollisionList ZPListCY = new CollisionList(); //List to be return with the zipcodes with the most collisions 
		int x=0; 
		
		while(x<3)//Top 3 
		{
			int StorageOfMax=0;
			int max=list4.get(0).getCyInjuFat();
			for(int i=0; i<list4.size(); i++)
			{
				
				if(list4.get(i).getCyInjuFat()>=max)
				{
					max = list4.get(i).getCyInjuFat(); 
					ZPCY=list4.get(i); 
					StorageOfMax=i;
				}
			}
			
			ZPListCY.addCollision(ZPCY);
			list4.remove(StorageOfMax);
			for(int i=list4.size()-1; i>0; i--)//This for loop looks for ties 
			{
				if(list4.get(i).getCyInjuFat()==max)
				{
					ZPListCY.addCollision(list4.get(i));
					list4.remove(i);
				}
			}

			x++; 
		}	
		return ZPListCY;

	}
	/**
	 * THIS METHOD GETS THE PERCENT OF TAXIS INVOLVED IN COLLISIONS
	 * @return a double variable, this double variable is the percent of taxis involved in collisions
	 */
	public double getPerTaxi()
	{
		double counterTaxi=0;
		ArrayList<Collision> list5 = new ArrayList<>(this.ListOfCollisions); 
		for(int i=0; i<list5.size(); i++)
		{
			if((list5.get(i).getVTC1().equalsIgnoreCase("taxi"))&&(list5.get(i).getVTC2().equalsIgnoreCase("taxi")))
				counterTaxi++;
			else{
				if(list5.get(i).getVTC1().equalsIgnoreCase("taxi"))
					counterTaxi++; 
				if(list5.get(i).getVTC2().equalsIgnoreCase("taxi"))
					counterTaxi++;
			}

		}
		double totalNumCol = list5.size()-1; 
		double percent = (counterTaxi/totalNumCol)*100; 
		return Math.round(percent*100)/100.0; 
		 
	}
	/**
	 * THIS METHOD GETS THE PERCENT OF BUSES INVOLVED IN COLLISIONS
	 * @return a double variable, this double variable is the percent of buses involved in collisions
	 */
	public double getPerBus()
	{
		double counterBus=0; 
		ArrayList<Collision> list6 = new ArrayList<>(this.ListOfCollisions); 
		for(int i=0; i<list6.size();i++)
		{
			if((list6.get(i).getVTC1().equalsIgnoreCase("bus"))&&(list6.get(i).getVTC2().equalsIgnoreCase("bus")))
				counterBus++;
			else{
				if(list6.get(i).getVTC1().equalsIgnoreCase("bus"))
					counterBus++; 
				if(list6.get(i).getVTC2().equalsIgnoreCase("bus"))
					counterBus++; 
			}

		}
		double totalNumCol= list6.size()-1; 
		double percent = (counterBus/totalNumCol)*100; 
		return Math.round(percent*100)/100.0; 

	}
	/**
	 * THIS METHOD GETS THE PERCENT OF BICYCLES INVOLVED IN COLLISIONS
	 * @return a double variable, this double variable is the percent of bicycles involved in collisions 
	 */
	public double getPerBike()
	{
		double counterBike=0; 
		ArrayList<Collision> list7 = new ArrayList<>(this.ListOfCollisions); 
		for(int i=0; i<list7.size(); i++)
		{
			if((list7.get(i).getVTC1().equalsIgnoreCase("bicycle"))&&(list7.get(i).getVTC2().equalsIgnoreCase("bicycle")))
				counterBike++;
			else{
				if(list7.get(i).getVTC1().equalsIgnoreCase("bicycle"))
					counterBike++; 
				if(list7.get(i).getVTC2().equalsIgnoreCase("bicycle"))
					counterBike++; 
			}

		}
		double totalNumCol = list7.size()-1; 
		double percent = (counterBike/totalNumCol)*100; 
		double percentRounded = Math.round(percent*100)/100.0; 
		return percentRounded; 
	}
	
	/**
	 * THIS METHOD GETS THE PERCENT OF FIRE TRUCKS INVOLVED IN COLLISIONS
	 * @return a double variable, this double variable is the percent of fire trucks involved in collisions 
	 */
	public double getPerFireTruck()
	{
		double counterFire=0; 
		ArrayList<Collision> list8 = new ArrayList<>(this.ListOfCollisions); 
		for(int i=0; i<list8.size(); i++)
		{
			if((list8.get(i).getVTC1().equalsIgnoreCase("fire truck"))&&(list8.get(i).getVTC2().equalsIgnoreCase("fire truck")))
				counterFire++;
			else{
				if(list8.get(i).getVTC1().equalsIgnoreCase("fire truck"))
					counterFire++; 
				if(list8.get(i).getVTC2().equalsIgnoreCase("fire truck"))
					counterFire++; 
				
			}

		}
		double totalNumCol = list8.size()-1; 
		double percent = (counterFire/totalNumCol)*100; 
		return Math.round(percent*100)/100.0; 
	}
	
	/**
	 * THIS METHOD GETS THE PERCENT OF AMBULANCES INVOLVED IN COLLISIONS
	 * @return a double variable, this double variable is the percent of ambulances involved in collisions 
	 */
	public double getPerAmbu()
	{
		double counterAm=0; 
		ArrayList<Collision> list9 = new ArrayList<>(this.ListOfCollisions); 
		for(int i=0; i<list9.size(); i++)
		{
			if((list9.get(i).getVTC1().equalsIgnoreCase("ambulance"))&&(list9.get(i).getVTC2().equalsIgnoreCase("ambulance")))
				counterAm++; 
			else{
				if(list9.get(i).getVTC1().equalsIgnoreCase("ambulance"))
					counterAm++; 
				if(list9.get(i).getVTC2().equalsIgnoreCase("ambulance"))
					counterAm++; 
			}

		}
		double totalNumCol = list9.size()-1; 
		double percent = (counterAm/totalNumCol)*100; 
		return Math.round(percent*100)/100.0; 
	}

	/**
	 * THIS METHOD GETS THE STREET NAME WITH THE MOST COLLISIONS, IT COUNTS BOTH CROSS STREETS AND ON STREETS
	 * @return a string, this string is the string with the most collisions 
	 */
	public String streetMostCollisions()
	{
		ArrayList<Collision> list10 = new ArrayList<>(this.ListOfCollisions); 
		ArrayList<String> streetNames = new ArrayList<>(); 
		for(int i=0; i<list10.size(); i++)
		{
			streetNames.add(list10.get(i).getONS()); 
			streetNames.add(list10.get(i).getCSN()); 
			
		}
		Collections.sort(streetNames);
		int count=1; 
		int maxCount=0;
		String mostStName=""; 
		for(int i=0; i<streetNames.size()-1; i++)
		{
			if(streetNames.get(i).equalsIgnoreCase(streetNames.get(i+1)))
				count++; 
			if(!streetNames.get(i).equalsIgnoreCase(streetNames.get(i+1)))
			{
				if(count>maxCount)
				{
					maxCount=count; 
					mostStName = streetNames.get(i); 
					count=1; 
					
				}
				else
				{
					count=1; 
				}
			}
		}
		return mostStName+"  "+" with "+maxCount+" collisions"; 
	}
	
	
}
