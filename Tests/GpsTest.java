package Tests;



import java.util.ArrayList;
import java.util.Arrays;

import Code.Gps;

public class GpsTest extends Gps {

    public static void main( String[] args ) {
        Gps g = new Gps();
        
        g.calculeItineraire();
        
        System.out.print(g.getCheminRoute().toString());
    }

}
