package FirstProPackage;


/**
 * @author Jefferson Vivanco
 * Collision Class: This class is used to create a Collision Object. The Collision Object is made up of all the 21 entries found in the file. This class includes
 * 					getters and setter to access these entries or set new ones. This class has three different contructors, this is so we can make different collsions
 * 					according to each task. 
 */
public class Collision implements Comparable<Collision> {
	//THESE ARE THE GLOBAL VARIABLES
	private String date; 
	private String time; 
	private String borough; 
	private String zipCode; //COMPARABLE VARIABLE IN OBJECT
	private String Latitude;
	private String Longitude; 
	private String OnStreetName; 
	private String CrossStreetName; 
	private String NumberOfPersonsInjured; //COMPARABLE VARIABLE IN OBJECT
	private String NumberOfPersonsKilled; //COMPARABLE VARIABLE IN OBJECT
	private String NumberOfPedestriansInjured; //COMPARABLE VARIABLE IN OBJECT
	private String NumberOfPedestriansKilled; //COMPARABLE VARIABLE IN OBJECT
	private String NumberOfCyclistInjured; //COMPARABLE VARIABLE IN OBJECT
	private String NumberOfCyclistKilled;//COMPARABLE VARIABLE IN OBJECT
	private String NumberOfMotoristInjured; //COMPARABLE VARIABLE IN OBJECT
	private String NumberOfMotoristKilled;//COMPARABLE VARIABLE IN OBJECT 
	private String ContributingFactorVehicle1; //COMPARABLE VARIABLE IN OBJECT
	private String ContributingFactorVehicle2; //COMPARABLE VARIABLE IN OBJECT
	private String uniqueKey; 
	private String vehicleTypeCode1; //COMPARABLE VARIABLE IN OBJECT
	private String vehicleTypeCode2; //COMPARABLE VARIABLE IN OBJECT
	private Integer counter=0;
	private Integer counterInjuriesFat=0; 
	private Integer counterCyclistInjuriesFatalities=0; 

	
	public Collision(String zC, String NPI,String NPK, String NPeI, String NPeK, String NCI, String NCK, String NMI, String NMK)//CONSTRUCTOR 1:THIS CONTRUCTOR IS 
	//USED TO CREATE THE ZIPCODE COLLISIONS TO SORT BE ABLE TO SORT BY ZIPCODES
	{
		this.zipCode = zC; 
		this.NumberOfPersonsInjured = NPI; 
		this.NumberOfPersonsKilled = NPK; 
		this.NumberOfPedestriansInjured = NPeI;
		this.NumberOfPedestriansKilled = NPeK; 
		this.NumberOfCyclistInjured = NCI; 
		this.NumberOfCyclistKilled = NCK; 
		this.NumberOfMotoristInjured = NMI;
		this.NumberOfMotoristKilled = NMK; 
		this.counter=1;
		//----------------------------------//
		Integer INPI=0;
		try{
			INPI = Integer.parseInt(NPI);
		}catch (NumberFormatException x){
			INPI = 0; 
		}
		//----------------------------------//
		Integer INPK=0; 
		try{
			INPK=Integer.parseInt(NPK);
		}catch(NumberFormatException x){
			INPK=0;
		}
		//----------------------------------//
		Integer INPeI=0;
		try{
			INPeI=Integer.parseInt(NPeI);
		}catch(NumberFormatException x){
			INPeI=0;
		}
		//----------------------------------//
		Integer INPeK=0; 
		try{
			INPeK = Integer.parseInt(NPeK);
		}catch(NumberFormatException x){
			INPeK=0; 
		}
		//----------------------------------//
		Integer INCI=0; 
		try{
			INCI = Integer.parseInt(NCI); 
		}catch(NumberFormatException x){
			INCI=0; 
		}
		//----------------------------------//
		Integer INCK=0; 
		try{
			INCK=Integer.parseInt(NCK);
		}catch(NumberFormatException x){
			INCK=0; 
		}
		//----------------------------------//
		Integer INMI=0;
		try{
			INMI=Integer.parseInt(NMI);
		}catch(NumberFormatException x){
			INMI=0; 
		}
		//----------------------------------//
		Integer INMK = 0; 
		try{
			INMK=Integer.parseInt(NMK);
		}catch(NumberFormatException x){
			INMK=0; 
		}
		//----------------------------------//
		this.counterInjuriesFat = INPI+INPK+INPeI+INPeK+INCI+INCK+INMI+INMK;
		this.counterCyclistInjuriesFatalities = INCI+INCK; 
	}
	public Collision(String VTC1, String VTC2)
	{
		this.vehicleTypeCode1 = VTC1; 
		this.vehicleTypeCode2=VTC2; 
		
	}
	public Collision(String Date, String OnStreet, String CrossStreet)
	{
		this.date=Date; 
		this.OnStreetName = OnStreet; 
		this.CrossStreetName = CrossStreet; 
	}
	

	/**
	 * This method increments counter. We call it in CollisionList when we are sorting the collisions based on zipcodes. If it finds two similar one, it increments counter
	 */
	public void incCounter()
	{
		this.counter++; 
	}
	/**
	 * @param x is the number that we are going to add on top of the total number of injuries and fatalities 
	 */
	public void addInjuFat(int x)
	{
		this.counterInjuriesFat = this.counterInjuriesFat+x; 
	}
	/**
	 * @param x is the number that we are going to add on top of the total number of cyclist injuries and fatalities 
	 */
	public void addCyInjuFat(int x)
	{
		this.counterCyclistInjuriesFatalities=this.counterCyclistInjuriesFatalities+x;
	}
	
	/**
	 * @return a string, this string is the zip code
	 */
	public String getZipCode()
	{
		return this.zipCode; 
	}
	
	/**
	 * @return a string, the number of persons injured
	 */
	public String getNPI()
	{
		return this.NumberOfPersonsInjured;
	}
	
	/**
	 * @return a string, this is the number of persons killed 
	 */
	public String getNPK()
	{
		return this.NumberOfPersonsKilled; 
	}
	
	/**
	 * @return a string, this is the number of pedestrians injured
	 */
	public String getNPeI()
	{
		return this.NumberOfPedestriansInjured;
	}
	
	/**
	 * @return a string, this the number of pedestrians killed
	 */
	public String getNPeK()
	{
		return this.NumberOfPedestriansKilled;
	}
	
	/**
	 * @return a string, this is the number of cyclists injured 
	 */
	public String getNCI()
	{
		return this.NumberOfCyclistInjured; 
	}
	
	/**
	 * @return a string, this the number of cyclists killed
	 */
	public String getNCK()
	{
		return this.NumberOfCyclistKilled;
	}
	
	/**
	 * @return a string, this the number of motorists injured
	 */
	public String getNMI()
	{
		return this.NumberOfMotoristInjured;
	}
	
	/**
	 * @return a string, this is the numbe of motorists killed 
	 */
	public String getNMK()
	{
		return this.NumberOfMotoristKilled;
	}
	

	/**
	 * @return a string, this string is the VEHICLE TYPE CODE 1
	 */
	public String getVTC1()
	{
		return this.vehicleTypeCode1;
	}
	
	/**
	 * @return a string, this string is the VEHICLE TYPE CODE 2
	 */
	public String getVTC2()
	{
		return this.vehicleTypeCode2;
	}
	
	/**
	 * @return an integer, this integer keeps track of how many repeated collision objects(based on zip code) there are
	 */
	public int getCount()
	{
		return this.counter; 
	}
	/**
	 * @return an integer, this method returns the total number of injuries and fatalities in a collision
	 */
	public int getInjuFat()
	{
		return this.counterInjuriesFat;
	}
	/**
	 * @return an integer, this method returns the total number of cyclist injuries and fatalities in a collision
	 */
	public int getCyInjuFat()
	{
		return this.counterCyclistInjuriesFatalities; 
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Collision other)//WE USE THIS METHOD TO SET HOW COMPARABLE WILL COMPARE COLLISION OBJECTS 
	{
		return this.zipCode.compareTo(other.zipCode);

	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()//A STRING REPRESENTATION OF A COLLISION OBJECT
	{
		return this.zipCode+"  "+this.counter+" collisions"; 
	}
	/**
	 * @return a string, this string is the on street name
	 */
	public String getONS()
	{
		return this.OnStreetName; 
	}
	/**
	 * @return a string, this string is the cross street name 
	 */
	public String getCSN()
	{
		return this.CrossStreetName; 
	}

}
