/*
 * Mady by: Monica
 */

import java.util.ArrayList;

/**
 * Graph class represents a Graph object using a 2D integer array, with string
 * names to represent each vertex.
 * 
 * @author Tom Magliery
 * @author Monica 
 * @version 37
 */
public class Graph {

    /** Number of vertices in the graph */
    private int numVertices = 0;

    /** Adjacency matrix representation of the edges */
    private int[][] adjMatrix;

    /** Flag to indicate if this is a directed graph */
    private boolean directed = false;

    /** Array of flags for the vertices - used by DFS and BFS algorithms */
    private boolean[] visited;

    /**
     * Arraylist of strings for the vertices names - used for DFS and Topological
     * Sort order algorithm
     */
    private ArrayList<String> verticesNames = new ArrayList<>();

    /**
     * Arraylist of integers for the vertices in DFS order - used for DFS algorithm
     */
    private ArrayList<Integer> visitedVerticesOrder = new ArrayList<>();

    /**
     * Arraylist of integers for the vertices in Topological Sort order - used for
     * Topological Sort order algorithm
     */
    private ArrayList<Integer> topologicalVerticesOrder = new ArrayList<>();

    /**
     * Create a new Graph object.
     * 
     * @param N - number of vertices in the graph.
     */
    public Graph(int N) {
        // Set number of vertices equal to the number parameter
        numVertices = N;

        // Initialize the adjacency matrix using a helper setup method
        setupAdjacencyMatrix(N);
    }

    /**
     * Create a new Graph object.
     * 
     * @param vertices - ArrayList of string names for the graph.
     */
    public Graph(ArrayList<String> vertices) {
        // Set private Arraylist variable equal to the values in the Arraylist parameter
        verticesNames = vertices;

        // Store the size of the Arraylist as the number of vertices in the graph
        numVertices = verticesNames.size();

        // Initialize the adjacency matrix using the Arraylist size and a helper setup
        // method
        setupAdjacencyMatrix(numVertices);
    }

    /**
     * Helper method for the Grpah constructor.
     * Sets up the 2D integer array as an empty adjacency matrix.
     * 
     * @param N - number of vertices in the graph.
     */
    private void setupAdjacencyMatrix(int N) {
        // Set number of vertices equal to the number parameter
        numVertices = N;

        // Initially the graph has no edges ("empty" adjacency matrix)
        adjMatrix = new int[N][N];

        // Set each value in the 2D array to 0 (no edges)
        for (int u = 0; u < N; u++) {
            for (int v = 0; v < N; v++) {
                adjMatrix[u][v] = 0;
            }
        }

        // Mark all vertices as un-visited (although the algorithms using it
        // should also enforce it themselves as needed)
        visited = new boolean[N];
        setAllVisitedFlags(false);
    }

    /**
     * Set the state of whether this graph is directed or undirected.
     */
    public void setDirected(boolean val) {
        // Set directed variable to the boolean parameter
        directed = val;
        return;
    }

    /**
     * Return true if this is a directed graph, false if it's undirected.
     * 
     * @param val - boolean (true: directed, false: undirected)
     */
    public boolean isDirected() {
        // Return value of directed
        return directed;
    }

    /**
     * Sets the "visited" flags of all the vertices to the specified value.
     * 
     * @param flag - boolean representing visited (true) or unvisited (false)
     */
    private void setAllVisitedFlags(boolean flag) {
        // Loop through each index in the visited boolean array
        for (int v = 0; v < numVertices; v++) {
            // Set the current value to the flag parameter
            visited[v] = flag;
        }
        return;
    }

    /**
     * If graph is directed, add one new edge to the graph, an edge from vertex
     * nameU to nameV.
     * If graph is undirected, add 2 new edges to the graph, an edge from vertex
     * nameU to nameV, and an edge from vertex nameV to nameU.
     * 
     * @param nameU - string, name associated with vertex u
     * @param nameV - string, name associated with vertex v
     */
    public void addEdge(String nameU, String nameV) {
        if (!directed) {
            // If the graph is undirected, we need two entries in the matrix
            adjMatrix[verticesNames.indexOf(nameU)][verticesNames.indexOf(nameV)] = 1;
            adjMatrix[verticesNames.indexOf(nameV)][verticesNames.indexOf(nameU)] = 1;
        } else {
            // For directed graphs, we only need one entry in the matrix
            adjMatrix[verticesNames.indexOf(nameU)][verticesNames.indexOf(nameV)] = 1;
        }
    }

    /**
     * Return the degree of a vertex if the graph is undirected.
     * For directed graphs this method is irrelevant and returns -1.
     * 
     * @param v - int, a vertex in the adjacency matrix
     * @return count - int, degree of this vertex
     */
    public int degree(int v) {
        if (directed) {
            // Directed graphs don't have a degree
            return -1;

        } else {
            // Stores degree sum
            int count = 0;

            // Loop through all neighbour vertices
            for (int i = 0; i < numVertices; i++) {
                // If current value is 1, it has been visited
                if (adjMatrix[v][i] > 0) {
                    count++;
                }
            }

            // Return the degree
            return count;
        }
    }

    /**
     * Return the indegree of the given vertex.
     * Will return -1 if called on an undirected graph.
     * 
     * @param v - int, a vertex in the adjacency matrix
     * @return count - int, in degree of this vertex
     */
    public int inDegree(int v) {
        if (!directed) {
            // Undirected graphs don't have a degree
            return -1;

        } else {
            // Stores in degree sum
            int count = 0;

            // Loop through all neighbour vertices
            for (int i = 0; i < numVertices; i++) {
                // If current value is 1, it has been visited
                if (adjMatrix[i][v] > 0) {
                    count++;
                }
            }

            // Return the in degree
            return count;
        }
    }

    /**
     * Return the outdegree of the given vertex.
     * Will return -1 if called on an undirected graph.
     * 
     * @param v - int, a vertex in the adjacency matrix
     * @return count - int, out degree of this vertex
     */
    public int outDegree(int v) {
        if (!directed) {
            // Undirected graphs don't have a degree
            return -1;

        } else {
            // Stores out degree sum
            int count = 0;

            // Loop through all neighbour vertices
            for (int i = 0; i < numVertices; i++) {
                // If current value is 1, it has been visited
                if (adjMatrix[v][i] > 0) {
                    count++;
                }
            }

            // Return the out degree
            return count;
        }
    }

    /**
     * Produce a string that displays the adjacency matrix for the graph.
     * 
     * @return str - string, adjacency matrix string of the graph
     */
    public String toString() {
        // Stores a string of the graph's adjacency matrix and appropriate degree values
        // (in degree, out degree, or degree)
        String str = "Adjacency matrix:\n";

        // Loop through all vertices and append their value to the string
        for (int u = 0; u < numVertices; u++) {
            for (int v = 0; v < numVertices; v++) {
                str += Integer.toString(adjMatrix[u][v]) + " ";
            }
            str += "\n";
        }

        if (!directed) {
            // If graph is undirected, it has a degree
            str += "Vertex degrees: ";

            // Loop through all vertices and append their degree values to the string
            for (int v = 0; v < numVertices; v++) {
                str += Integer.toString(degree(v)) + ",";
            }
            str += "\n";
            return str;

        } else {
            // If graph is directed, it has an in degree and out degree
            str += "In-degrees: ";
            // Loop through all vertices and append their in degree values to the string
            for (int v = 0; v < numVertices; v++) {
                str += Integer.toString(inDegree(v)) + ",";
            }

            str += "\nOut-degrees: ";
            // Loop through all vertices and append their out degree values to the string
            for (int v = 0; v < numVertices; v++) {
                str += Integer.toString(outDegree(v)) + ",";
            }
            str += "\n";
            return str;
        }
    }

    /**
     * Perform a Depth-First Search on the graph.
     * Gets both the DFS order and Topological Sort order of the graph.
     */
    public void DFS() {
        // Set initial visited values for each vertex to false
        setAllVisitedFlags(false);

        // Loop through all vertices
        for (int v = 0; v < numVertices; v++) {
            // If the current vertex hasn't been visited
            if (!visited[v]) {
                // Call helper method to visit the vertexx
                helperDFS(v);
            }
        }
        return;
    }

    /**
     * Helper function that performs the recursive aspect of DFS.
     * Store the visited vertices in two Arraylist variables in the graph object.
     * Stores both the DFS order and Topological Sort order of the graph.
     * 
     * @param v - int, a vertex in the adjacency matrix
     */
    private void helperDFS(int v) {
        // Add vertex to DFS order
        visitedVerticesOrder.add(v);

        // Visit this vertex
        visited[v] = true;

        // Loop through this vertex's adjacent nodes
        for (int w = 0; w < numVertices; w++) {
            if (adjMatrix[v][w] > 0) {
                // If the current adjacent node hasn't been visited
                if (!visited[w]) {
                    // Call helper method to visit this node
                    helperDFS(w);
                }
            }
        }

        // Add vertex to dead end order
        topologicalVerticesOrder.add(v);

        return;
    }

    /**
     * Returns the DFS order of the graph as a string.
     * 
     * @return dfsOrderString - string of the vertices in DFS order
     */
    public String GetDFSOrderAsString() {
        // Store the vertices in DFS order in a string
        String dfsOrderString = "";

        // Loop through each vertex
        for (Integer currVertex : visitedVerticesOrder) {
            // Append current vertex's name to the string
            dfsOrderString += "Visiting vertex " + verticesNames.get(currVertex) + "\n";
        }

        // Return DFS order in a string
        return dfsOrderString;
    }

    /**
     * Returns the Topological Sort order of the graph as a string.
     * 
     * @return topoSortOrderString - string of the vertices in topological sorted
     *         order
     */
    public String GetTopoSortAsString() {
        // Store the vertices in Topological Sort order in a string
        String topoSortOrderString = "";

        // Loop through each vertex in reverse order
        for (int index = topologicalVerticesOrder.size() - 1; index >= 0; index--) {
            // Append current vertex's name to the string
            Integer currVertexNumber = topologicalVerticesOrder.get(index);
            topoSortOrderString += "Visiting vertex " + verticesNames.get(currVertexNumber) + "\n";
        }

        // Return Topological Sort order in a string
        return topoSortOrderString;
    }

}
