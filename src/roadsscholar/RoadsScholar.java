/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadsscholar;

import java.io.File;
import java.util.Scanner;
/**
 *
 * @author Jeremy Tiberg and Nathan Herr
 * 11/28/2017
 */
public class RoadsScholar {


    public static void main(String[] args) {
        try{
            File in = new File("Fill this in later");
            Scanner inFile = new Scanner(in);
            int numOfIntersections = inFile.nextInt();
            int numOfRoads = inFile.nextInt();
            int numOfCities = inFile.nextInt();
            double roadGraph[][] = new double [numOfIntersections][numOfIntersections];
            for(int i = 0; i < numOfRoads; i++){
                int from = inFile.nextInt();
                int to = inFile.nextInt();
                roadGraph[from][to] = inFile.nextDouble();
                roadGraph[to][from] = roadGraph[from][to];
            }
            Intersection intersections[] = new Intersection[numOfIntersections];
            for(int k = 0; k < numOfRoads; k++){
                for(int u = 0; u < numOfRoads; u++){
                    for(int v = 0; v < numOfRoads; v++){
                        if(roadGraph[u][k] + roadGraph[k][v] < roadGraph[u][v]){
                            roadGraph[u][v] = roadGraph[u][k] + roadGraph[k][v];
                            intersections[v].previous = intersections[k];
                        }
                    }
                }
            }
        }
        catch(Exception ex){
            
        }
    }
    
}
