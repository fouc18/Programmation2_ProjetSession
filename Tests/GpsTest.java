package Tests;

import java.util.ArrayList;
import java.util.Arrays;

import Code.Gps;

public class GpsTest {

    public static void main( String[] args ) {
    	
        Gps g = new Gps(4,4);
        
        g.calculeItineraire(4);
        
        System.out.println(g.getCheminRoute().toString());
    }
}
