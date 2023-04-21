/*
 * Made by: Monica
 */

import java.util.ArrayList;

/**
 * Graph class represents a graph object.
 */
public class GraphLab6 {
    /**
     * 2D array to store the adjacency matrix.
     */
    private int adjacencyMatrix[][];

    /**
     * Directed variable stores whether or not a graph object is directed or
     * undirected.
     * If directed is true, it's directed. If directed is false, it's undirected.
     */
    private boolean directed = false;

    /**
     * Graph constructor for a graph object.
     * Sets the adjacency matrix array size to VxV with zero edges.
     * 
     * @param V: int, number of vertices
     */
    public GraphLab6(int V) {
        adjacencyMatrix = new int[V][V];
    }

    /**
     * Adds an edge to the graph from vertex u to vertex v.
     * An edge is represented as 1.
     * If the graph is directed, it only adds an edge from vertex u to vertex v.
     * If the graph is undirected, it adds an edge from vertex u to vertex v, and an
     * edge from vertex v to vertex u.
     * Prints an error message if vertex u or v is not within the valid range of 0
     * to V-1.
     * 
     * @param u: int, in the range of 0 to V-1
     * @param v: int, in the range of 0 to V-1
     */
    public void addEdge(int u, int v) {
        // Check if u value is invalid
        if (u > adjacencyMatrix.length - 1) {
            System.out.println("Invalid first vertex for: " + u);
            return;
        }

        // Check if v value is invalid
        if (v > adjacencyMatrix.length - 1) {
            System.out.println("Invalid second vertex for: " + v);
            return;
        }

        // Add a 1 (represents an edge) to the matrix in row u, column v
        adjacencyMatrix[u][v] = 1;

        // Check if graph is undirected
        if (!isDirected()) {
            // Add a 1 to the matrix in row v, column u
            adjacencyMatrix[v][u] = 1;
        }
    }

    /**
     * Returns a string that represents the adjacency matrix with each line
     * indicating the neighbours for a vertex.
     * 
     * @return matrixString: string of the adjacency matrix array
     */
    public String toString() {
        // matrixString stores the final adjacency matrix as a string
        String matrixString = "";

        // Loop through each row and column value in the matrix and append it to
        // matrixString
        for (int row = 0; row < adjacencyMatrix.length; row++) {
            for (int column = 0; column < adjacencyMatrix.length; column++) {
                // Append the current matrix value
                matrixString += adjacencyMatrix[row][column] + " ";
            }
            // After each line add a newline to start the next row
            matrixString += "\n";
        }

        // Return adjacency matrix string
        return matrixString;
    }

    /**
     * Getter method for the directed instance variable.
     * 
     * @return directed: boolean that represents if the graph is directed or
     *         undirected
     */
    public boolean isDirected() {
        // If the graph is directed, return true. If graph is undirected, return false.
        return directed;
    }

    /**
     * Setter method for the directed instance variable.
     * 
     * @param directed: boolean that represents if the graph is directed or
     *                  undirected
     */
    public void setDirected(boolean directed) {
        // Set the value of the parameter to the directed instance variable
        this.directed = directed;
    }

    /**
     * Returns the degree of a vertex v.
     * If the graph is directed, it returns -1.
     * If the graph is undirected, it calculates and returns the degree.
     * 
     * @param v: int, vertex
     * @return degreeSum: sum of all edges of vertex v
     */
    public int degree(int v) {
        // Only undirected graphs have a degree
        if (isDirected()) {
            // If graph is directed, return -1 because it doesn't have a degree
            return -1;
        }

        // Stores the sum of the degree
        int degreeSum = 0;

        // Loop through row "v" and increment degreeSum every time there is a value of 1
        for (int index = 0; index < adjacencyMatrix.length; index++) {
            // Check if current matrix index value is 1
            if (adjacencyMatrix[v][index] == 1) {
                // Increment degreeSum
                degreeSum++;
            }
        }

        // Loop through column "v" and increment degreeSum every time there is a value
        // of 1
        for (int index = 0; index < adjacencyMatrix.length; index++) {
            // Check if current matrix index value is 1
            if (adjacencyMatrix[index][v] == 1) {
                // Increment degreeSum
                degreeSum++;
            }
        }

        // Edge case for the value in row "v", column "v"
        if (adjacencyMatrix[v][v] == 1) {
            degreeSum++;
        }

        // Return value of the degree
        return degreeSum;
    }

    /**
     * Calculates the in degree of a vertex.
     * The in degree is the number of edges coming to the vertex.
     * This is represented by a single column (column "v") in the matrix.
     * If the graph is directed, it calculates and returns the in degree.
     * If the graph is undirected, it returns -1.
     * 
     * @param v: int, vertex
     * @return inDegree: int, in degree of vertex v
     */
    public int inDegree(int v) {
        // Only directed graphs have an in degree
        if (!isDirected()) {
            // If graph is undirected, return -1 because it doesn't have an in degree
            return -1;
        }

        // Stores sum of in degree
        int inDegree = 0;

        // Loop through each value in column "v" (column value is constant) and check
        // each row's value
        for (int index = 0; index < adjacencyMatrix.length; index++) {
            // Check if current matrix index value is 1
            if (adjacencyMatrix[index][v] == 1) {
                // Increment inDegree
                inDegree++;
            }
        }

        // Return value of inDegree
        return inDegree;
    }

    /**
     * Calculates the out degree of a vertex.
     * The out degree is the number of edges coming out from the vertex.
     * This is represented by a single row (row "v") in the matrix.
     * If the graph is directed, it calculates and returns the out degree.
     * If the graph is undirected, it returns -1.
     * 
     * @param v: int, vertex
     * @return inDegree: int, in degree of vertex v
     */
    public int outDegree(int v) {
        // Only directed graphs have an out degree
        if (!isDirected()) {
            // If graph is undirected, return -1 because it doesn't have an out degree
            return -1;
        }

        // Stores sum of out degree
        int outDegree = 0;

        // Loop through each value in row "v" (row value is constant) and check each
        // column's value
        for (int index = 0; index < adjacencyMatrix.length; index++) {
            // Check if current matrix index value is 1
            if (adjacencyMatrix[v][index] == 1) {
                // Increment outDegree
                outDegree++;
            }
        }

        // Return value of out degree
        return outDegree;
    }

    /**
     * Performs the DFS algorithm on a graph.
     * Initializes a boolean array called visitVertices with false values for all
     * vertices.
     * Loops through each vertex edge in the adjacency matrix array.
     * Prints the visited vertices while the traversal is being performed.
     */
    public void DFS() {

        // Print message saying the algorithm
        System.out.println("DFS traversal of graph:");

        // Initialize boolean array visitVertices
        boolean visitVertices[] = new boolean[adjacencyMatrix.length];

        // Set each value to false for all vertices
        for (int index = 0; index < visitVertices.length; index++) {
            visitVertices[index] = false;
        }

        // Loop through each vertex in the adjacency matrix array and check if it has
        // been visited
        for (int index = 0; index < adjacencyMatrix.length; index++) {

            // If the current vertex has not visited
            if (visitVertices[index] == false) {

                // Call helperDFS method to visit the current vertex's adjacent vertices
                helperDFS(index, visitVertices);
            }
        }
    }

    /**
     * Helper method for DFS algorithm that visits a vertex's unvisited adjacent
     * vertices.
     * 
     * @param currVertex:    int, current vertex whose adjacent vertices will be
     *                       visited.
     * @param visitVertices: boolean array, array with boolean values to represent
     *                       if each vertex has been visited
     */
    public void helperDFS(int currVertex, boolean visitVertices[]) {

        // Visit the current vertex
        visitVertices[currVertex] = true;

        // Display the visited vertex to the console
        System.out.println("visiting vertex " + currVertex);

        // Loop through each vertex adjacent to the current vertex
        for (int index = 0; index < adjacencyMatrix.length; index++) {

            // If a vertex is adjacent to the parameter vertex and has not been visited
            if ((adjacencyMatrix[currVertex][index] == 1) && (visitVertices[index] == false)) {

                // Call helperDFS method to visit the vertex's adjacent vertices
                helperDFS(index, visitVertices);
            }
        }
    }

    /**
     * Performs the BFS algorithm on a graph.
     * Initializes a boolean array called visitVertices with false values for all
     * vertices.
     * Loops through each vertex edge in the adjacency matrix array.
     * Prints the visited vertices while the traversal is being performed.
     */
    public void BFS() {

        // Print message saying the algorithm
        System.out.println("BFS traversal of graph:");

        // Initialize boolean array visitVertices
        boolean visitVertices[] = new boolean[adjacencyMatrix.length];

        // Set each value to false for all vertices
        for (int index = 0; index < visitVertices.length; index++) {
            visitVertices[index] = false;
        }

        // Loop through each vertex in the matrix
        for (int index = 0; index < adjacencyMatrix.length; index++) {

            // If a vertex has not been visited
            if (visitVertices[index] == false) {

                // Call helperDFS method to visit all the vertex's adjacent vertices
                helperBFS(index, visitVertices);
            }
        }
    }

    /**
     * Helper method for BFS algorithm that visits all of a vertex's unvisited
     * adjacent
     * vertices.
     * 
     * @param vertex:        int, current vertex whose adjacent vertices will be
     *                       visited.
     * @param visitVertices: boolean array, array with boolean values to represent
     *                       if each vertex has been visited
     */
    public void helperBFS(int vertex, boolean visitVertices[]) {

        // Visit the parameter vertex
        visitVertices[vertex] = true;

        // Initialize a queue, represented by an Arraylist
        ArrayList<Integer> queue = new ArrayList<>();

        // Add parameter vertex to the queue
        queue.add(vertex);

        // Variable stores the current first value in the queue
        int currFirstValue = 0;

        // Loop while the queue is not empty
        while (!(queue.isEmpty())) {

            // Get the first vertex in the queue
            currFirstValue = queue.get(0);

            // Print the vertex being visited
            System.out.println("visiting vertex " + currFirstValue);

            // Remove first element
            queue.remove(queue.get(0));

            // Loop through each adjacent vertex to the head vertex (top vertex in the
            // queue)
            for (int index = 0; index < adjacencyMatrix.length; index++) {

                // If current vertex is adjacent and has not been visited
                if ((adjacencyMatrix[currFirstValue][index] == 1) && (visitVertices[index] == false)) {
                    // Visit the current vertex
                    visitVertices[index] = true;

                    // Add current vertex value (its index) to the queue
                    Integer currMatrixValue = Integer.valueOf(index);
                    queue.add(currMatrixValue);
                }
            }
        }
    }

}