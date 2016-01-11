# NYPDMotorVehicleCollisionsProject

Project Description: 

This java program extracts information about motor vehicle collisions in NYC from files provided by the NYPD. From the gathered data, it prints out interesting information such as: 1) The 3 zipcodes with the largest number of collisions.
2) The 3 zipcodes with the smallest number of collisions. 3) The 3 zip codes with the most injuries and fatalities resulting from vehicle collisions. 4) The 3 most dangerous zipcodes for cyclists. 5) The percentage of collisions involving the following vehicle types: taxi, bus, bicycle, fire truck, ambulance. 6) The street with the most collisions that one should probably avoid. 

Note: The program is not interactive, to run it one must enter the name of the file as the first command line argument. 

This program contains three files: 

1) Collision.java  - This is the class that represents one collision. It holds all the information about one collision such as the date, time, borough, zipcode, latitude, longitude, on street name, cross street name, number of persons injured, number of persons killed, number of pedestrians injured, number of pedestrians killed, number of cyclists injured, number of cyclists killed, number of motorists injured, number of motorists killed, contributing factor vehicle 1, contributing factor vehicle 2, unique key, vehicle type code 1, vehicle type code 2

2) CollisionList.java - This class represents a list of collision objects. This class also contains the methods to compute the results for the six tasks mentioned on the project description. 

3) CollisionInfo.java - This is the runnable java program that contains the main method. This class is responsible for reading the file provided by the user and calling the other classes to compute the results for the six tasks mentioned in the project description. 

Sample file: To run the program, you may use this sample file --> NYPD_Motor_Vehicle_Collisions_Manhattan_2015_August_24.csv 



