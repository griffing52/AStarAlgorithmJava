package pathfinder.src;

public class App {
  public static void main(String[] args) {
    
    //[  0, 0, 0, 1, 0
    //   0, 0, 0, 0, 0
    //   0, 0, 0, 0, 0
    //   0, 3, 1, 0, 0
    //   0, 1, 0, 0, 2

    // Coord start = new Coord(4, 4);
    // Coord goal = new Coord(1, 3);
    // Field map = new Field(5, 5, Coord.intArrToCoord(new int[][] {{1, 4}, {2, 3}, {3, 0}}));
    
    // AStar route = new AStar(map, start, goal);
    // Node res = route.calculate();
    
    // int[][] arr = {
    //     {0, 1, 0, 1, 0},
    //     {0, 0, 0, 0, 1},
    //     {1, 0, 1, 0, 1},
    //     {0, 0, 1, 0, 0},
    //     {3, 1, 0, 0, 2}
    // };
    int[][] arr = {
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
        {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0},
        {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
        {0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
        {0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };
    // int[][] arr = {
    //     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 3, 1, 0},
    //     {1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0},
    //     {0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0},
    //     {0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1},
    //     {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0},
    //     {0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
    //     {1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
    //     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    //     {1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    //     {0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
    //     {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    //     {0, 1, 2, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    // };

    AStar route = new ArrayToAStar(arr).route;
    Node res = route.calculate();

    System.out.println("Res: " + res.pathLength);
    String str = "";
    Node last = res.parent;
    for (int i = 0; i < res.pathLength-1; i++) {
        arr[last.y][last.x] = 4;
        last = last.parent;
    }
    for (int[] row: arr) {
      for (int point: row) {
        str += point + " ";
      }
      str += "\n";
    }
    System.out.println(str);
    // System.out.println(Coord.toString(res));
    // Node last = res;
    // for (int i = 0; i < res.pathLength; i++) {
    //     System.out.println(Coord.toString(last.parent));
    //     last = last.parent;
    // }
  }
}