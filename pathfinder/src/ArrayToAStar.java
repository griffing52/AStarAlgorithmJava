package pathfinder.src;

// 1 == obstacle, 2 == start, 3 == goal

public class ArrayToAStar {
    public AStar route;
    public ArrayToAStar(int[][] arr) {
        Coord start = new Coord();
        Coord goal = new Coord();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                switch (arr[i][j]) {
                    case 2:
                        start.set(j, i);
                    case 3:
                        goal.set(j, i);
                }
            }
        }
        
        Field map = Field.ArrayToField(arr);
    
        route = new AStar(map, start, goal);
    }
}
