package pathfinder.src;

import java.util.ArrayList;
import java.util.Comparator;

public class AStar {
  //TODO find reason for repeating current number
  private Field field;
  private Coord goal;
  private ArrayList<Node> OPENED = new ArrayList<Node>(), CLOSED = new ArrayList<Node>();

  public AStar(Field field, Coord start, Coord goal) {
    this.goal = goal;
    this.field = field;
    this.OPENED.add(new Node(start, goal, 0));
  }

  private Coord[] findNeighbors(Node center) {
    return Coord.intArrToCoord(new int[][] {{center.x-1, center.y}, {center.x+1, center.y}, {center.x, center.y+1}, {center.x, center.y-1}});
  }

  public Node calculate() {
    boolean finished = false;
    Node current = new Node();
    while (!finished) {
      current = OPENED
        .stream()
        .min(Comparator.comparing(x -> x.f))
        .get(); // TODO sort and take first value
      OPENED.remove(current);
      CLOSED.add(current);
      System.out.println(Coord.toString(current));

      if (current.equals(goal)) {
        finished = true;
        break;
      }

      // Coord[] neighbors = findNeighbors(current);
      // Arrays.asList(neighbors)
      //   .stream()
      //   .map(x -> new Node(x, goal, current.pathLength+1))
      //   .filter(x -> x.traversable(field))
      //   .filter(x -> x.inside(CLOSED))
      //   .filter(x -> !x.inside(OPENED) || x.pathLength < nNode.alreadyIn(OPENED).pathLength)
      //   .forEach(x -> x.setParent(current)
      //   .filter(x -> !x.inside(OPENED))
      //   .forEach(OPENED::add);

      for (Coord neighbor: findNeighbors(current)) {
        Node nNode = new Node(neighbor, goal, current.pathLength+1);
        if (!nNode.traversable(field) || nNode.inside(CLOSED)) {
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