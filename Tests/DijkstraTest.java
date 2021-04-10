package Tests;

import java.util.Arrays;

import Code.Dijkstra;

public class DijkstraTest {

	public DijkstraTest() {
		// TODO Auto-generated constructor stub
	}

	  public static void main(String[] args) throws  ArrayIndexOutOfBoundsException
	    {
	        int[][] adjacencyMatrix = { { 0, 5, 0, 0, 0, 1, 2, 0},
	                { 5, 0, 1, 0, 0, 0, 3, 0},
	                { 0, 1, 0, 6, 0, 0, 0, 3},
	                { 0, 0, 6, 0, 12, 0, 0, 6},
	                { 0, 0, 0, 12, 0, 3, 0, 4},
	                { 1, 0, 0, 0, 3, 0, 1, 0},
	                { 2, 3, 0, 0, 0, 1, 0, 10},
	                { 0, 0, 3, 6, 4, 0, 10, 0}};

	        //dijkstra(adjacencyMatrix, 0);
	        int distance0_3 = Dijkstra.distanceMin(adjacencyMatrix, 0, 7);
	        System.out.println(distance0_3);
	        int[] chemin0_3 = Dijkstra.cheminASuivre(adjacencyMatrix, 0, 7);
	        System.out.println(Arrays.toString(chemin0_3));
	    }

}
