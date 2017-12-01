/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadsscholar;

import java.io.File;
import java.util.*;
/**
 *
 * @author Jeremy Tiberg and Nathan Herr
 * 11/28/2017
 */
public class RoadsScholar {


    public static void main(String[] args) {
        try{
            File in = new File("D:\\Drive\\Java\\RoadsScholar\\src\\roadsscholar\\problemFile.txt");
            Scanner inFile = new Scanner(in);
            int numOfIntersections = inFile.nextInt();
            int numOfRoads = inFile.nextInt();
            int numOfCities = inFile.nextInt();
            //initialize the distance array and path array
            double roadGraph[][] = new double [numOfIntersections][numOfIntersections];
            int path[][] = new int [numOfIntersections][numOfIntersections];
            //fill the road graph with "infinity"
            for(int i = 0; i < numOfIntersections; i++) { // pre fill to infinity
                Arrays.fill(roadGraph[i], Double.MAX_VALUE);
                roadGraph[i][i] = 0.0;
            }
            //set up the roads that are directly adjacent to each other
            for(int i = 0; i < numOfRoads; i++){
                int from = inFile.nextInt();
                int to = inFile.nextInt();
                roadGraph[from][to] = inFile.nextDouble();
                roadGraph[to][from] = roadGraph[from][to];
                path[from][to] = to;
                path[to][from] = from;
            }
            //initialize the intersections and make an array of cities
            Intersection intersections[] = new Intersection[numOfIntersections];
            Intersection cities[] = new Intersection[numOfCities];
            for(int i = 0; i < numOfIntersections; i++) {
                intersections[i] = new Intersection(numOfIntersections);
                intersections[i].intersectionNum = i;
            }
            for(int i = 0; i < numOfCities; i++) {
                int intersectionNumber = inFile.nextInt();
                cities[i] = intersections[intersectionNumber];
                cities[i].cityName = inFile.next();
            }
            int numOfSigns = inFile.nextInt();
            // calculate the distances
            for(int k = 0; k < numOfIntersections; k++){
                for(int u = 0; u < numOfIntersections; u++){
                    for(int v = 0; v < numOfIntersections; v++){
                        if(roadGraph[u][k] + roadGraph[k][v] < roadGraph[u][v]){
                            roadGraph[u][v] = roadGraph[u][k] + roadGraph[k][v];
                            path[u][v] = path[u][k];
                        }
                    }
                }
            }
            
            /* For each desired sign, read in the details of where the sign
            should be. Then, check each city to see if the path to that city
            from sign goes through the path the sign is on. If it does,
            enter the distance from the first position to the city - the
            distance the sign is away from that position to the sign entry.
            Sort the array list of sign entries in the proper order, then print.
            */
            Intersection temp;
            for(int i = 0; i < numOfSigns; i++){
                int firstIntersection = inFile.nextInt();
                int secondIntersection = inFile.nextInt();
                double distanceFromFirst = inFile.nextDouble();
                ArrayList <RoadSignEntry> sign = new ArrayList <RoadSignEntry>();
                
                for(int j = 0; j < numOfCities; j++){
                    temp = cities[j];
                    while(temp.intersectionNum != firstIntersection){
                       if(temp.intersectionNum == secondIntersection){
                          RoadSignEntry entry = new RoadSignEntry();
                          entry.cityName = cities[j].cityName;
                          entry.distance = (int) Math.round(
                                  (roadGraph[firstIntersection]
                                          [cities[j].intersectionNum] - 
                                          distanceFromFirst));
                          sign.add(entry);
                       }
                       temp = intersections[path[temp.intersectionNum][firstIntersection]];
                    }
                }
                sign.sort(new RoadSignEntry());
                for(RoadSignEntry sortedEntry : sign){
                    System.out.println(sortedEntry.cityName + " " + 
                            sortedEntry.distance);
                }
                System.out.println();
            }
        }
        catch(Exception ex){
            System.out.println("hey your wrong");
        }
    }
    
}
