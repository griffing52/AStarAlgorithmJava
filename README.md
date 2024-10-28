# AStarAlgorithmJava

## Project Overview
This Java project visualizes the pathfinding process of the A* algorithm on a grid. The program finds the shortest path from a starting point to a goal point, marking each step in the path and displaying the result. The grid layout and path progression are printed to the console, and an image representation is generated for easier visualization.

## Features
- **A\* Algorithm Implementation:** Efficient pathfinding using the A* algorithm, balancing cost and distance to find the shortest path.
- **Console Visualization:** Outputs the grid to the console, with symbols indicating path (`-`), obstacles (`*`), and free space.
- **Image Representation:** Generates an image that visualizes the path from the starting node to the goal.

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/AStarVisualization.git```
2.  Open the project in a Java IDE (e.g., IntelliJ IDEA, Eclipse).
3.  Ensure Java Development Kit (JDK) 11 or higher is installed.

Usage
-----

1.  Initialize a 2D array `arr`, where:
    -   `0` represents open paths,
    -   `1` represents obstacles, and
    -   other values can be customized as needed.
2.  Run the following main code block to calculate the path and display the visualization:

    java

    Copy code

    `AStar route = new ArrayToAStar(arr).route;
    Node res = route.calculate();

    // Outputs the path length and grid with the path marked
    System.out.println("Result path length: " + res.pathLength);
    new Image(arr);`

3.  The program will output the grid with the path marked by `-` characters and obstacles by `*`.

Class Structure
---------------

### AStar.java

-   **Purpose:** Implements the A* pathfinding algorithm.
-   **Key Attributes:**
    -   `OPENED` and `CLOSED` - Lists tracking nodes to evaluate and those already processed.
    -   `goal`, `start` - Starting and goal coordinates.
-   **Key Methods:**
    -   `calculate()` - Main function that finds the shortest path, updating the `OPENED` and `CLOSED` lists until the goal is reached.

### Node.java

-   **Purpose:** Represents each position in the grid, with properties like coordinates, path length, and parent nodes for backtracking.
-   **Key Methods:**
    -   `findNeighbors()` - Identifies adjacent nodes for movement.
    -   `traversable()` - Checks if a node is accessible.
    -   `setParent()` - Links nodes to allow backtracking.

### ArrayToAStar.java

-   **Purpose:** Converts a 2D array grid into the necessary AStar data structure, setting up initial nodes.

Output Example
--------------

After running the program, the console will display the grid. Each symbol represents:

-   `-` : Part of the calculated path
-   `*` : Obstacles
-   `0` : Free spaces

Sample output:

Copy code

`0 0 0 * 0
0 - - - 0
0 * * - 0
0 - - - 0
0 0 0 0 0`

Customization
-------------

-   Modify the `arr` array to set up different grid configurations.
-   Change start and goal positions in `AStar` to explore different paths.

License
-------

Distributed under the MIT License. See `LICENSE` for more information.
