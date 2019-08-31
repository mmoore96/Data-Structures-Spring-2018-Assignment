# Data-Structures-Spring-2018-Assignment
Program that will allow the user, using the map shown above to find routes between two stations. The program should ask for the user to type the name of the two stations and it should find return the sequence of stations to traverse
Programming Assignment # 1
For this problem, you can use the classes from the Java API. No need to create your own lists, stacks or queues. You may choose to implement your solution by using arrays.
The subway is one of the most utilized transportation systems in big cities. This system is made of a set of routes, and each route by a sequence of stations.
1.	Implement a class called Station that contains information about a particular station. This class should allow to set at least the name of the station. Each station is unique within the subway system.
2.	Implement a class called Route that stores information about a particular route. This Route class should allow to add stations/remove stations from the route.  A route has a name.
3.	Implement a class called Subway. This Subway class should allow to add and delete Route objects.
4.	Implement the following subway system in your application. (see instructions)


 


5.	Now, develop a method in the Subway class that given two stations passed as parameters that belongs to a Subway object, it returns a list of stations that the user will traverse to go from one station to the other. Assume that there are no loops in the system. The method signature is as follows:
public List<Station> getRouteBetweenStations(Station a, Station b)
For example, using a Subway object that implements the subway map above, if a user executes getRoute from station 30 to station Gu, the getRouteBetweenStations should print the following list:
30, R, Marsella, MU, SENA Santiago, GU
6.	Create the program that will allow the user, using the map shown above to find routes between two stations. The program should ask for the user to type the name of the two stations and it should find return the sequence of stations to traverse.
