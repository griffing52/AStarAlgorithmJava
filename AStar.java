import Node;
import Field;
import java.util.ArrayList;

public class AStar {
  private Field field;
  private Coord goal;
  private ArrayList<Node> OPENED, CLOSED;

  public AStar(Field field, Coord start, Coord goal) {
    this.goal = goal;
    this.field = field;
    this.OPENED.add(new Node(start, goal, 0));
  }

  private Coord[] findNeighboors(Node center) {
    return Coord.intArrToCoord(new int[][] {{center.x-1, center.y}, {center.x+1, center.y}, {center.x, center.y+1}, {center.x, center.y-1}});
  }

  public Node calculate() {
    boolean finished = false;
    Node current = new Node();
    while (!finished) {
      Node lowest = new Node();
      for (Node point: OPENED) {
        if (point.f < lowest.f) {
          lowest = point;
        }
      }
      current = lowest;
      OPENED.remove(current);

      if (current.x == this.goal.x && current.y == this.goal.y) {
        finished = true;
        break;
      }

      for (Coord neighboor: findNeighboors(current)) {
        nNode = new Node(neighboor, goal, current.pathLength+1);
        if (!nNode.traversable(field) || CLOSED.contains(nNode)) {
          continue;
        }

        if (!OPENED.contains(nNode) || nNode.pathLength < nNode.alreadyIn(OPENED).pathLength) {
          nNode.setParent(current);
          if (!OPENED.contains(nNode)) {
            OPENED.add(nNode);
          }
        }
      }
    }
    return current;
  }
}