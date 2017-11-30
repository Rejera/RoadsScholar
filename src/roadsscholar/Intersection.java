/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadsscholar;

/**
 *
 * @author Jeremy Tiberg and Nathan Herr
 */
public class Intersection {
    public String cityName;
    public Intersection previous[];
    
    public Intersection(int numberOfIntersections){
        previous = new Intersection[numberOfIntersections];
    }
}
