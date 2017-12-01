/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadsscholar;

import java.util.*;

/**
 *
 * @author Jeremy Tiberg and Nathan Herr
 */
public class RoadSignEntry implements Comparator<RoadSignEntry> {
    public String cityName;
    public int distance;
    public int compare(RoadSignEntry a, RoadSignEntry b){
        if(a.distance - b.distance != 0){
            return a.distance - b.distance;
        }
        else{
           return a.cityName.compareTo(b.cityName);
        }
    }
}
