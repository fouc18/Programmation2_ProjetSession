package Tests;

import java.util.ArrayList;
import java.util.Arrays;

import Code.Gps;

public class GpsTest {

    public static void main( String[] args ) {
    	
        Gps g = new Gps(2,4);
        
        g.calculeItineraire(2);
        
        System.out.println(g.getCheminRoute().toString());
    }
}
