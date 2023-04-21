/*
 * Made by: Monica
 * This program uses Graph algorithms with labels for names. This builds off of Lab 6.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Driver class with a main() method and helper functions used to create Graph
 * objects, call their methods, and print the sample graphs from the lab
 * instructions.
 * 
 * @author Monica
 * @version 1
 */
public class Driver {

    /**
     * Creates the first example graph into a graph object.
     * 
     * @return graph - new Graph object
     */
    static Graph createGraph1() {
        // Create list of vertices
        ArrayList<String> list1 = new ArrayList<>();
        List<String> list1Values = Arrays.asList("a", "b", "c", "d", "e", "f");
        list1.addAll(list1Values);

        // Create a graph object with list of vertices
        Graph Graph1 = new Graph(list1);

        // Make directed graph
        Graph1.setDirected(true);

        // Add edges to the graph
        Graph1.addEdge("a", "b");
        Graph1.addEdge("a", "e");
        Graph1.addEdge("a", "f");
        Graph1.addEdge("b", "c");
        Graph1.addEdge("d", "b");
        Graph1.addEdge("d", "c");
        Graph1.addEdge("e", "d");
        Graph1.addEdge("f", "c");
        Graph1.addEdge("f", "e");

        // Return the graph object
        return Graph1;
    }

    /**
     * Creates the second example graph into a graph object.
     * 
     * @return graph - new Graph object
     */
    static Graph createGraph2() {
        // Create list of vertices
        ArrayList<String> list2 = new ArrayList<>();
        List<String> list2Values = Arrays.asList("w", "x", "y", "z");
        list2.addAll(list2Values);

        // Create a graph object with list of vertices
        Graph Graph2 = new Graph(list2);

        // Make directed graph
        Graph2.setDirected(true);

        // Add edges to the graph
        Graph2.addEdge("w", "x");
        Graph2.addEdge("w", "y");
        Graph2.addEdge("w", "z");
        Graph2.addEdge("x", "z");
        Graph2.addEdge("y", "z");

        // Return the graph object
        return Graph2;
    }

    /**
     * Creates the third example graph into a graph object.
     * 
     * @return graph - new Graph object
     */
    static Graph createGraph3() {
        // Create list of vertices
        ArrayList<String> list3 = new ArrayList<>();
        List<String> list3Values = Arrays.asList("socks", "shoes", "shirt", "suspenders", "pants", "belt",
                "tie", "jacket", "underwear");
        list3.addAll(list3Values);

        // Create a graph object with list of vertices
        Graph Graph3 = new Graph(list3);

        // Make directed graph
        Graph3.setDirected(true);

        // Add edges to the graph
        Graph3.addEdge("socks", "shoes");
        Graph3.addEdge("shirt", "suspenders");
        Graph3.addEdge("pants", "suspenders");
        Graph3.addEdge("pants", "shoes");
        Graph3.addEdge("pants", "belt");
        Graph3.addEdge("shirt", "tie");
        Graph3.addEdge("shirt", "jacket");
        Graph3.addEdge("suspenders", "jacket");
        Graph3.addEdge("belt", "jacket");
        Graph3.addEdge("tie", "jacket");
        Graph3.addEdge("underwear", "pants");

        // Return the graph object
        return Graph3;
    }

    /**
     * Creates the fourth example graph into a graph object.
     * 
     * @return graph - new Graph object
     */
    static Graph createGraph4() {
        // Create list of vertices
        ArrayList<String> list4 = new ArrayList<>();
        List<String> list4Values = Arrays.asList("1", "2", "3", "4", "5", "6");
        list4.addAll(list4Values);

        // Create a graph object with list of vertices
        Graph Graph4 = new Graph(list4);

        // Make directed graph
        Graph4.setDirected(true);

        // Add edges to the graph
        Graph4.addEdge("1", "4");
        Graph4.addEdge("2", "1");
        Graph4.addEdge("2", "3");
        Graph4.addEdge("2", "4");
        Graph4.addEdge("4", "3");
        Graph4.addEdge("5", "1");
        Graph4.addEdge("5", "2");
        Graph4.addEdge("5", "6");
        Graph4.addEdge("6", "2");
        Graph4.addEdge("6", "3");

        // Return the graph object
        return Graph4;
    }

    /**
     * Creates the fifth example graph into a graph object.
     * 
     * @return graph - new Graph object
     */
    static Graph createGraph5() {
        // Create list of vertices
        ArrayList<String> list5 = new ArrayList<>();
        List<String> list5Values = Arrays.asList("a", "b", "c", "d", "e");
        list5.addAll(list5Values);

        // Create a graph object with list of vertices
        Graph Graph5 = new Graph(list5);

        // Make directed graph
        Graph5.setDirected(true);

        // Add edges to the graph
        Graph5.addEdge("a", "b");
        Graph5.addEdge("a", "c");
        Graph5.addEdge("b", "c");
        Graph5.addEdge("b", "e");
        Graph5.addEdge("c", "e");
        Graph5.addEdge("d", "a");
        Graph5.addEdge("d", "b");
        Graph5.addEdge("d", "c");
        Graph5.addEdge("d", "e");

        // Return the graph object
        return Graph5;
    }

    /*
     * Main method that runs the program and calls the toString and DFS methods on
     * the 5 example graphs.
     * NOTE: Graphs 1-5 are from the examples of the lab instructions.
     * NOTE: this file assumes my Graph.java class file is in the same directory.
     */
    public static void main(String[] args) {
        // Create Graph objects to call methods
        Graph Graph1 = createGraph1();
        Graph Graph2 = createGraph2();
        Graph Graph3 = createGraph3();
        Graph Graph4 = createGraph4();
        Graph Graph5 = createGraph5();

        // Print adjacency matrices of all of the graphs
        System.out.println(Graph1.toString());
        System.out.println(Graph2.toString());
        System.out.println(Graph3.toString());
        System.out.println(Graph4.toString());
        System.out.println(Graph5.toString());

        System.out.println("---------------------------------");
        // Perform DFS on graph 1
        Graph1.DFS();
        // Get DFS order of graph 1 and print result
        System.out.println("DFS order of graph 1:");
        System.out.println(Graph1.GetDFSOrderAsString());
        // Get Topological sort order of graph 1 and print result
        System.out.println("Topological sort order of graph 1:");
        System.out.println(Graph1.GetTopoSortAsString());

        System.out.println("---------------------------------");
        // Perform DFS on graph 2
        Graph2.DFS();
        // Get DFS order of graph 2 and print result
        System.out.println("DFS order of graph 2:");
        System.out.println(Graph2.GetDFSOrderAsString());
        // Get Topological sort order of graph 2 and print result
        System.out.println("Topological sort order of graph 2:");
        System.out.println(Graph2.GetTopoSortAsString());

        System.out.println("---------------------------------");
        // Perform DFS on graph 3
        Graph3.DFS();
        // Get DFS order of graph 3 and print result
        System.out.println("DFS order of graph 3:");
        System.out.println(Graph3.GetDFSOrderAsString());
        // Get Topological sort order of graph 3 and print result
        System.out.println("Topological sort order of graph 3:");
        System.out.println(Graph3.GetTopoSortAsString());

        System.out.println("---------------------------------");
        // Perform DFS on graph 4
        Graph4.DFS();
        // Get DFS order of graph 4 and print result
        System.out.println("DFS order of graph 4:");
        System.out.println(Graph4.GetDFSOrderAsString());
        // Get Topological sort order of graph 4 and print result
        System.out.println("Topological sort order of graph 4:");
        System.out.println(Graph4.GetTopoSortAsString());

        System.out.println("---------------------------------");
        // Perform DFS on graph 5
        Graph5.DFS();
        // Get DFS order of graph 5 and print result
        System.out.println("DFS order of graph 5:");
        System.out.println(Graph5.GetDFSOrderAsString());
        // Get Topological sort order of graph 5 and print result
        System.out.println("Topological sort order of graph 5:");
        System.out.println(Graph5.GetTopoSortAsString());
    }
}
