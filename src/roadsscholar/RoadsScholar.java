/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadsscholar;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author Jeremy Tiberg and Nathan Herr
 * 11/28/2017
 */
public class RoadsScholar {


    public static void main(String[] args) {
        try{
            File in = new File("C:\\Users\\Master\\Documents\\NetBeansProjects\\RoadsScholar\\src\\roadsscholar\\problemFile.txt");
            Scanner inFile = new Scanner(in);
            int numOfIntersections = inFile.nextInt();
            int numOfRoads = inFile.nextInt();
            int numOfCities = inFile.nextInt();
            double roadGraph[][] = new double [numOfIntersections][numOfIntersections];
            for(int i = 0; i < numOfIntersections; i++) { // pre fill to infinity
                Arrays.fill(roadGraph[i], Double.MAX_VALUE);
                roadGraph[i][i] = 0.0;
            }
            for(int i = 0; i < numOfRoads; i++){
                int from = inFile.nextInt();
                int to = inFile.nextInt();
                roadGraph[from][to] = inFile.nextDouble();
                roadGraph[to][from] = roadGraph[from][to];
            }
            
            Intersection intersections[] = new Intersection[numOfIntersections];
            Intersection cities[] = new Intersection[numOfCities];
            for(int i = 0; i < numOfIntersections; i++) {
                intersections[i] = new Intersection(numOfIntersections);
            }
            for(int i = 0; i < numOfCities; i++) {
                int intersectionNumber = inFile.nextInt();
                cities[i] = intersections[intersectionNumber];
                cities[i].cityName = inFile.next();
            }
            int numberOfSigns = inFile.nextInt();
            for(int k = 0; k < numOfIntersections; k++){
                for(int u = 0; u < numOfIntersections; u++){
                    for(int v = 0; v < numOfIntersections; v++){
                        if(roadGraph[u][k] + roadGraph[k][v] < roadGraph[u][v]){
                            roadGraph[u][v] = roadGraph[u][k] + roadGraph[k][v];
                            intersections[v].previous[u] = intersections[k];
                        }
                    }
                }
            }
            System.out.println("We win");
        }
        catch(Exception ex){
            System.out.println("hey your wrong");
        }
    }
    
}
