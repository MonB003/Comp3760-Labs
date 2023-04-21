/*
 * Made by: Monica
 * This program uses Graph algorithms.
 */

/**
 * Driver class with a main() method and helper functions used to create Graph
 * objects, call their methods, and print the sample graphs from the lab
 * instructions.
 */
public class DriverLab6 {

    /**
     * Creates the first adjacency matrix from part 2 into a graph object.
     * 
     * @return graph
     */
    static GraphLab6 createGraph1() {
        // Create a graph object
        GraphLab6 graph1 = new GraphLab6(5);

        // Make the graph undirected by setting its directed variable to false
        graph1.setDirected(false);

        // Add the appropriate edges based on the adjancency matrix in the instructions
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 3);
        graph1.addEdge(0, 4);
        graph1.addEdge(2, 1);
        graph1.addEdge(3, 2);
        graph1.addEdge(4, 1);
        graph1.addEdge(4, 3);

        // Return the graph object
        return graph1;
    }

    /**
     * Creates the second adjacency matrix from part 2 into a graph object.
     * 
     * @return graph
     */
    static GraphLab6 createGraph2() {
        // Create a graph object
        GraphLab6 graph2 = new GraphLab6(4);

        // Make the graph undirected by setting its directed variable to false
        graph2.setDirected(false);

        // Add the appropriate edges based on the adjancency matrix in the instructions
        graph2.addEdge(0, 1);
        graph2.addEdge(2, 1);
        graph2.addEdge(3, 2);

        // Return the graph object
        return graph2;
    }

    /**
     * Creates the third adjacency matrix from part 2 into a graph object.
     * 
     * @return graph
     */
    static GraphLab6 createGraph3() {
        // Create a graph object
        GraphLab6 graph3 = new GraphLab6(6);

        // Make the graph undirected by setting its directed variable to false
        graph3.setDirected(false);

        // Add the appropriate edges based on the adjancency matrix in the instructions
        graph3.addEdge(0, 2);
        graph3.addEdge(0, 4);
        graph3.addEdge(1, 3);
        graph3.addEdge(1, 5);
        graph3.addEdge(2, 4);
        graph3.addEdge(3, 5);

        // Return the graph object
        return graph3;
    }

    /**
     * Creates the adjacency matrix from part 4 into a directed graph object.
     * 
     * @return graph
     */
    static GraphLab6 createGraphPart4Direct() {
        // Create a graph object
        GraphLab6 graph = new GraphLab6(5);

        // Make the graph directed by setting its directed variable to true
        graph.setDirected(true);

        // Add the appropriate edges based on the adjancency matrix in the instructions
        graph.addEdge(0, 0);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(0, 4);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);
        graph.addEdge(4, 3);

        // Return the graph object
        return graph;
    }

    /**
     * Creates the adjacency matrix from part 5 into a graph object.
     * 
     * @return graph
     */
    static GraphLab6 createGraphPart5() {
        // Create a graph object
        GraphLab6 graph = new GraphLab6(8);

        // Make the graph undirected by setting its directed variable to false
        graph.setDirected(false);

        // Add the appropriate edges based on the adjancency matrix in the instructions
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 4);
        graph.addEdge(1, 3);
        graph.addEdge(1, 5);
        graph.addEdge(2, 3);
        graph.addEdge(2, 6);
        graph.addEdge(3, 7);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);

        // Return the graph object
        return graph;
    }

    /**
     * Creates the adjacency matrix from the another sample section into a graph
     * object.
     * 
     * @return graph
     */
    static GraphLab6 createGraphAnotherSample() {
        // Create a graph object
        GraphLab6 graph = new GraphLab6(8);

        // Make the graph undirected by setting its directed variable to false
        graph.setDirected(false);

        // Add the appropriate edges based on the adjancency matrix in the instructions
        graph.addEdge(0, 1); // ab
        graph.addEdge(0, 4); // ae
        graph.addEdge(0, 5); // af
        graph.addEdge(1, 5); // bf
        graph.addEdge(1, 6); // bg
        graph.addEdge(2, 3); // cd
        graph.addEdge(2, 6); // cg
        graph.addEdge(3, 7); // dh
        graph.addEdge(4, 5); // ef
        graph.addEdge(6, 7); // gh

        // Return the graph object
        return graph;
    }

    /*
     * Main method that runs the program and calls the toString, inDegree,
     * outDegree, degree, DFS, and BFS methods on 3 graphs.
     * NOTE: Graphs 1,2,3 are from the part 2 examples of the lab instructions.
     * Graph 4 is from part 4 and graph 5 is from part 5 of the lab instructions.
     * NOTE: this file assumes my Graph.java class file is in the same directory.
     */
    public static void main(String[] args) {
        // Create Graph objects to call methods
        GraphLab6 graph1 = createGraph1();
        GraphLab6 graph2 = createGraph2();
        GraphLab6 graph3 = createGraph3();
        GraphLab6 graphP4Direct = createGraphPart4Direct();
        GraphLab6 graphP5 = createGraphPart5();

        // Display the output for part 2: print the toString() method of 3 graphs
        System.out.println("---OUTPUT FOR PART 2---");

        // Print the toString() method of graph 1
        System.out.println("Adjacency matrix for graph 1:");
        System.out.println(graph1.toString());

        // Print the toString() method of graph 2
        System.out.println("Adjacency matrix for graph 2:");
        System.out.println(graph2.toString());

        // Print the toString() method of graph 3
        System.out.println("Adjacency matrix for graph 3:");
        System.out.println(graph3.toString());

        // Display the output for part 3: make at least 5 calls to degree() method
        System.out.println("---OUTPUT FOR PART 3---");

        // Print results of 2 different vertices in the degree() method for graph 1
        System.out.println("Degree for graph 1 (vertex 0):");
        System.out.println(graph1.degree(0));
        System.out.println("Degree for graph 1 (vertex 2):");
        System.out.println(graph1.degree(2));

        // Print results of degree() method for graph 2
        System.out.println("Degree for graph 2 (vertex 0):");
        System.out.println(graph2.degree(0));

        // Print results of degree() method for graph 3
        System.out.println("Degree for graph 3 (vertex 0):");
        System.out.println(graph3.degree(0));

        // Print results of degree() method for graph 5
        System.out.println("Degree for graph 5 (vertex 0):");
        System.out.println(graphP5.degree(0));

        /*
         * Display the output for part 4: 
         * The adjacency matrix of the directed graph (graph 4)
         * Results of at least 2 calls to inDegree() and outDegree() on the directed
         * graph
         * Results of invalid calls to all three of the degree methods
         */
        System.out.println("---OUTPUT FOR PART 4---");

        // Print adjacency matrix of directed graph 4
        System.out.println("Adjacency matrix for part 4 sample directed graph:");
        System.out.println(graphP4Direct.toString());

        // Print results of 2 calls to inDegree() and outDegree() methods for directed
        // graph
        System.out.println("In Degree for a directed graph (graph 4, vertex 0):");
        System.out.println(graphP4Direct.inDegree(0));
        System.out.println("In Degree for a directed graph (graph 4, vertex 1):");
        System.out.println(graphP4Direct.inDegree(1));
        System.out.println("Out Degree for a directed graph (graph 4, vertex 0):");
        System.out.println(graphP4Direct.outDegree(0));
        System.out.println("Out Degree for a directed graph (graph 4, vertex 1):");
        System.out.println(graphP4Direct.outDegree(1));

        // Print results of invalid calls to all three of the degree methods
        System.out.println("In Degree of an undirected graph (invalid):");
        System.out.println(graph1.inDegree(0));
        System.out.println("Out Degree of an undirected graph (invalid):");
        System.out.println(graph1.outDegree(0));
        System.out.println("Degree of a directed graph (invalid):");
        System.out.println(graphP4Direct.degree(0));

        // Display the output for part 5: print adjacency matrix and perform depth-first
        // search on graph 5
        System.out.println("---OUTPUT FOR PART 5---");

        // Print adjacency matrix for the part 5 sample graph
        System.out.println("Adjacency matrix for part 5 graph:");
        System.out.println(graphP5.toString());

        // Call DFS method, which prints the vertex labels in the order that they are
        // visited
        System.out.println("Performing DFS on graph part 5:");
        graphP5.DFS();

        // Display the output for part 6: perform breadth-first search on graph from part 5
        System.out.println("---OUTPUT FOR PART 6---");
        System.out.println("Performing BFS on graph part 5:");
        graphP5.BFS();

        // NOTE: uncomment this to view the adjacency matrix, and run DFS and BFS on the
        // another sample graph for the lab instructions
        GraphLab6 graphSample = createGraphAnotherSample();
        System.out.println("Adjacency matrix for another sample graph:");
        System.out.println(graphSample.toString());
        System.out.println("Performing DFS on another sample graph:");
        graphSample.DFS();
        System.out.println("Performing BFS on another sample graph:");
        graphSample.BFS();
    }
}
