import AStar;
import Node;
import Field;

class Main {
  public static void main(String[] args) {
    
    //   0, 0, 0, 1, 0
    //   0, 0, 0, 0, 0
    //   0, 0, 0, 0, 0
    //   0, 3, 0, 0, 0
    //   0, 1, 0, 0, 2

    Coord start = new Coord(4, 4);
    Coord goal = new Coord(1, 3);
    Field map = new Field(5, 5, Coord.intArrToCoord(new int[][] {{1, 4}, {3, 0}}));

    AStar route = new AStar(map, start, goal);
    Node res = route.calculate();

    System.out.println("Res: " + res.toString() + " Length: " + res.pathLength);
  }
}